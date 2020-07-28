package kr.or.connect;
//저장된값을 main.jsp 조회하여 전달.

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.connect.TodoDao;
import kr.or.connect.TodoDto;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoDao dao = new TodoDao();
        ArrayList<TodoDto> list = dao.getTodos();

        JSONArray ja = new JSONArray();

        for (TodoDto todo : list) {
            JSONObject jo = new JSONObject();
            jo.put("id",todo.getId());
            jo.put("name",todo.getName());
            String regDate = todo.getRegDate().substring(0,10);
            jo.put("regDate",regDate);
            jo.put("sequence",todo.getSequence());
            jo.put("title",todo.getTitle());
            jo.put("type",todo.getType());
            ja.add(jo);
        }


        request.setAttribute("ja", ja);


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(request, response);
    }


}
