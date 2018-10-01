
   

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBconnect {
    
    
    public DBconnect(){
            }
     public Connection myConnect(){
      Connection connect = null;
    
    try {
                    Class.forName("com.mysql.jdbc.Driver");

                    connect = DriverManager.getConnection(""
                            + "jdbc:mysql://localhost/web_project"
                            + "?user=root&password=");
    
                    } catch (ClassNotFoundException | SQLException e) {
                         // TODO Auto-generated catch block
                         System.out.println(e.getMessage());
                }
            return connect;
                
     }
     
     public static void main(String args[]){
         DBconnect mytest = new DBconnect();
         mytest.myConnect();
     }

     

}

