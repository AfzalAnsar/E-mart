
package StockMgmtSys.dao;

import StockMgmtSys.dbutil.DbConnection;
import StockMgmtSys.pojo.EmpPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class EmpDao {
    public static String getNextId()throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(empid) from employees");
        if(rs.next())
        {
            String empid=rs.getString(1);
            int id=Integer.parseInt(empid.substring(1));
            id=id+1;
            return "E"+id;
        }
        return null;
    }
     public static boolean addEmployee(EmpPojo emp)throws SQLException
    {
    Connection conn=DbConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("insert into employees values(?,?,?,?)");
    ps.setString(1,emp.getEmpid());
    ps.setString(2, emp.getEmpname());
    ps.setDouble(3, emp.getEmpsal());
    ps.setString(4, emp.getEmptype());
    int result=ps.executeUpdate();
    return result==1;
    }
     public static ArrayList<EmpPojo> viewEmpployees()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select * from employees");
         ArrayList<EmpPojo> empSets=new ArrayList<>();
         while(rs.next())
         {
             EmpPojo emp=new EmpPojo();
             emp.setEmpid(rs.getString(1));
             emp.setEmpname(rs.getString(2));
             emp.setEmpsal(rs.getDouble(3));
             emp.setEmptype(rs.getString(4));
             empSets.add(emp);
         }
         return empSets;
     }
     public static boolean updateEmployee(EmpPojo emp)throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareCall("update employees set empname=?,empsal=?,empjob=? where empid=?");
         ps.setString(4,emp.getEmpid());
         ps.setString(1, emp.getEmpname());
         ps.setDouble(2, emp.getEmpsal());
         ps.setString(3, emp.getEmptype());
         int result=ps.executeUpdate();
         if(result==0)
             return false;
         else
         {
             boolean r=UserDao.isUserPresent(emp.getEmpid());
             if(r==false)
                 return true;
         }
         ps=conn.prepareCall("update users username=?,usertype=? where empid=?");
         ps.setString(1, emp.getEmpname());
         ps.setString(2, emp.getEmptype());
         ps.setString(3, emp.getEmpid());
         int y=ps.executeUpdate();
         return y==1;
     }
     public static ArrayList getAllEmpId()throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         Statement st=conn.createStatement();
         ResultSet rs=st.executeQuery("select empid from employees");
         ArrayList<String> empIdSets=new ArrayList<>();
         while(rs.next())
         {
             empIdSets.add(rs.getString(1));
         }
         return empIdSets;
     }

     public static EmpPojo getRecords(String empId)throws SQLException
     {
         Connection conn=DbConnection.getConnection();
         PreparedStatement ps=conn.prepareCall("select * from employees where empid=?");
         ps.setString(1,empId);
         ResultSet rs=ps.executeQuery();
         rs.next();
         EmpPojo emp=new EmpPojo();
         emp.setEmpid(rs.getString(1));
         emp.setEmpname(rs.getString(2));
         emp.setEmpsal(rs.getDouble(3));
         emp.setEmptype(rs.getString(4));
         return emp;
     }
     public static boolean deleteEmp(String EmpId)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps= conn.prepareCall("delete from employees where empid=? ");
        ps.setString(1, EmpId);
        int result=ps.executeUpdate();
        return result==1;
    }
}
