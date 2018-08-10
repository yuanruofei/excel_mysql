package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/** 
 * <p>Title: file_name</p> 
 * <p>Description: excel的导入与导出</p> 
 * <p>Copyright: Copyright (c) 2018</p> 
 * <p>Company: www.ZTESoft.com</p> 
 * @author @yrf 
 * @date 2018年8月10日 
 * @version 1.0 
 */
 
public class DBUtil {
    
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/excel_mysql";
    
    Connection con = null;
    ResultSet res = null;

    public void DataBase() {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, "root", "root");
            } catch (ClassNotFoundException e) {
                  System.err.println("装载 JDBC/ODBC 驱动程序失败。" );  
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("无法连接数据库" ); 
                e.printStackTrace();
            }
    }

    // 查询
    public ResultSet  Search(String sql, String str[]) {
        DataBase();
        try {
            PreparedStatement pst =con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            res = pst.executeQuery();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }

    // 增删修改
    public int AddU(String sql, String str[]) {
        int a = 0;
        DataBase();
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            if (str != null) {
                for (int i = 0; i < str.length; i++) {
                    pst.setString(i + 1, str[i]);
                }
            }
            a = pst.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return a;
    }

}
