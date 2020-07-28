package kr.or.connect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import kr.or.connect.TodoDao;
import kr.or.connect.TodoDto;

//main 에서 todoform버튼 클릭하면 TodoformServlet으로 오고, todoForm.jsp로 포워드
@WebServlet("/form")
public class TodoFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TodoFormServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/todoForm.jsp");
        requestDispatcher.forward(request, response);
    }


}
