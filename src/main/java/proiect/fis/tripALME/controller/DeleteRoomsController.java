package proiect.fis.tripALME.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.*;



public class DeleteRoomsController {

    @FXML
    private ListView<String> roomList;

    
    ArrayList<String> list = new ArrayList<String>();

    JSONParser parser1 = new JSONParser();

    JSONObject list11 = new JSONObject();

    String username = "";

    public void initialize() {

        try (Reader reader = new FileReader("src/main/java/data/logininfo.json")) {
            JSONObject jsonArray = (JSONObject) parser1.parse(reader);
            list11 = jsonArray;
            username = list11.get("username").toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try (Reader reader = new FileReader("src/main/java/data/rooms.json")) {
            JSONArray jsonArray = (JSONArray) parser1.parse(reader);

            Iterator<JSONObject> it = jsonArray.iterator();
            while (it.hasNext()) {
                JSONObject obj = it.next();
                String a = obj.get("Number").toString();
                String b = obj.get("UserName").toString();
                if(b.equals(username))
                list.add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        roomList.getItems().addAll(list);
    }

}









