package Application;/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Nicholas Lopes
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.ParseException;
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
    private TableColumn<TodoItem, String> ItemCompletion;

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
    private Button SaveListButton;

    @FXML
    private TextField TitleDisplay;

    private TodoList todoList = new TodoList();
    public ObservableList<TodoItem> List = FXCollections.observableArrayList(
            new TodoItem("title", "desc", "date"),
            new TodoItem("title1", "desc1", "date1"),
            new TodoItem("title2", "desc2", "date2")
    );

    @FXML
    void newList(ActionEvent event) {
        todoList.clearList();
        todoList.setTitle(ListTitle.getText());
        TitleDisplay.setText(ListTitle.getText());
        ListTitle.clear();
    }

    @FXML
    void addItem(ActionEvent event) throws ParseException {
        if(ItemDueDate.getValue() == null){
            todoList.addItem(ItemTitleString.getText(), ItemDescriptionString.getText(), " ");
        }

        else {
            todoList.addItem(ItemTitleString.getText(), ItemDescriptionString.getText(), ItemDueDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        ItemTitleString.clear();
        ItemDescriptionString.clear();
        ItemDueDate.getEditor().clear();

        List.add(todoList.todoList.get(todoList.todoList.size() - 1));
        todoList.display();
        //Table.setItems(List);

    }

    @FXML
    void editItem(ActionEvent event) {

    }

    @FXML
    void clearList(ActionEvent event) {
        todoList.clearList();
    }

    @FXML
    void loadList(ActionEvent event) {

    }

    @FXML
    void removeItem(ActionEvent event) {

    }

    @FXML
    void saveList(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ItemName.setCellValueFactory(new PropertyValueFactory<TodoItem, String>("itemTitle"));
        Description.setCellValueFactory(new PropertyValueFactory<TodoItem, String>("description"));
        DueDate.setCellValueFactory(new PropertyValueFactory<TodoItem, String>("dueDate"));
        ItemCompletion.setCellValueFactory(new PropertyValueFactory<TodoItem, String>("complete"));


    }


}
