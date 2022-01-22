package StockMgmtSys.pojo;
public class RecepPojo {

    @Override
    public String toString() {
        return "RecepPojo{" + "userid=" + userid + ", usertype=" + usertype + ", username=" + username + ", userpass=" + userpass + ", empid=" + empid + ", empsal=" + empsal + '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public double getEmpsal() {
        return empsal;
    }

    public void setEmpsal(double empsal) {
        this.empsal = empsal;
    }
 private String userid;
    private String usertype;
    private String username;
    private String userpass;
    private String empid;
    private double empsal;
}
