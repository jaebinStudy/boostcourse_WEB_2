package kr.or.connect;
//저장된값을 main.jsp 조회하여 전달.

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import kr.or.connect.TodoDao;
import kr.or.connect.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        TodoDao dao = new TodoDao();

        List<TodoDto> list = dao.getTodos();

        request.setAttribute("todo", list);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(request, response);
    }


}
