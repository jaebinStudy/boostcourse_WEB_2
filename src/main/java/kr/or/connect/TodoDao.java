package kr.or.connect;


// getTodos(), addTodo(), updateTodo()메소드가 있는 테이블이 있는곳.

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import kr.or.connect.TodoDto;

import kr.or.connect.TodoDto;

import static java.lang.Class.forName;


public class TodoDao {
    private static String dburl = "jdbc:mysql://localhost:8080/tododb";
    private static String dbuser = "todouser";
    private static String dbpasswd = "todo123!@#";


    public int addTodo(TodoDto dto) {
        int inserCount = 0;


        try {
            forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO todo(id,title,name,sequence,type,regdate) VALUES(?,?,?,?,?,?)";

        try(Connection conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
        PreparedStatement ps =conn.prepareStatement(sql)){

            ps.setLong(1, dto.getId());
            ps.setString(2,dto.getTitle());
            ps.setString(3, dto.getName());
            ps.setInt(4, dto.getSequence());
            ps.setString(5, dto.getType());
            ps.setString(6, dto.getReqDate());

            inserCount = ps.executeUpdate();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return inserCount;
    }

    public List<TodoDto> getTodos() {
        List<TodoDto> myList = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "SELECT id,title,name,sequence,type,regdate FROM todo order by id desc";

        try(Connection conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
        PreparedStatement ps =conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    long id = rs.getLong(1);
                    String title = rs.getString(2);
                    String name = rs.getString(3);
                    int sequence = rs.getInt(4);
                    String type = rs.getString(5);
                    String regdate = rs.getString(6);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return myList;
    }

    public int updateTodo(TodoDto dto) {
        int updateCount = 0;


        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName( "com.mysql.jdbc.Driver" );

            conn = DriverManager.getConnection ( dburl, dbuser, dbpasswd );

            String sql = "update todo set id = ? ,title=? ,name =?,sequence =?,type =? reqdate =?";

            ps = conn.prepareStatement(sql);
            //id,title,name,sequence,type,regdate
            ps.setLong(1,  dto.getId());
            ps.setString(2, dto.getTitle());
            ps.setString(3, dto.getName());
            ps.setInt(4,  dto.getSequence());
            ps.setString(5, dto.getType());
            ps.setString(6, dto.getReqDate());

            updateCount = ps.executeUpdate();

        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                }catch(Exception ex) {}
            } // if

            if(conn != null) {
                try {
                    conn.close();
                }catch(Exception ex) {}
            } // if
        } // finally

        return updateCount;
    }

    }


