package Application;/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Nicholas Lopes
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class App1Controller implements Initializable {

    @FXML
    private Button AddItemButton;

    @FXML
    private Button ClearListButton;

    @FXML
    private CheckBox CompleteCheck;

    @FXML
    private TableColumn<TodoItem, String> Description;

    @FXML
    private TableColumn<TodoItem, String> DueDate;

    @FXML
    private Button EditItemButton;

    @FXML
    private CheckBox IncompleteCheck;

    @FXML
    private TableColumn<TodoItem, CheckBox> ItemCompletion;

    @FXML
    private TextField ItemDescriptionString;

    @FXML
    private DatePicker ItemDueDate;

    @FXML
    private TableColumn<TodoItem, String> ItemName;

    @FXML
    private TextField ItemTitleString;

    @FXML
    private TableView<TodoItem> Table;

    @FXML
    private TextField ListTitle;

    @FXML
    private Button LoadListButton;

    @FXML
    private Button NewListButton;

    @FXML
    private Button RemoveItemButton;

    @FXML
    private Button SaveEditButton;

    @FXML
    private Button SaveListButton;

    @FXML
    private TextField TitleDisplay;

    private final TodoList todoList = new TodoList();
    public ObservableList<TodoItem> List = FXCollections.observableArrayList();

    @FXML
    void newList() {
        //Clears todo List to create a new blank list
        todoList.clearList();

        //Sets title for new list
        todoList.setTitle(ListTitle.getText());

        //passes title to gui
        TitleDisplay.setText(ListTitle.getText());

        //clears text box for title input
        ListTitle.clear();
    }

    @FXML
    void addItem() {
        //checks for description to have at least one character
        if(ItemDescriptionString.getText().length() >= 1 && ItemDescriptionString.getText().length() < 256) {
            //checks for optional due date
            if (ItemDueDate.getValue() == null) {
                todoList.addItem(ItemTitleString.getText(), ItemDescriptionString.getText(), " ");
            } else {
                todoList.addItem(ItemTitleString.getText(), ItemDescriptionString.getText(), ItemDueDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }

            //clears input text boxes for new items
            ItemTitleString.clear();
            ItemDescriptionString.clear();
            ItemDueDate.setValue(null);

            //displays list onto gui
            List.add(todoList.todoList.get(todoList.todoList.size() - 1));
            todoList.display();
        }

    }

    @FXML
    void editItem() {
        ObservableList<TodoItem> selectedItem;

        //stores selected item
        selectedItem = Table.getSelectionModel().getSelectedItems();

        //stores index of selected item in list
        int i = 0;
        for(TodoItem todoItem: selectedItem){
            i = List.indexOf(todoItem);
        }

        //Stores original item before changes
        TodoItem temp = new TodoItem(List.get(i).itemTitle, List.get(i).description, List.get(i).dueDate);

        //checks item title for changes
        if(!ItemTitleString.getText().isEmpty()){
            temp.itemTitle = ItemTitleString.getText();
        }

        //checks description box for changes
        if(!ItemDescriptionString.getText().isEmpty()){
            temp.description = ItemDescriptionString.getText();
        }

        //checks due date for changes
        if(ItemDueDate.getValue() != null){
            temp.dueDate = ItemDueDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        //Apply changes to table in gui
        List.set(i, temp);

        //apply changes to stored list
        if (ItemDueDate.getValue() == null) {
            todoList.editItem(i, temp.itemTitle, temp.description, temp.dueDate);
        } else {
            todoList.editItem(i, temp.itemTitle, temp.description, ItemDueDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }

        //clears input text boxes
        ItemTitleString.clear();
        ItemDescriptionString.clear();
        ItemDueDate.setValue(null);
    }

    @FXML
    void removeItem() {
        ObservableList<TodoItem> selectedItem;

        //Stores selected item
        selectedItem = Table.getSelectionModel().getSelectedItems();

        //Stores index selected item is stored at
        int i = 0;
        for(TodoItem todoItem: selectedItem){
            i = List.indexOf(todoItem);
            List.remove(todoItem);
        }

        //removes item from stored list
        todoList.removeItem(i);
        todoList.display();

    }

    @FXML
    void clearList() {
        //clears stored list
        todoList.clearList();

        //clears gui display list
        List.clear();
    }

    @FXML
    void showCompleteItems() {
        //create list to store complete items
        ObservableList<TodoItem> CompleteItems = FXCollections.observableArrayList();

        //check for items marked as completed
        if(CompleteCheck.isSelected()){
            //unchecks Incomplete checkbox
            IncompleteCheck.setSelected(false);
            //store completed items in list
            for (TodoItem todoItem : List) {
                if (todoItem.checkbox.isSelected()) {
                    CompleteItems.add(todoItem);
                }
                //displays completed list
                Table.setItems(CompleteItems);
            }
        }
        else{
            //reset table when checkbox is unchecked
            Table.setItems(List);
        }
    }

    @FXML
    void showIncompleteItems() {
        //create list for incomplete items
        ObservableList<TodoItem> IncompleteItems = FXCollections.observableArrayList();

        //Check for items not marked as complete
        if(IncompleteCheck.isSelected()){
            //unchecks complete checkbox
            CompleteCheck.setSelected(false);
            //Store incomplete items in list
            for (TodoItem todoItem : List) {
                if (!todoItem.checkbox.isSelected()) {
                    IncompleteItems.add(todoItem);
                }
                //displays incomplete list
                Table.setItems(IncompleteItems);
            }
        }
        else{
            //reset table when checkbox is unchecked
            Table.setItems(List);
        }
    }

    @FXML
    void loadList() {

    }

    @FXML
    void saveList() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Initializes columns of display table with values of TodoItem object
        ItemName.setCellValueFactory(new PropertyValueFactory<>("itemTitle"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        ItemCompletion.setCellValueFactory(new PropertyValueFactory<>("checkbox"));
        DueDate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        //allows table to access observables to display
        Table.setItems(List);

    }


}
