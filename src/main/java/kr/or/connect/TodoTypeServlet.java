package kr.or.connect;
//에이잭스로 버튼을 누루면 이동하게 하는 서블릿


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.TodoDao;
import kr.or.connect.TodoDto;

@WebServlet("/type")
public class TodoTypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TodoTypeServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("todo type exec");

        Long id = Long.parseLong(request.getParameter("id"));
        String type = request.getParameter("type");

        System.out.println(id +" "+ type);

        TodoDao dao = new TodoDao();
        if (type.equals("TODO")) {
            type="DOING";
            int updatecount = dao.updateTodo(type, id);
            System.out.println(updatecount);

        }else if(type.equals("DOING")) {
            type="DONE";
            int updatecount = dao.updateTodo(type, id);
            System.out.println(updatecount);
        }


        response.sendRedirect("/main");
    }
}