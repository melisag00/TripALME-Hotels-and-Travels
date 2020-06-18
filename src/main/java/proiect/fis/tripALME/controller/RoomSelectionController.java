package proiect.fis.tripALME.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import proiect.fis.tripALME.services.ClientService;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class RoomSelectionController {


        @FXML
        private Text message;

        @FXML
        private ListView<String> roomList;

        @FXML
        private AnchorPane RoomSelection;


    private  String selection;
    private static ArrayList list;


    public void initialize() {
        JSONParser parser1 = new JSONParser();

        try (Reader reader = new FileReader("src/main/java/data/rooms.json")) {

            JSONArray jsonArray = (JSONArray) parser1.parse(reader);
            list = jsonArray;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



        for (int i=0;i<list.size();i++) {

            JSONObject obj=(JSONObject) list.get(i);

            roomList.getItems().add(obj.get("Number").toString() + "  " + obj.get("Category").toString() + "  " + obj.get("Price").toString());
        }

        roomList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }



    @FXML
    void Select() {

        selection = roomList.getSelectionModel().getSelectedItem();
        if(ClientService.writeRequest(selection)){
            message.setText("Request successful");
        }
        else {
            message.setText("Request failed");
        }

    }


    @FXML
    void Back() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("HotelSelection.fxml"));
            RoomSelection.getChildren().setAll(pane);
        } catch (Exception e) {
        }
    }
}
