package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        MenuBar menuBar = createMenu();
        root.getChildren().add(0,menuBar);
    }

    private MenuBar createMenu() {
        Menu help = new Menu("Help");
        MenuItem contact_us = new MenuItem("Contact Us");

        help.getItems().addAll(contact_us);

        contact_us.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                contact_us();
            }
        });

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(help);

        return menuBar;

    }

    private void contact_us() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Contact Us");
        alert.setHeaderText("Contacts");
        alert.setContentText("Name : ABHINANDAN KARMAKAR\n"+"E-mail : abhinandan.karmakar.3003@gmail.com");
        alert.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
