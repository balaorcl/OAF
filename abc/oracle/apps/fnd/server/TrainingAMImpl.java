package abc.oracle.apps.fnd.server;

import abc.oracle.apps.fnd.poplist.server.InventoryOrgPopVOImpl;

import java.io.IOException;
import java.io.OutputStream;

import java.sql.SQLException;

import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;

import oracle.jbo.XMLInterface;

import oracle.jbo.domain.BlobDomain;

import oracle.xml.parser.v2.XMLNode;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TrainingAMImpl extends OAApplicationModuleImpl {
    /**This is the default constructor (do not remove)
     */
    public TrainingAMImpl() {
    }
    
    public void initXxabcDeptEOVO(){
        XxabcDeptEOVOImpl vo = getXxabcDeptEOVO1();
        vo.clearCache();
        vo.setWhereClause(null);
        vo.executeQuery();
    }

    public XMLNode getXMLData()
     {
         HrmsEmployeeVOImpl vo = getHrmsEmployeeVO1(); 
         vo.executeQuery();
         XMLNode xmlData = (XMLNode)vo.writeXML(4,XMLInterface.XML_OPT_ALL_ROWS);
         return xmlData;
     }
    
    
    public void initGenerateXMLData(){
        System.out.println("Entered initGenerateXMLData");
        HrmsEmployeeVOImpl vo = getHrmsEmployeeVO1();
        vo.executeQuery();
        
        // write vo data as XMLNode
        XMLNode xmlData = (XMLNode)vo.writeXML(4, XMLInterface.XML_OPT_ALL_ROWS);
        // create a blob variable
        BlobDomain blob = new BlobDomain();
        // Outputstream variable
        OutputStream os = null;

        try {
            // get a blob OutputStream
            os = blob.getBinaryOutputStream();
            // convert the data in OutputStream
            xmlData.print(os);
        } catch (SQLException e) {
            // TODO
        } catch (IOException e) {
            // TODO
        }
        // print the data from OutputStream
        System.out.println(os.toString());
        
        
    }
    
    public void initItemDetailsVO(String orgCode, String itemNumStr){
        ItemDetailsVOImpl vo = getItemDetailsVO1();
        vo.clearCache();
        vo.setWhereClause(null);
        vo.setWhereClauseParam(0, orgCode);
        vo.setWhereClauseParam(1, itemNumStr);
        vo.executeQuery();
    }
    

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
        launchTester("abc.oracle.apps.fnd.server", /* package name */
      "TrainingAMLocal" /* Configuration Name */);
    }

    /**Container's getter for ItemDetailsVO1
     */
    public ItemDetailsVOImpl getItemDetailsVO1() {
        return (ItemDetailsVOImpl)findViewObject("ItemDetailsVO1");
    }

    /**Container's getter for InventoryOrgPopVO1
     */
    public InventoryOrgPopVOImpl getInventoryOrgPopVO1() {
        return (InventoryOrgPopVOImpl)findViewObject("InventoryOrgPopVO1");
    }

    /**Container's getter for HrmsEmployeeVO1
     */
    public HrmsEmployeeVOImpl getHrmsEmployeeVO1() {
        return (HrmsEmployeeVOImpl)findViewObject("HrmsEmployeeVO1");
    }

    /**Container's getter for XxabcDeptEOVO1
     */
    public XxabcDeptEOVOImpl getXxabcDeptEOVO1() {
        return (XxabcDeptEOVOImpl)findViewObject("XxabcDeptEOVO1");
    }
}
