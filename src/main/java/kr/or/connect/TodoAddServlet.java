package kr.or.connect;
//사용자가 입력한 제목, 이름, 순서를 받아들여 todo 테이블에 저장한다.

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.or.connect.TodoDao;
import kr.or.connect.TodoDto;

@WebServlet("/add")
public class TodoAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TodoAddServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");


        String title = request.getParameter("title");
        String name = request.getParameter("name");
        String priority = request.getParameter("sequence");


        int sequence = 0;
        if (priority.equals("1순위")) sequence = 1;
        else if (priority.equals("2순위")) sequence = 2;
        else sequence = 3; // 3순위


        TodoDao dao = new TodoDao();
        int insertcount = dao.addTodo(title, name, sequence);
        System.out.println(insertcount);


        response.sendRedirect( "/main");//post방식으로 할일등록폼의 값이 일로 전달됨.
    }


}