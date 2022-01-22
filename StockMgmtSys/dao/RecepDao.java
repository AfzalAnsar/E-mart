
package StockMgmtSys.dao;

import StockMgmtSys.dbutil.DbConnection;
import StockMgmtSys.pojo.LoginPojo;
import StockMgmtSys.pojo.RecepPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import static sun.misc.ClassFileTransformer.add;


public class RecepDao
{
    public static boolean addReceptionist(LoginPojo user)throws SQLException
    {
    Connection conn=DbConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("insert into users values(?,?,?,?,?)");
    ps.setString(1, user.getUserid());
    ps.setString(2, user.getUsername());
    ps.setString(3, user.getUsertype());
    ps.setString(4, user.getUserpass());
    ps.setString(5, user.getEmpid());
    int result=ps.executeUpdate();
    return result==1;
    }
     public static HashMap<String,String> getAllNonRegisteredRecep()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select empid,empname from employees where empjob='Receptionist' and empid not in (select empid from users where usertype='Receptionist')");
         HashMap<String,String> empIdNameSets=new HashMap<>();
         while(rs.next())
         {
             empIdNameSets.put(rs.getString(1), rs.getString(2));
         }
         return empIdNameSets;
     }
     public static boolean updateEmployee(RecepPojo user)throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareCall("update users set userpassword=? where userid=?");
         ps.setString(1, user.getUserpass());
         ps.setString(2, user.getUserid());
         int result=ps.executeUpdate();
         return result==1;
     }
     public static String getRecords(String userId)throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareCall("select * from users where userid=?");
         ps.setString(1,userId);
         ResultSet rs=ps.executeQuery();
         rs.next();
         return rs.getString(2);
     }
     public static boolean deleteRecep(String userId)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps= conn.prepareCall("delete from users where userid=? ");
        ps.setString(1, userId);
        int result=ps.executeUpdate();
        return result==1;
    }
     public static ArrayList<RecepPojo> viewEmpployees()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select u.userid,u.username,u.usertype,u.empid,e.empsal from users u,employees e where u.usertype='Receptionist' and u.empid=e.empid");
         ArrayList<RecepPojo> userSets=new ArrayList<>();
         while(rs.next())
         {
             RecepPojo user=new RecepPojo();
             user.setUserid(rs.getString(1));
             user.setUsername(rs.getString(2));
             user.setUsertype(rs.getString(3));
             user.setEmpid(rs.getString(4));
             user.setEmpsal(rs.getDouble(5));
             userSets.add(user);
         }
         return userSets;
     }
      public static HashMap<String,String> getAllRecepIdName()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select userid,username from users where usertype='Receptionist'");
         HashMap<String,String> RecepIdNameSets=new HashMap<>();
         while(rs.next())
         {
             RecepIdNameSets.put(rs.getString(1), rs.getString(2));
         }
         return RecepIdNameSets;
     }
}
