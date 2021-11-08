package Application;/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import javafx.scene.control.CheckBox;

@SuppressWarnings("ALL")
public class TodoItem extends TodoList {
    protected String itemTitle;
    protected String description;
    protected String dueDate;
    protected CheckBox checkbox = new CheckBox();

    public TodoItem(String title, String temp, String date) {
        //TodoItem Constructor assigns values to object attributes
        this.itemTitle = title;
        this.description = temp;
        this.dueDate = date;
        this.checkbox.setSelected(false);
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

    public CheckBox getCheckbox(){
        return checkbox;
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

}
