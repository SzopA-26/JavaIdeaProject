package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Todo {
    private String title;
    private String time;
    private String description;
    private int minute, hour;
    private LocalDate date;
    private ArrayList<Todo> todoL;

    public Todo(){
        todoL = new ArrayList<>();
    }

    public Todo(String title, String time, String description, LocalDate date) {
        this.title = title;
        this.time = time;
        this.description = description;
        this.date = date;
        if (time.contains(":")) {
            String[] timeAr = time.split(":", 2);
            hour = Integer.parseInt(timeAr[0]);
            minute = Integer.parseInt(timeAr[1]);
        } else {
            hour = Integer.parseInt(time);
            minute = 0;
        } todoL = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate date() {
        return date;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    public String toString() {
        String text = getDate();
        if (!getTime().equals("")) {
            text += " ";
        }
        if (getHour() < 10) {
            text += "0";
        }
        text += getHour() + ":";
        if (getMinute() < 10) {
            text += "0";
        }
        text += getMinute() + " ";
        if (!getTitle().equals("")) {
            text += " >> " + getTitle();
        }
        if (!getDescription().equals("")) {
            if (getTitle().equals("")) {
                text += " ";
            }
            text += " > " + getDescription();
        }
        return text;
    }

    public void addTo(Todo todo){
        boolean a = false;
        for(int i = 0;i < todoL.size() ;i++){
            if(todo.date().isBefore(todoL.get(i).date())){
                todoL.add(i,todo);
                a = true;
                break;
            }
            else if(todo.date().isEqual(todoL.get(i).date())){
                if(todo.getHour() < todoL.get(i).getHour()){
                    todoL.add(i,todo);
                    a = true;
                    break;
                }
                else if(todo.getHour() == todoL.get(i).getHour()){
                    if(todo.getMinute() < todoL.get(i).getMinute()){
                        todoL.add(i,todo);
                        a = true;
                        break;
                    }
                }
            }
        }
        if(!a){
            todoL.add(todo);
        }
    }
    public int getSize() {
        return todoL.size();
    }
    public ArrayList<Todo> getArray(){
        return todoL;
    }
}

