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
        long id = 1;

        try {
            forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";

        try(Connection conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
        PreparedStatement ps =conn.prepareStatement(sql)){


            ps.setString(1,dto.getTitle());
            ps.setString(2, dto.getName());
            ps.setInt(3, dto.getSequence());


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

        String sql = "select id, title, name, sequence, type, regdate from todo order by regdate desc select id, title, name, sequence, type, regdate from todo where type = 'TODO' order by regdate desc";



        try(Connection conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
        PreparedStatement ps =conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String title = rs.getString("title");
                    String name = rs.getString("name");
                    int sequence = rs.getInt("sequence");
                    String type = rs.getString("type");
                    String reqDate = rs.getString("reqDate");

                    TodoDto dto = new TodoDto(id, name, reqDate, sequence, title, type);

                    myList.add(dto);

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


            String sql = null;
            if (dto.getType().equals("TODO")) {
                sql = "UPDATE todo SET type = 'DOING' WHERE id = ?";
            } else { //"DOING"
                sql = "UPDATE todo SET type = 'DONE' WHERE id = ?";
            }

            conn = DriverManager.getConnection ( dburl, dbuser, dbpasswd );
            ps = conn.prepareStatement(sql);


            ps.setLong(1,  dto.getId());

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


