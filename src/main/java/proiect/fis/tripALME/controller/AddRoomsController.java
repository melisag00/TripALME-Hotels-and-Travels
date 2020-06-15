package proiect.fis.tripALME.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import proiect.fis.tripALME.services.ManagerService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddRoomsController  {


    @FXML
    private TextField number;

    @FXML
    private TextField price;

    @FXML
    private TextField description;

    @FXML
    private Text mess;

    @FXML
    private Button closeButton;


    @FXML
    void Done() {
        if (number.getText().isEmpty()) {
            mess.setText("Empty filed");
            return;
        }
        if (price.getText().isEmpty()) {
            mess.setText("Empty filed");
            return;
        }
        if (description.getText().isEmpty()) {
            mess.setText("Empty filed");
            return;
        }
        try {
            ManagerService.addRooms(number.getText(), price.getText(), description.getText());
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        }
















