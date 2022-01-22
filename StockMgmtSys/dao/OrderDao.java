
package StockMgmtSys.dao;

import StockMgmtSys.dbutil.DbConnection;
import StockMgmtSys.pojo.ProductsPojo;
import StockMgmtSys.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrderDao {
     public static String getNextOrderId()throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(order_id) from orders");
        rs.next();
        String ordId=rs.getString(1);
        if(ordId==null)
        {
            return "O-101";
        }
        int id=Integer.parseInt(ordId.substring(2));
        id=id+1;
        return "O-"+id;
    }
     public static boolean addOrder(ArrayList<ProductsPojo> al, String OrdId)throws SQLException
     {
          Connection conn=DbConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("insert into orders values(?,?,?,?)");
          int x=0;
          for(ProductsPojo p:al)
          {
              ps.setString(1, OrdId);
              ps.setString(2, p.getProductId());
              ps.setInt(3, p.getQuntity());
              ps.setString(4, UserProfile.getUserid());
              x=x+ps.executeUpdate();
           }
           return x==al.size();
     }
      public static ArrayList<String> getAllOrderIdM()throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select order_Id from orders");
        ArrayList<String> ordId=new ArrayList<>();
        while(rs.next())
        {
            ordId.add(rs.getString(1));
        }
        return ordId;
    }
     public static ArrayList<ProductsPojo> getAllOrderDetails(String OrdId)throws SQLException
     {
          Connection conn=DbConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("select p.p_id,p.p_name,p.p_companyname,p.p_price,p.p_our_price,p.p_tax,o.p_quantity from products p, orders o where p.p_id in (select p_id from orders where o.p_id=p.p_id) and o.order_id=?");
          ps.setString(1, OrdId);
          ResultSet rs=ps.executeQuery();
          ArrayList<ProductsPojo> ar=new ArrayList();
          while(rs.next())
          {
              ProductsPojo p=new ProductsPojo();
              p.setProductId(rs.getString(1));
              p.setProductName(rs.getString(2));
              p.setProductCompany(rs.getString(3));
              p.setProductPrice(rs.getDouble(4));
              p.setOurPrice(rs.getDouble(5));
              p.setTax(rs.getDouble(6));
              p.setQuntity(rs.getInt(7));
              ar.add(p);
          }
          return ar;
     }
     public static ArrayList<String> getAllOrderIdR(String usrid)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select order_Id from orders where userid=?");
        ps.setString(1, usrid);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> ordId=new ArrayList<>();
        while(rs.next())
        {
            ordId.add(rs.getString(1));
        }
        return ordId;
    }
}
