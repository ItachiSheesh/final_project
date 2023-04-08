<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="/add-task" method="post">
  <div class="row">
    <div class="col-12">
      <label>Наименование:</label>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <input type="text" placeholder="Наименование..." class="form-control " name="task_name">
    </div>
  </div>
  <div class="row">
    <div class="col-12">
      <label>Описание:</label>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <textarea placeholder="Описание..." class="form-control" rows="5" name="task_descr"></textarea>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <label>Выполнено?</label>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <select class="form-select" name="task_info">
        <option>Да</option>
        <option>Нет</option>
      </select>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <label>Крайний срок:</label>
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <input type="date" class="form-control " name="task_date">
    </div>
  </div>
  <div class="row mt-3">
    <div class="col-12">
      <button class="btn btn-success">Добавить</button>
    </div>
  </div>
</form>