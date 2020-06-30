package ch.makery.management;


import java.sql.Connection;
import java.sql.DriverManager;
public interface ConnectSQL {
	String DB_URL = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName=Thigiuaky;"
            + "integratedSecurity=true";
	String USER_NAME = "sa";
	String PASSWORD = "10011999";
	//
	static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
