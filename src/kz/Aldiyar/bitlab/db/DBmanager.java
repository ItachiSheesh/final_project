package kz.Aldiyar.bitlab.db;


import kz.Aldiyar.bitlab.servlets.Task;

import java.util.ArrayList;

public class DBmanager {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static int id = 6;
    static {
        tasks.add(
                new Task(1,
                        "Создать Веб приложение на JAVA EE",
                        "2021-10-23",
                        "Да",
                        "Ничего не писали",
                        "Ничего вы не писали")
        );
        tasks.add(
                new Task(2,
                        "Убраться дома и закупить продукты",
                        "2021-10-25",
                        "Да",
                        "Ничего не писали",
                        "Ничего вы не писали")
        );
        tasks.add(
                new Task(3,
                        "Выполнить все домашние задания",
                        "2021-10-28",
                        "Нет",
                        "Ничего не писали",
                        "Ничего вы не писали")
        );
        tasks.add(
                new Task(4,
                        "Записаться на качку",
                        "2021-12-12",
                        "Нет",
                        "Ничего не писали",
                        "Ничего вы не писали")
        );
        tasks.add(
                new Task(5,
                        "Учить Итальянский",
                        "2021-05-01",
                        "Нет",
                        "Ничего не писали",
                        "Ничего вы не писали")
        );

    }

    public static ArrayList<Task> getTasks(){
        return tasks;
    }
    public static void addTask(Task task) {
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static Task getTask(int id){
        return tasks
                .stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void updateTask(Task zad){
        for(int i =0; i< tasks.size(); i++){
            if(tasks.get(i).getId()== zad.getId()){
                tasks.set(i, zad);
                break;
            }
        }
    }
    public static void deleteTask(int id){
        for (int i = 0; i< tasks.size(); i++){
            if(tasks.get(i).getId()==id){
                tasks.remove(i);
                break;
            }
        }
    }
}
