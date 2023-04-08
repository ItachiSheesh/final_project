package kz.Aldiyar.bitlab.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.Aldiyar.bitlab.db.DBmanager;

import java.io.IOException;

@WebServlet(value = "/save-task")
public class SaveTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("task_id"));
        String name = request.getParameter("task_name");
        String info = request.getParameter("task_info");
        String date = request.getParameter("task_date");
        String descr = request.getParameter("task_descr");

        Task task = DBmanager.getTask(id);
        if(task!=null){
            task.setName(name);
            task.setDescription(info);
            task.setDeadlineDate(date);
            task.setDescription1(descr);

            DBmanager.updateTask(task);

            response.sendRedirect("/details?task_id="+id);
        }else{
            response.sendRedirect("/");
        }
    }
}
