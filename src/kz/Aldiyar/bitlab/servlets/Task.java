package kz.Aldiyar.bitlab.servlets;

public class Task {
    private int id;
    private String name;
    private String deadlineDate;
    private String description;
    private String detail;
    private String description1;
    public Task(){

    }

    public Task(int id, String name, String deadlineDate, String description, String detail, String description1) {
        this.id = id;
        this.name = name;
        this.deadlineDate = deadlineDate;
        this.description = description;
        this.detail = detail;
        this.description1 = description1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }
}
