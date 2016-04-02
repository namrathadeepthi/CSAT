package csatdisplay;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Sreenivasulu.v
 *
 */
public class DaoUtil
{

   static Connection mySQLConnection = null;
   static Connection abtsConnection = null;


   static Properties properties = new Properties();

   /**
    * Method to get the SQL DB data abase connection
    *
    * @return
    * @throws SQLException
    */
   public static Connection getABTSConnection() throws SQLException, IOException
   {


      if (abtsConnection != null)
      {
         return abtsConnection;
      }
      else
      {

         String abtsUrl = "";
         String userName = "";
         String password = "";
         InputStream input = null;

         try
         {
            // input = new FileInputStream(new
            // File(System.getProperty("catalina.base"),"conf/AbtsCSV.properties"));
            input = new FileInputStream("D:\\ABTS_properties\\AbtsCSV.properties");
            properties.load(input);
            abtsUrl = properties.getProperty("Abtssqlserver_url").toString();
            userName = properties.getProperty("Abtssqlserver_Uname").toString();
            password = properties.getProperty("Abtssqlserver_Password").toString();

            try
            {
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               abtsConnection =
                  (Connection) DriverManager.getConnection(abtsUrl, userName, password);
            }
            catch (ClassNotFoundException e)
            {
               e.printStackTrace();
               throw new SQLException("exception in dao class");
            }
            catch (SQLException e)
            {
               e.printStackTrace();
               throw new SQLException("exception in dao class");
            }
         }
         finally
         {
            input.close();
         }
      }

      return abtsConnection;
   }

   /**
    * Method to get the MySql data abase connection
    *
    * @return
    * @throws SQLException
    */
   public static Connection getMySqlDBConnection() throws SQLException, IOException
   {

      if (mySQLConnection != null)
      {
         return mySQLConnection;
      }
      else
      {

         String mySqlDBUrl = "";
         String userName = "";
         String password = "";
         //InputStream input = null;

         try
         {
            // input = new FileInputStream(new
            // File(System.getProperty("catalina.base"),"conf/AbtsCSV.properties"));
            /*input = new FileInputStream("D:\\ABTS_properties\\AbtsCSV.properties");
            properties.load(input);
            mySqlDBUrl = properties.getProperty("mysqlDBLocalserver_url").toString();
            userName = properties.getProperty("mysqlDBLocalserver_Uname").toString();
            password = properties.getProperty("mysqlDBLocalserver_Password").toString();*/

            try
            {
            	Class.forName("com.mysql.jdbc.Driver");
      		mySQLConnection =
      		      (Connection)DriverManager.getConnection(
      		        "jdbc:mysql://10.174.0.243:3306/invoice_test", "root", "Inv0ice@123");
      	
            }
            catch (ClassNotFoundException e)
            {
               e.printStackTrace();
               throw new SQLException("exception in dao class");
            }
            catch (SQLException e)
            {
               e.printStackTrace();
               throw new SQLException("exception in dao class");
            }
         }
         finally
         {
           // input.close();
         }
      }

      return mySQLConnection;
   }

}
