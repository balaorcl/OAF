/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package abc.oracle.apps.fnd.webui;

import abc.oracle.apps.fnd.server.TrainingAMImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

/**
 * Controller for ...
 */
public class OafReportCO extends OAControllerImpl
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
    
    //get the AM
    TrainingAMImpl am = (TrainingAMImpl)pageContext.getApplicationModule(webBean);
    int deptNo = 10;
    
    if(pageContext.getParameter("invokePS") != null){
        String enameStr = null, jobStr = null;
        int salInt = 0;
        
        //SQL statement
        String sql = "select ename, job, sal from emp where deptno="+deptNo;
        
        try{
            //get the db connection details from am
            Connection conn = am.getOADBTransaction().getJdbcConnection();
            //prepare the sql statement
            PreparedStatement ps = conn.prepareStatement(sql);
            // Execute the query
            ResultSet rs = ps.executeQuery();
            
            //for all the rows in resultset
            while(rs.next()){
                enameStr = rs.getString(1).trim();
                jobStr = rs.getString(2);
                salInt = rs.getInt(3);
                System.out.println("Employee Info="+enameStr+" JobStr="+jobStr+" Salary="+salInt);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
  }

}
