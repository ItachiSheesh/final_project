package kz.Aldiyar.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.Aldiyar.bitlab.db.DBconnection;
import kz.Aldiyar.bitlab.db.DBmanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

@WebServlet(value = "/add-task")

public class AddTask extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("task_name");
        String info = request.getParameter("task_info");
        String date = request.getParameter("task_date");
        String descr = request.getParameter("task_descr");

        Task task = new Task();
        task.setName(name);
        task.setDescription(info);
        task.setDeadlineDate(date);
        task.setDescription1(descr);
        DBconnection.addTask(task);

        response.sendRedirect("/");
    }
}
