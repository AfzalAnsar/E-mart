
package StockMgmtSys.dao;

import StockMgmtSys.dbutil.DbConnection;
import StockMgmtSys.pojo.LoginPojo;
import StockMgmtSys.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDao {
    public static boolean validateUser(LoginPojo user)throws SQLException
    {
    Connection conn=DbConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and userpassword=? and usertype=? ");
    ps.setString(1,user.getUserid());
    ps.setString(2, user.getUserpass());
    ps.setString(3, user.getUsertype());
    ResultSet rs=ps.executeQuery();
    if(rs.next())
    {
        UserProfile.setUsername(rs.getString(2));
        UserProfile.setUserid(rs.getString(4));
        return true;
    }
    return false;
    }
    public static boolean isUserPresent(String user)throws SQLException
    {
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareCall("select 1 from users where empid=?");
         ps.setString(1,user);
         ResultSet rs=ps.executeQuery();
         return rs.next();

    }
    public static ArrayList<String> getUserId()throws SQLException
    {
         Connection conn=DbConnection.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs =st.executeQuery("select userid from users where usertype='Receptionist'");
         ArrayList<String> id = new ArrayList();
         while(rs.next())
         {
             id.add(rs.getString(1));
         }
         return id;

    }
}

