/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package abc.oracle.apps.fnd.webui;

import abc.oracle.apps.fnd.server.TrainingAMImpl;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

/**
 * Controller for ...
 */
public class EmpDMLCO extends OAControllerImpl
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
    am.initEmpVO();
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
    
    if(pageContext.getParameter("save") != null){
        am.empSave();
    }
    else if(pageContext.getParameter("insertRow") != null){
        am.insertEmpRow();
    }    
    else if(pageContext.getParameter("deleteRow") != null){
        //am.iterateEmpVO();
        //am.deleteEmpRows();
        am.deleteEmpRowsNew();
    }    
    
    
  }

}
