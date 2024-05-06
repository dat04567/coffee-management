package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance = null;
    private Connection conn = null;

    private Database()  {
        try {
  
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/coffee";
            String user = "root";
            String password = "12345";
            this.conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối cơ sở dữ liệu thành công!");
        } catch (SQLException e) {
            System.out.println("Kết nối cơ sở dữ liệu thất bại:");
            System.out.println(e.toString());
            System.exit(0);
        } catch (ClassNotFoundException e2)
        {
            System.out.println("Chưa cài driver mysql!");
            System.out.println(e2.toString());
            System.exit(0);
        }
    }
    
    

    public Connection getConnection() {
        return this.conn;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

}
