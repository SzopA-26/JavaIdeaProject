package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ToDo {
    private String title;
    private String description;
    private String timeStr;
    private int minute, hour;
    private LocalDate date;

    public ToDo(String title, String description, String timeStr, LocalDate date) {
        this.title = title;
        this.description = description;
        this.timeStr = timeStr;
        this.date = date;
        if (timeStr.contains(":")) {
            String[] time = timeStr.split(":", 2);
            hour = Integer.parseInt(time[0]);
            minute = Integer.parseInt(time[1]);
        } else {
            hour = Integer.parseInt(timeStr);
            minute = 0;
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return timeStr;
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
        String show = getDate();
        if (!   getTime().equals("")   )
            show += " -";
        if (getHour() < 10)
            show += "0";
        show += getHour() + ":";
        if (getMinute() < 10)
            show += "0";
        show += getMinute() + "-";
        if (!getTitle().equals(""))
            show += " [" + getTitle() + "]";
        if (!getDescription().equals(""))
            show += "\n          : " + getDescription();
        return show;

    }
}
