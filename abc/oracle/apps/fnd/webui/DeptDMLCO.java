/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package abc.oracle.apps.fnd.webui;

import abc.oracle.apps.fnd.server.TrainingAMImpl;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAFwkConstants;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

/**
 * Controller for ...
 */
public class DeptDMLCO extends OAControllerImpl
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
    
    pageContext.writeDiagnostics(this,
                                 "Using Diagnostics "+" Entered PR Method",
                                 OAFwkConstants.STATEMENT);
    
    System.out.println("Using SOP -- Entered PR Method");
    
    TrainingAMImpl am = (TrainingAMImpl)pageContext.getApplicationModule(webBean);
    am.initXxabcDeptEOVO();
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
    
    System.out.println("Using SOP -- Entered PFR Method");    
    
    pageContext.writeDiagnostics(this,
                                 "Using Dianostics Entered PFR Method",
                                 OAFwkConstants.STATEMENT);
    
    TrainingAMImpl am = (TrainingAMImpl)pageContext.getApplicationModule(webBean);    
    
    if(pageContext.getParameter("saveBtn")!=null){
        pageContext.writeDiagnostics(this,
                                    "Using Diagnostics - User clicked on SaveBtn",
                                    OAFwkConstants.STATEMENT);    
        am.saveDeptEOVO();
    }
    else if(pageContext.getParameter("createBtn")!=null){
        pageContext.writeDiagnostics(this,
                                     "Using Diagnostics - User clicked on createBtn",
                                     OAFwkConstants.STATEMENT);     
        am.insertDeptEOVORow();
    }
    else if(pageContext.getParameter("deleteBtn")!=null){
        pageContext.writeDiagnostics(this,
                                     "Using Diagnostics - User clicked on deleteBtn",
                                     OAFwkConstants.STATEMENT);    
        am.deleteDeptRows();                
    }    
    
    
  }

}
