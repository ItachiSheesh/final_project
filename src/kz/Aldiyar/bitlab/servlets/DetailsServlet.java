package kz.Aldiyar.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.Aldiyar.bitlab.db.DBmanager;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(request.getParameter("task_id"));
        }catch (Exception e){
        }
        Task task = DBmanager.getTask(id);

        request.setAttribute("zadaniya", task);
        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }
}
