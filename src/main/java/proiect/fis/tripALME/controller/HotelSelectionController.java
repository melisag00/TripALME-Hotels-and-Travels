package proiect.fis.tripALME.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import proiect.fis.tripALME.services.ClientService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HotelSelectionController {

    @FXML
    private ListView<String> hotelList;

    @FXML
    private ListView<String> cityList;

    @FXML
    private TextArea status;

    @FXML
    private AnchorPane client;

    private static JSONArray rooms = new JSONArray();
    private static String city;

    public void initialize() {
        Object p;
        JSONParser parser = new JSONParser();
        try {
            FileReader readFile = new FileReader("src/main/java/data/city.json");
            BufferedReader read = new BufferedReader(readFile);
            p = parser.parse(read);
            if (p instanceof JSONArray) {
                rooms = (JSONArray) p;
            }

        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }

        cityList.getItems().addAll(rooms);
        cityList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


    }

    @FXML
    public void SelectCity() {

        hotelList.getItems().clear();

        city = cityList.getSelectionModel().getSelectedItem();

        JSONArray cityList = ClientService.displayHotels(city);

        if (cityList.isEmpty()) {
            hotelList.getItems().add("This city dosen't have any Hotel");
        } else {
            hotelList.getItems().addAll(cityList);
        }


    }

    @FXML
    public void SelectHotel() {

        String hotel;

        hotel = hotelList.getSelectionModel().getSelectedItem();

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("RoomSelection.fxml"));
            client.getChildren().setAll(pane);
        } catch (Exception e) {
            System.out.println("Cant load the window");
        }


    }


    @FXML
    void Back() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("Client.fxml"));
            client.getChildren().setAll(pane);
        } catch (Exception e) {
        }
    }
}
