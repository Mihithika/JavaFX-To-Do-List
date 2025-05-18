package ecom.icet.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public  void start(Stage stage)throws Exception{
        stage.setScene(
                new Scene(
                        FXMLoader.load(getClass().getResource("view/"))
                )
        );
        stage.show();
    }

}