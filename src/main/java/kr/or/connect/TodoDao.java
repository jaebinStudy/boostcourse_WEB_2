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

import static java.lang.Class.forName;


public class TodoDao {
    private static String dburl = "jdbc:mysql://localhost:8080/tododb";
    private static String dbuser = "todouser";
    private static String dbpasswd = "todo123!@#";


    public int addTodo(TodoDto) {


    }

    public List<TodoDto> getTodos(long tododtoid) {
        List<TodoDto> myList = new ArrayList<TodoDto>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
            String sql = "SELECT id,title,name,sequence,type,regdate FROM todo WHRER id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setLong(1,tododtoid);
            rs=ps.executeQuery();

            if(rs.next()){
                Long id = rs.getLong(1);
                String title = rs.getString(2);
                String name = rs.getString(3);
                int sequencce = rs.getInt(4);
                String type = rs.getString(5);
                String regdate = rs.getString(6);

                myList = myList.add(id,title,name,sequencce,type,regdate);

            }
        } catch (Exception e) {

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return myList;
    }

    public int updateTodo(TodoDto) {


    }

}
