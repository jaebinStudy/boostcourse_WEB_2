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

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String todoName = request.getParameter("todoName");
        String todoDate = request.getParameter("todoDate");
        String todoTitle = request.getParameter("todoTitle");



        RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
