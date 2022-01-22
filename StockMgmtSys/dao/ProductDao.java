
package StockMgmtSys.dao;

import StockMgmtSys.dbutil.DbConnection;
import StockMgmtSys.pojo.ProductsPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ProductDao {
    public static String getNextProductId()throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select max(p_id) from products");
        rs.next();
        String productId=rs.getString(1);
        if(productId==null)
        {
            return "P101";
        }
        int id=Integer.parseInt(productId.substring(1));
        id=id+1;
        return "P"+id;
    }
     public static boolean addProduct(ProductsPojo product)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into products values(?,?,?,?,?,?,?,'Y')");
        ps.setString(1, product.getProductId());
        ps.setString(2, product.getProductName());
        ps.setString(3, product.getProductCompany());
        ps.setDouble(4, product.getProductPrice());
        ps.setDouble(5, product.getOurPrice());
        ps.setDouble(6, product.getTax());
        ps.setInt(7, product.getQuntity());
        int result = ps.executeUpdate();
        return result==1;
    }
     public static ArrayList<ProductsPojo> getAllProductsDetails()throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs= st.executeQuery("select * from products where status='Y'");
        ArrayList<ProductsPojo> productList = new ArrayList();
        while(rs.next())
        {
            ProductsPojo product = new ProductsPojo();
            product.setProductId(rs.getString(1));
            product.setProductName(rs.getString(2));
            product.setProductCompany(rs.getString(3));
            product.setProductPrice(rs.getDouble(4));
            product.setOurPrice(rs.getDouble(5));
            product.setTax(rs.getDouble(6));
            product.setQuntity(rs.getInt(7));
            productList.add(product);
        }
        return productList;
    }
      public static boolean deleteProduct(String productId)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update products set status='N' where p_id=?");
        ps.setString(1, productId);
        int result = ps.executeUpdate();
        return result==1;
    }
      public static boolean updateProduct(ProductsPojo product)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update products set p_name=?,p_companyname=?,p_price=?,p_our_price=?,p_tax=?,p_quantity=? where p_id=?");
        ps.setString(1, product.getProductName());
        ps.setString(2, product.getProductCompany());
        ps.setDouble(3, product.getProductPrice());
        ps.setDouble(4, product.getOurPrice());
        ps.setDouble(5, product.getTax());
        ps.setInt(6, product.getQuntity());
        ps.setString(7, product.getProductId());
        int result = ps.executeUpdate();
        return result==1;
    }
       public static ProductsPojo getProductsDetailsById(String id)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from products where p_id=? and status='Y'");
        ps.setString(1, id);
        ResultSet rs=ps.executeQuery();
        ProductsPojo product=null;
        if(rs.next())
        {
            product = new ProductsPojo();
            product.setProductId(rs.getString(1));
            product.setProductName(rs.getString(2));
            product.setProductCompany(rs.getString(3));
            product.setProductPrice(rs.getDouble(4));
            product.setOurPrice(rs.getDouble(5));
            product.setTax(rs.getDouble(6));
            product.setQuntity(rs.getInt(7));
        }
        return product;
    }
    public static boolean updatestacks(List<ProductsPojo> productsList)throws SQLException
    {
        Connection conn=DbConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update products set p_quantity=p_quantity-? where p_id=?");
        int x=0;
        for(ProductsPojo product:productsList)
        {
            ps.setInt(1, product.getQuntity());
            ps.setString(2, product.getProductId());
            int rows=ps.executeUpdate();
            if(rows!=0)
                x++;
        }
        return x==productsList.size();
    }    
}