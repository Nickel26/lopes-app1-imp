package Application;/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import Application.TodoItem;

import java.text.ParseException;
import java.util.*;

public class TodoList {
    protected String title;
    protected ArrayList<TodoItem> todoList = new ArrayList<>();

    protected void addItem(String title, String desc, String date) throws ParseException {
        if(todoList.size() == 100){
            todoList.remove(99);
        }
        TodoItem item = new TodoItem(title, desc, date);
        item.setTitle(title);
        item.setDescription(desc);
        if(date != null) {
            item.setDueDate(date);
        }
        todoList.add(item);
    }

    protected void display(){
        System.out.printf("%s", title);
        for(int i = 0 ; i < todoList.size(); i++) {
            System.out.printf("\n%s %s %s", todoList.get(i).itemTitle, todoList.get(i).description, todoList.get(i).dueDate);
        }
        System.out.print("\n\n\n");
    }

    protected void  removeItem(){

    }

    protected void  editItem(){

    }

    protected void  saveList(){

    }

    protected void  loadList(){

    }

    protected void  clearList(){
        todoList.clear();
    }


    public void setTitle(String text) {
        this.title = text;
    }
}
