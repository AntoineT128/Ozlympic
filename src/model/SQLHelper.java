package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLHelper {
    ResultSet rs = null;
    Connection ct = null;
    Statement stat = null;
    String forname = "org.sqlite.JDBC";

    public SQLHelper() {
        try {
            Class.forName(forname);
            ct = DriverManager.getConnection("jdbc:sqlite:participants.db");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) {
        try {
            stat = ct.createStatement();
            rs = stat.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void close() {
        try {
            if (rs != null)
                rs.close();
            if (stat != null)
                stat.close();
            if (ct != null)
                ct.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}