package kr.or.connect;


// getTodos(), addTodo(), updateTodo()메소드가 있는 테이블이 있는곳.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TodoDao {
    private static String dburl = "jdbc:mysql://localhost:8080/tododb";
    private static String dbuser = "todouser";
    private static String dbpasswd = "todo123!@#";

//--------------------addTodo()-----------------------------------------------------

    public int addTodo(String title,String name,int sequence) {
        Integer insertcount = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO todo(title,name,sequence) VALUES(?,?,?)";

        try {
            conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, name);
            ps.setInt(3, sequence);
            insertcount = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return insertcount;
    }
//---------------------getTodos()----------------------------------------------------

    public ArrayList<TodoDto> getTodos() {
        ArrayList<TodoDto> myList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "select id, title, name, sequence, type, regdate from todo where order by regdate desc";


        try {
            conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            try {
                while (rs.next()) {
                    TodoDto todo = new TodoDto();
                    todo.setId(rs.getLong(1));
                    todo.setTitle(rs.getString(2));
                    todo.setName(rs.getString(3));
                    todo.setSequence(rs.getInt(4));
                    todo.setType(rs.getString(5));
                    todo.setRegDate(rs.getString(6));
                    myList.add(todo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return myList;
    }

//-----------------------updateTodo()-----------------------------------------------------
    public int updateTodo(String type, Long id) {
        Integer updatecount = null;
        Connection conn=null;
        PreparedStatement ps =null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "UPDATE todo SET type=? WHERE id=?";
        try {
            conn = DriverManager.getConnection(dburl,dbuser,dbpasswd);
            ps = conn.prepareStatement(sql);

            ps.setString(1, type);
            ps.setLong(2, id);

            updatecount = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return updatecount;
    }

    }


