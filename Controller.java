package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField textField;
    @FXML
    public Button button;
    @FXML
    public Label label;

    private static final String string1 = "Celsius to Fahrenheit";
    private static final String string2 = "Fahrenheit to Celsius";

    private boolean is_string1 = true;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().add(string1);
        choiceBox.getItems().add(string2);
        choiceBox.setValue(string1);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            is_string1 = t1.equals(string1);

        });

        button.setOnAction(actionEvent -> {
            convert();
        });

    }

    private void convert() {

        String input = textField.getText();
        float enteredTemp = Float.parseFloat(input);
        float convertedTemp = 0.0f;

        if(is_string1)
            convertedTemp = (enteredTemp * 9 / 5) + 32;

        else
            convertedTemp = (enteredTemp - 32) * 5 / 9;


        display(convertedTemp);
    }

    private void display( float temp) {

        String temperature = String.format("%.02f", temp);

        if(is_string1)
            label.setText(temperature + " F");
        else
            label.setText(temperature + " C");
    }
}
