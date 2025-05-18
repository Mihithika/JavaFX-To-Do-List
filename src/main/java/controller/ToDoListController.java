package controller;

import db.ToDoListDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ToDoList;

import javax.swing.text.TableView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ToDoListController  {

    public Label lblList;
    public javafx.scene.control.TableView tblTasks;
    @FXML
    private TextField txtTask;
    @FXML
    private TextField txtStart;
    @FXML
    private TextField txtEnd;
    @FXML
    private ListView listTask;
    @FXML
    private TableColumn colTask;
    @FXML
    private TableColumn colStart;
    @FXML
    private TableColumn colEnd;
    @FXML
    private TableColumn colDone;

    List<ToDoList> toDoList = new ArrayList<>();
    String[] mytask = {txtTask.getText(),txtStart.getText(), txtEnd.getText()};

    @FXML
    public void btnAddOnClick(ActionEvent actionEvent) {

        toDoList.forEach(todoList -> {
            System.out.println(todoList);
                });

    }

    public void loadTable() throws SQLException {
            try {
            Connection connection = ToDoListDB.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM mylist");
            while ((resultSet.next()))
            toDoList.add(new ToDoList(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));

            colTask.setCellValueFactory(new PropertyValueFactory<>("task"));
            colStart.setCellValueFactory(new PropertyValueFactory<>("start"));
            colEnd.setCellValueFactory(new PropertyValueFactory<>("end"));

            ObservableList<ToDoList> toDoListObservableList = FXCollections.observableArrayList();
           toDoList.forEach( toDoList1 -> {
               toDoListObservableList.add(toDoList1);
           });
             tblTasks.setItems(toDoListObservableList);
        }catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
