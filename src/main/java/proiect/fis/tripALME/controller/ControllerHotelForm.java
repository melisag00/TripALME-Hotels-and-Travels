package proiect.fis.tripALME.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class ControllerHotelForm {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField email;

    @FXML
    private TextField hotelName;

    @FXML
    private TextField address;

    @FXML
    private Button register;

    @FXML
    private Label lbl;

    JSONArray list = new JSONArray();
    @FXML
    public void Login(ActionEvent event) {

        lbl.setText("YES");
        JSONObject obj = new JSONObject();
        obj.put("NAME",username.getText());
        obj.put("email",email.getText());


        list.add(obj);


        try (FileWriter file = new FileWriter("src/main/java/data/data.json")) {

            file.write(list.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

