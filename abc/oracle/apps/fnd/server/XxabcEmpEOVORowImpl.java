package abc.oracle.apps.fnd.server;

import abc.oracle.apps.fnd.schema.server.XxabcEmpEOImpl;

import oracle.apps.fnd.framework.server.OAViewRowImpl;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class XxabcEmpEOVORowImpl extends OAViewRowImpl {
    public static final int EMPNO = 0;
    public static final int ENAME = 1;
    public static final int JOB = 2;
    public static final int MGR = 3;
    public static final int HIREDATE = 4;
    public static final int SAL = 5;
    public static final int COMM = 6;
    public static final int DEPTNO = 7;
    public static final int SELECTFLAG = 8;

    /**This is the default constructor (do not remove)
     */
    public XxabcEmpEOVORowImpl() {
    }

    /**Gets XxabcEmpEO entity object.
     */
    public XxabcEmpEOImpl getXxabcEmpEO() {
        return (XxabcEmpEOImpl)getEntity(0);
    }

    /**Gets the attribute value for EMPNO using the alias name Empno
     */
    public Number getEmpno() {
        return (Number) getAttributeInternal(EMPNO);
    }

    /**Sets <code>value</code> as attribute value for EMPNO using the alias name Empno
     */
    public void setEmpno(Number value) {
        setAttributeInternal(EMPNO, value);
    }

    /**Gets the attribute value for ENAME using the alias name Ename
     */
    public String getEname() {
        return (String) getAttributeInternal(ENAME);
    }

    /**Sets <code>value</code> as attribute value for ENAME using the alias name Ename
     */
    public void setEname(String value) {
        setAttributeInternal(ENAME, value);
    }

    /**Gets the attribute value for JOB using the alias name Job
     */
    public String getJob() {
        return (String) getAttributeInternal(JOB);
    }

    /**Sets <code>value</code> as attribute value for JOB using the alias name Job
     */
    public void setJob(String value) {
        setAttributeInternal(JOB, value);
    }

    /**Gets the attribute value for MGR using the alias name Mgr
     */
    public Number getMgr() {
        return (Number) getAttributeInternal(MGR);
    }

    /**Sets <code>value</code> as attribute value for MGR using the alias name Mgr
     */
    public void setMgr(Number value) {
        setAttributeInternal(MGR, value);
    }

    /**Gets the attribute value for HIREDATE using the alias name Hiredate
     */
    public Date getHiredate() {
        return (Date) getAttributeInternal(HIREDATE);
    }

    /**Sets <code>value</code> as attribute value for HIREDATE using the alias name Hiredate
     */
    public void setHiredate(Date value) {
        setAttributeInternal(HIREDATE, value);
    }

    /**Gets the attribute value for SAL using the alias name Sal
     */
    public Number getSal() {
        return (Number) getAttributeInternal(SAL);
    }

    /**Sets <code>value</code> as attribute value for SAL using the alias name Sal
     */
    public void setSal(Number value) {
        setAttributeInternal(SAL, value);
    }

    /**Gets the attribute value for COMM using the alias name Comm
     */
    public Number getComm() {
        return (Number) getAttributeInternal(COMM);
    }

    /**Sets <code>value</code> as attribute value for COMM using the alias name Comm
     */
    public void setComm(Number value) {
        setAttributeInternal(COMM, value);
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

    /**getAttrInvokeAccessor: generated method. Do not modify.
     */
    protected Object getAttrInvokeAccessor(int index, 
                                           AttributeDefImpl attrDef) throws Exception {
        switch (index) {
        case EMPNO:
            return getEmpno();
        case ENAME:
            return getEname();
        case JOB:
            return getJob();
        case MGR:
            return getMgr();
        case HIREDATE:
            return getHiredate();
        case SAL:
            return getSal();
        case COMM:
            return getComm();
        case DEPTNO:
            return getDeptno();
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
        case EMPNO:
            setEmpno((Number)value);
            return;
        case ENAME:
            setEname((String)value);
            return;
        case JOB:
            setJob((String)value);
            return;
        case MGR:
            setMgr((Number)value);
            return;
        case HIREDATE:
            setHiredate((Date)value);
            return;
        case SAL:
            setSal((Number)value);
            return;
        case COMM:
            setComm((Number)value);
            return;
        case DEPTNO:
            setDeptno((Number)value);
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
