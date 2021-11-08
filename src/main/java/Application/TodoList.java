package Application;/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Nicholas Lopes
 */

import java.util.*;

public class TodoList {
    protected String title;
    protected ArrayList<TodoItem> todoList = new ArrayList<>();

    protected void addItem(String title, String desc, String date) {
        //verify if list size is 100 and if so remove last item and replace with new item
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
        //Displays todo list in system terminal
        System.out.printf("%s", title);
        for (TodoItem todoItem : todoList) {
            System.out.printf("\n%s %s %s", todoItem.itemTitle, todoItem.description, todoItem.dueDate);
        }
        System.out.print("\n\n\n");
    }

    protected void  removeItem(int i){
        //removes item at i index
        todoList.remove(i);
    }

    protected void  editItem(int i, String name, String desc, String date){
        //edits items title, description, and due date with parameter values
        todoList.get(i).title = name;
        todoList.get(i).description = desc;
        todoList.get(i).dueDate = date;
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
