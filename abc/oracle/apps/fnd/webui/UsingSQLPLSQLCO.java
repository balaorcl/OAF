/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package abc.oracle.apps.fnd.webui;

import abc.oracle.apps.fnd.server.TrainingAMImpl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.server.OADBTransaction;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageStyledTextBean;

import oracle.jdbc.OracleConnection;

/**
 * Controller for ...
 */
public class UsingSQLPLSQLCO extends OAControllerImpl
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
  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
    TrainingAMImpl am = (TrainingAMImpl)pageContext.getApplicationModule(webBean);
    
    if(pageContext.getParameter("voBtn") != null){
       String leIdStr = pageContext.getParameter("leID");
       am.initLEVO(leIdStr);
    }
    else if(pageContext.getParameter("funBtn") != null){
        String leIDStr = pageContext.getParameter("le2ID");   
        System.out.println("leIdStr="+leIDStr);        
        String leNameStr = am.invokeLEPLSQLFun(leIDStr);
        
        System.out.println("leNameStr="+leNameStr);
        OAMessageStyledTextBean leNameBean = (OAMessageStyledTextBean)webBean.findIndexedChildRecursive("le2Name");
        leNameBean.setValue(pageContext, leNameStr);
        
    }
    else if(pageContext.getParameter("proBtn") != null){
      String leIDStr = pageContext.getParameter("le3ID");   
      String leNameStr = am.invokeLEPLSQLPRO(leIDStr);
      
      System.out.println("leNameStr="+leNameStr);
      OAMessageStyledTextBean leNameBean = (OAMessageStyledTextBean)webBean.findIndexedChildRecursive("le3NameID");
      leNameBean.setValue(pageContext, leNameStr);
      
    }    
    else if(pageContext.getParameter("preBtn") != null){
        String leIDStr = pageContext.getParameter("le4ID");   
        String leNameStr = "";
        OAMessageStyledTextBean leNameBean = (OAMessageStyledTextBean)webBean.findIndexedChildRecursive("le4NameID"); 
        
        //Get the connection details
        OADBTransaction oadbTransactionImpl = am.getOADBTransaction();
        OracleConnection conn = (OracleConnection)oadbTransactionImpl.getJdbcConnection();
        
        //For Statement and ResultSet
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try  {
            String s1 = "select name " +
                        " from xle_entity_profiles "+
                        " where legal_entity_id = :1";
            ps = conn.prepareStatement(s1);
            ps.setString(1, leIDStr);
            resultSet = ps.executeQuery();
            
            if (resultSet.next())  {
                leNameStr = resultSet.getString(1);
                resultSet.close();
                ps.close();
                leNameBean.setValue(pageContext, leNameBean);
            }
        } catch (Exception ex)  {
            throw OAException.wrapperException(ex);
        } finally  {
        }
        
        
        System.out.println("leNameStr="+leNameStr);
        
        leNameBean.setValue(pageContext, leNameStr);
    
    }        
    
  }

}
