/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhtu
 */
public class DbConnection {
    private static String hostName = "localhost";
    private static String acc = "sa";
    private static String pass = "DungPH25136";
    private static String dbName = "DuAn1";
    private static String connectionSQL = "jdbc:sqlserver://"+hostName+":1433;databaseName="+dbName;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection conn;
    
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi Driver");
        }
    }
    //Mở kết nối
    public static Connection openDbConnection(){
        try {
            return DriverManager.getConnection(connectionSQL, acc, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //2. Thực thi truy vấn Thêm, sửa, Xóa
    public static Integer excuteUpdate(String sql, Object... args){
        PreparedStatement pstm = getStmt(sql, args);
        try {
            return pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi tại excuteUpdate");
            return 0;
        }
    }
    
    
    //3. Trả lại 1 tập đối tượng
    public static ResultSet getDataFromQuery(String sql, Object... args) throws SQLException{
        PreparedStatement pstm = getStmt(sql, args);
        return pstm.executeQuery();
    }
    
    //4. Chuẩn bị câu truy vấn trước khi thực hiện - Các varargs sử dụng dấu ba chấm (...) sau kiểu dữ liệu.
    public static PreparedStatement getStmt(String sql, Object... args){
        try {
            conn = openDbConnection();
            PreparedStatement ps;
            //ps = cnn.prepareCall(sql) Gọi store produre
            ps = conn.prepareStatement(sql);//Dùng để triển khai các câu lệnh truy vấn thường
            for(int i = 0; i < args.length; i++){
                ps.setObject(i + 1, args[i]);
            }
            return ps;
        } catch (SQLException ex) {
            return null;
        }
    }
}
