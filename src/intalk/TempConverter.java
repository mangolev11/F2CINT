/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intalk;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Fodor
 */
public class TempConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField txtDegrees = new TextField();
        Label lblDegrees = new Label("Fok:");
        lblDegrees.setLabelFor(txtDegrees);
        Button btnToC = new Button("To C");
        btnToC.setOnAction(ae
                -> {
            try {
                String input = txtDegrees.getText();
                double deg = Double.parseDouble(input);
                txtDegrees.setText("" + ((deg - 32) * 5 / 9.0));
            } catch (NumberFormatException nfe) {
                new Alert(AlertType.ERROR,
                        "Egy számot vár az alkalmazás").showAndWait();
            }
        });
        Button btnToF = new Button("To F");
        btnToF.setOnAction(ae
                -> {
            try {
                String input = txtDegrees.getText();
                double deg = Double.parseDouble(input);
                txtDegrees.setText("" + (deg * 9 / 5.0 + 32));
            } catch (NumberFormatException nfe) {
                new Alert(AlertType.ERROR,
                        "Egy számot vár az alkalmazás").showAndWait();
            }
        });
        HBox hboxForm = new HBox(10);
        hboxForm.setPadding(new Insets(10, 10, 10, 10));
        hboxForm.getChildren().addAll(lblDegrees, txtDegrees, btnToC, btnToF);
        Scene scene = new Scene(hboxForm);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("TempConverter");
        primaryStage.show();
    }

}
