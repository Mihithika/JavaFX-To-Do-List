package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ToDoListDB {
    private static ToDoListDB instance;
    private Connection connection;
    private ToDoListDB() throws SQLException {
       connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root", "1234");
    }
    public Connection getConnection(){
        return connection;
    }

    public  static ToDoListDB getInstance() throws SQLException{
        return instance==null ? instance=new ToDoListDB(): instance;
    }
}
