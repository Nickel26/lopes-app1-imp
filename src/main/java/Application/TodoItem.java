package Application;/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TodoItem extends TodoList {
    protected String itemTitle;
    protected String description;
    protected String dueDate;
    protected String complete;

    public TodoItem(String title, String temp, String date) {
        this.itemTitle = title;
        this.description = temp;
        this.dueDate = date;
        this.complete = "N";
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    protected void setComplete(){
        this.complete = "Y";
    }

    protected void setIncomplete(){
        this.complete = "N";
    }
}
