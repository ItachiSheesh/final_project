<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.Aldiyar.bitlab.servlets.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TASK MANAGER</title>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container mt-5">
        <div class="row">
            <div class="col-12">
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addtask">
                    + Добавить задание
                </button>
                <div class="modal fade" id="addtask" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <%@include file="addform.jsp"%>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container mt-5">
        <div class="row">
            <div class="col-12">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Наименование</th>
                        <th>Крайний срок</th>
                        <th>Выполнено</th>
                        <th style="width: 10%">Детали</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Task> zhumys = (ArrayList<Task>) request.getAttribute("zadaniya");
                        if(zhumys!=null){
                            for(Task t : zhumys){
                    %>
                    <tr>
                        <td><%=t.getId()%></td>
                        <td><%=t.getName()%></td>
                        <td><%=t.getDeadlineDate()%></td>
                        <td><%=t.getDescription()%></td>
                        <td>
                            <a class="btn btn-primary btn-sm" href="/details?task_id=<%=t.getId()%>">Детали</a>
                        </td>
                    </tr>
                    <%
                        }
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
