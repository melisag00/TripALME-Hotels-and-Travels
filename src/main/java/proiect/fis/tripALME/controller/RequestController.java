package proiect.fis.tripALME.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

public class RequestController {

    @FXML
    private ListView<String> List;

    @FXML
    private ListView<String> List1;


    @FXML
    private Text message;

    @FXML
    private TextField check;

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list1 = new ArrayList<String>();
    JSONParser parser1 = new JSONParser();
    JSONParser parser2 = new JSONParser();
    JSONObject list11 = new JSONObject();
    String username = "";

    public void initialize() {

        try (Reader reader = new FileReader("src/main/java/data/logininfo.json")) {
            JSONObject json = (JSONObject) parser1.parse(reader);
            list11 = json;
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
        List.getItems().addAll(list);
        try (Reader reader = new FileReader("src/main/java/data/request.json")) {
            JSONArray jsonArray = (JSONArray) parser2.parse(reader);
            Iterator<JSONObject> it = jsonArray.iterator();
            while (it.hasNext()) {
                JSONObject obj = it.next();
                String x = obj.get("request").toString();
                    list1.add(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List1.getItems().addAll(list1);
    }

    @FXML
    void Check() {

        String x = check.getText();
        try (Reader reader = new FileReader("src/main/java/data/request.json")) {
            JSONArray jsonArray = (JSONArray) parser1.parse(reader);

            for (int i=0;i<jsonArray.size();i++) {
                JSONObject o = (JSONObject) jsonArray.get(i);
                if (o.get("request").equals(x))
                {  message.setText("The room is available");
                break;}
                else
                {  message.setText("The room is not available");
                break;}
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}

