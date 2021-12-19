/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package abc.oracle.apps.fnd.webui;

import abc.oracle.apps.fnd.server.TrainingAMImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.io.OutputStream;

import java.sql.SQLException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import oracle.apps.fnd.common.AppsContext;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OADBTransactionImpl;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

import oracle.apps.xdo.XDOException;
import oracle.apps.xdo.oa.common.DocumentHelper;
import oracle.apps.xdo.oa.schema.server.TemplateHelper;

import oracle.apps.xdo.oa.util.OAHelper;

import oracle.cabo.ui.data.DataObject;

import oracle.jbo.domain.BlobDomain;

import oracle.xml.parser.v2.XMLNode;

/**
 * Controller for ...
 */
public class InvokeXMLReportCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
    TrainingAMImpl am = (TrainingAMImpl)pageContext.getApplicationModule(webBean);
    
    // Get the Current Locale
    AppsContext appsContext = ((OADBTransactionImpl)am.getOADBTransaction()).getAppsContext();
    String locale = null;
    
    try {
        String as[] = OAHelper.getISOCodes(appsContext, appsContext.getCurrLangCode());
        locale = as[0]+"-"+as[1];
    } catch (SQLException e) {
        throw new OAException(e.getMessage(), (byte)0);
    }
    
    // Set the page context parameter required for datasource BlobDomain.
    pageContext.putParameter("p_DataSource"  ,DocumentHelper.DATA_SOURCE_TYPE_BLOB);
    pageContext.putParameter("p_DataSourceCode", "XXCUS_HRMS_EMP_REP");
    pageContext.putParameter("p_DataSourceAppsShortName", "FND");
    pageContext.putParameter("p_XDORegionHeight", "700");
    pageContext.putParameter("p_TemplateCode", "XXCUS_HRMS_EMP_REP");
    pageContext.putParameter("p_TemplateAppsShortName", "FND");
    pageContext.putParameter("p_Locale", locale);     
    
    }

    /**
     * Procedure to handle form submissions for form elements in
     * a region.
     * @param pageContext the current OA page context
     * @param webBean the web bean corresponding to the region
     */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean){
    super.processFormRequest(pageContext, webBean);
    
    TrainingAMImpl am = (TrainingAMImpl)pageContext.getApplicationModule(webBean);
    
//    if(pageContext.getParameter("GenInlineRep") != null){
    if(pageContext.getParameter("Go") != null){    
     XMLNode xmlNode = (XMLNode)am.invokeMethod("getXMLData");
     
     try{
         System.out.println("Inside inline report logic");
         //create a blob object and add XML data to it
         BlobDomain blob = new BlobDomain();
         OutputStream os = blob.getBinaryOutputStream();
         xmlNode.print(os);
         System.out.println(os.toString());
         os.close();
         pageContext.putSessionValueDirect("XML_DATA_BLOB", blob);
     }
     catch(Exception e){
         e.printStackTrace();
         throw new OAException(e.getMessage(), (byte)0);
     }
    }
    
    
    if(pageContext.getParameter("GenerateXML") != null){
        am.initGenerateXMLData();
    }
    else if(pageContext.getParameter("GenerateReport") != null){
        // Get the HttpServletResponse object from the pageContext
        // The report output is written to HttpServletResponse
        DataObject sessionDictionary = (DataObject)pageContext.getNamedDataObject("_SessionParameters");
        HttpServletResponse response = (HttpServletResponse)sessionDictionary.selectValue(null, "HttpServletResponse");
        
        try {
            ServletOutputStream servletOS = response.getOutputStream();
            // Set the output report file name and content type
            String contentDisposition = "attachment;filename=PerPeopleData.pdf";
            response.setHeader("Content-Disposition", contentDisposition);
            response.setContentType("application/pdf");
            
            // Get the XML Report data as the XML Node
            XMLNode xmlNode = (XMLNode)am.invokeMethod("getXMLData");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            xmlNode.print(outputStream);// xml data to outputStream
            System.out.println("****ByteArrayOutputStream****");
            System.out.println(outputStream.toString()); 
            // Data ready as outputStream
            
            // Start for TemplateHelper.processTemplate
            // Generate the PDF Report, Process template
            AppsContext appsContext = ((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getAppsContext();
            String applShortName = "FND";
            String templateShortCode = "XXCUS_HRMS_EMP_REP";
            String language = ((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getUserLocale().getLanguage();
            String country = ((OADBTransactionImpl)pageContext.getApplicationModule(webBean).getOADBTransaction()).getUserLocale().getCountry();
            // xml data output stream to be sent as inputstream for Template
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());       
            ByteArrayOutputStream templateOutputStream = new ByteArrayOutputStream();            
            
            TemplateHelper.processTemplate(appsContext
                                          ,applShortName
                                          ,templateShortCode
                                          ,language
                                          ,country
                                          ,inputStream
                                          ,TemplateHelper.OUTPUT_TYPE_PDF
                                          ,null
                                          ,templateOutputStream);
            // End for TemplateHelper.processTemplate  
            
            // Start: Write PDF Report to HttpServletResponse object and flush
            byte[] b = templateOutputStream.toByteArray();
            response.setContentLength(b.length);
            servletOS.write(b, 0, b.length);
            servletOS.flush();
            servletOS.close();
            templateOutputStream.flush();
            templateOutputStream.close();
            
            // End: Write PDF Report to HttpServletResponse object and flush
            
        } catch (Exception e) {
            response.setContentType("text/html");
            throw new OAException(e.getMessage(), OAException.ERROR);
        }
        
        pageContext.setDocumentRendered(true);
    }


 }                                                        

}
