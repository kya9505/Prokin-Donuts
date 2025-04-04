package config;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    /**
     * 데이터베이스 정보가 포함된 ResourceBundle 객체
     */
    private static ResourceBundle bundle = ResourceBundle.getBundle("config/dbinfo");

    static {

        try {
            Class.forName(bundle.getString("driver"));
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        }

    }

    /**
     * 데이터베이스 연결 객체를 반환하는 메서드입니다.
     *
     * @return 데이터베이스 연결 객체(Connection), 연결 실패 시 {@code null} 반환
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    bundle.getString("url"),
                    bundle.getString("user"),
                    bundle.getString("password"));
        } catch (SQLException e) {
            System.out.println("연결 실패");
            return null;
        }
    }

    public static void closeQuietly(ResultSet rs, CallableStatement cs, Connection conn) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) { /* 로깅 가능 */ }
        try {
            if (cs != null) cs.close();
        } catch (SQLException e) { /* 로깅 가능 */ }
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) { /* 로깅 가능 */ }
    }
}





