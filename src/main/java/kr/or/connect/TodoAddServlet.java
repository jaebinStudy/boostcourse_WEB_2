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
import kr.or.connect.TodoDao;
import kr.or.connect.TodoDto;

@WebServlet("/TodoAddServlet")
public class TodoAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

    //post방식으로 할일등록폼의 값이 일로 전달됨.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        doGet(request, response);
        response.sendRedirect("main.jsp");
    }
}