package proiect.fis.tripALME.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.json.JSONArray;
import org.json.JSONObject;

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
    private TextField adress;

//    @FXML
//    private Label lbl;

   private JSONArray list = new JSONArray();
    @FXML
    public void Login(ActionEvent event) {

       // lbl.setText("YES");
        JSONObject obj = new JSONObject();
        obj.put("NAME",username.getText());
        obj.put("email",email.getText());
        obj.put("hotelName",hotelName.getText());
        obj.put("adress", adress.getText());



        list.put(obj);


        try (FileWriter file = new FileWriter("src/main/java/data/data.json")) {

            file.write(list.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

