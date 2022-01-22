
package StockMgmtSys.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DbConnection {
    private static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//Afzal94:1521/xe","javaproject","java");
            JOptionPane.showMessageDialog(null, "Connection Establish Successfully!", "Success",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Error in loading driver", "Driver Error!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
        catch(SQLException e1)
        {
            JOptionPane.showMessageDialog(null, "Error in opening Connection!", "Db Error!",JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
            System.exit(1);
        }
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
   public static void CloseConnection()
   {
       try
       {
           conn.close();
           JOptionPane.showMessageDialog(null, "Connection close Successfully!", "Success",JOptionPane.INFORMATION_MESSAGE);
       }
       catch(SQLException ex)
       {
           JOptionPane.showMessageDialog(null, "Connection not close Successfully!", "Error!",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
       }
   }
}
