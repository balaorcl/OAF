/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package abc.oracle.apps.fnd.webui;

import abc.oracle.apps.fnd.server.TrainingAMImpl;

//import java.util.ArrayList;

import com.sun.java.util.collections.ArrayList;

import oracle.apps.fnd.common.MessageToken;
import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;

/**
 * Controller for ...
 */
public class AOLComponentsCO extends OAControllerImpl
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
    am.initPOTypesLookupVO();
    am.initValueSetVO();
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
    
    if(pageContext.getParameter("invokeMsgBtn") != null){
        OAException infoMsg = new OAException("FND",
                                              "XXABC_SAMPLE_MSG",
                                              null,
                                              OAException.INFORMATION,
                                              null);
        throw infoMsg;                                              
    }
    else if(pageContext.getParameter("invokeTokenMsgBtn") != null){
        String poNumStr = "PO-12345-123";
        String amountStr = "9844";
        
        MessageToken[] tokenArray = {new MessageToken("PO_NUM", poNumStr),
                                     new MessageToken("P_AMOUNT", amountStr)};
        
        OAException infoMsg = new OAException("FND",
                                              "XXABC_PO_MSG",
                                              tokenArray,
                                              OAException.INFORMATION,
                                              null
                                              );
        throw infoMsg;                                              
    }
    else if(pageContext.getParameter("invokeBundledExpBtn") != null){
        String poNumStr = "PO-12345-123";
        String amountStr = "9844";
      
        MessageToken[] tokenArray = {new MessageToken("PO_NUM", poNumStr),
                                   new MessageToken("P_AMOUNT", amountStr)};
      
        OAException infoMsg = new OAException("FND",
                                            "XXABC_PO_MSG",
                                            tokenArray,
                                            OAException.INFORMATION,
                                            null
                                            ); 

        OAException vaMsg1 = new OAException("FND",
                                             "XXABC_VALIDATION_1",
                                             null,
                                             OAException.WARNING,
                                             null);
                                             
        OAException vaMsg2 = new OAException("FND",
                                           "XXABC_VALIDATION_2",
                                           null,
                                           OAException.WARNING,
                                           null);   

        OAException vaMsg3 = new OAException("FND",
                                           "XXABC_VALIDATION_3",
                                           null,
                                           OAException.WARNING,
                                           null);  

        ArrayList list = new ArrayList();
        list.add(vaMsg1);
        list.add(vaMsg2);
        list.add(vaMsg3);
        list.add(infoMsg);
        
        throw OAException.getBundledOAException(list);

                                                   
                                            
  }

}
}
