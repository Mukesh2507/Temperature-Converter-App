package com.internshala.tempconverterapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label WelcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField userInputField;
    @FXML
    public Button convertButton;
    private static final String C_TO_F = "celsius to Fehrenheit";
    private static final String F_TO_c = "Fehrenheit to celsius";
    private boolean isC_TO_F = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().add(C_TO_F);
        choiceBox.getItems().add(F_TO_c);
        choiceBox.setValue(C_TO_F);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(C_TO_F)) {
                isC_TO_F = true;
            } else {
                isC_TO_F = false;
            }
        });
        convertButton.setOnAction(event -> {
            convert();
        });
    }

    private void convert() {
        String input = userInputField.getText();
        try {
            float enteredTemperature = Float.parseFloat(input);
        } catch (Exception e) {
            warnUser();
            return;
        }

float enteredTemperature =0.0f;
        float newTemperature = 0.0f;
        if (isC_TO_F) {
            newTemperature = (enteredTemperature * 9 / 5) + 32;
        } else {
            newTemperature = (enteredTemperature - 32) * 5 / 9;
        }
        display(newTemperature);
    }

    private void warnUser() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error occured");
        alert.setHeaderText("invalid temperature");
        alert.setContentText("please entered valid temperature");
        alert.show();
    }

    private void display(float newTemperature) {

        String unit = isC_TO_F ? "F" : "c";
        System.out.println("the new temperature is: " + newTemperature + unit);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("the new temperature is " + newTemperature + unit);
        alert.show();
    }

}
