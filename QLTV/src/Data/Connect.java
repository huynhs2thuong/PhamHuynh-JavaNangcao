 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Connect {
    private  static Connection con;
    
    public static Connection getConnect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=QLTV;Username=sa;Password = sa");
            
        } catch (Exception e) {
            System.out.println("Kết nối không thành công");
        }
        return con;
    }
    public static String testConnect() {
        try{
            con = Connect.getConnect();
            return "Kết nối thành công";
        }
        catch(Exception e) {
            return "Kết nối thất bại";
        }
    } 
}
