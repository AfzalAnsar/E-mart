package StockMgmtSys.pojo;

import StockMgmtSys.dao.*;


public class LoginPojo {

    @Override
    public String toString() {
        return "LoginPojo{" + "userid=" + userid + ", usertype=" + usertype + ", username=" + username + ", userpass=" + userpass + ", empid=" + empid + '}';
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
    private String userid;
    private String usertype;
    private String username;
    private String userpass;
    private String empid;
}
