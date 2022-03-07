package abc.oracle.apps.fnd.server;

import abc.oracle.apps.fnd.schema.server.XxabcDeptEOImpl;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.domain.Number;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XxabcDeptEOVORowImpl extends OAViewRowImpl {
    public static final int DEPTNO = 0;
    public static final int DNAME = 1;
    public static final int LOC = 2;
    public static final int ROWID = 3;
    public static final int SELECTFLAG = 4;

    /**This is the default constructor (do not remove)
     */
    public XxabcDeptEOVORowImpl() {
    }

    /**Gets XxabcDeptEO entity object.
     */
    public XxabcDeptEOImpl getXxabcDeptEO() {
        return (XxabcDeptEOImpl)getEntity(0);
    }

    /**Gets the attribute value for DEPTNO using the alias name Deptno
     */
    public Number getDeptno() {
        return (Number) getAttributeInternal(DEPTNO);
    }

    /**Sets <code>value</code> as attribute value for DEPTNO using the alias name Deptno
     */
    public void setDeptno(Number value) {
        setAttributeInternal(DEPTNO, value);
    }

    /**Gets the attribute value for DNAME using the alias name Dname
     */
    public String getDname() {
        return (String) getAttributeInternal(DNAME);
    }

    /**Sets <code>value</code> as attribute value for DNAME using the alias name Dname
     */
    public void setDname(String value) {
        setAttributeInternal(DNAME, value);
    }

    /**Gets the attribute value for LOC using the alias name Loc
     */
    public String getLoc() {
        return (String) getAttributeInternal(LOC);
    }

    /**Sets <code>value</code> as attribute value for LOC using the alias name Loc
     */
    public void setLoc(String value) {
        setAttributeInternal(LOC, value);
    }

    /**Gets the attribute value for ROWID using the alias name RowID
     */
    public RowID getRowID() {
        return (RowID) getAttributeInternal(ROWID);
    }

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case DEPTNO:
            return getDeptno();
        case DNAME:
            return getDname();
        case LOC:
            return getLoc();
        case ROWID:
            return getRowID();
        case SELECTFLAG:
            return getselectFlag();
        default:
            return super.getAttrInvokeAccessor(index, attrDef);
        }
    }

    /**setAttrInvokeAccessor: generated method. Do not modify.
     */
    protected void setAttrInvokeAccessor(int index, Object value, 
                                         AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case DEPTNO:
            setDeptno((Number)value);
            return;
        case DNAME:
            setDname((String)value);
            return;
        case LOC:
            setLoc((String)value);
            return;
        case SELECTFLAG:
            setselectFlag((String)value);
            return;
        default:
            super.setAttrInvokeAccessor(index, value, attrDef);
            return;
        }
    }

    /**Gets the attribute value for the calculated attribute selectFlag
     */
    public String getselectFlag() {
        return (String) getAttributeInternal(SELECTFLAG);
    }

    /**Sets <code>value</code> as the attribute value for the calculated attribute selectFlag
     */
    public void setselectFlag(String value) {
        setAttributeInternal(SELECTFLAG, value);
    }
}