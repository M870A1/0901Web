package org.zerock.yesyes2.common;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnPool {

    private static DataSource dataSource;

    static {
        try {
            Context initCtx = new InitialContext();
            Context ctx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) ctx.lookup("dbcp_myoracle");
            System.out.println("DBCP 초기화 성공");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DBCP 초기화 실패");
        }
    }
    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }
    public static void close(ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (Exception ignored) {}
    }
    public static void close(Statement stmt) {
        try { if (stmt != null) stmt.close(); } catch (Exception ignored) {}
    }
    public static void close(Connection con) {
        try { if (con != null) con.close(); } catch (Exception ignored) {}
    }
    public static void close(ResultSet rs, Statement stmt, Connection con) {
        close(rs);
        close(stmt);
        close(con);
    }
    // PreparedStatement와 Connection을 닫는 메소드
    public static void close(PreparedStatement psmt, Connection con) {
        close(psmt);
        close(con);
    }
    // ResultSet, PreparedStatement, Connection을 닫는 메소드
    public static void close(ResultSet rs, PreparedStatement psmt, Connection con) {
        close(rs);
        close(psmt);
        close(con);
    }
}
