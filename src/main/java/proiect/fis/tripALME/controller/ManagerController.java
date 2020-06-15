package proiect.fis.tripALME.controller;


import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
public class ManagerController {

    @FXML
    public Text NameH;

    @FXML
    private AnchorPane id;

    @FXML
    private Button close;

    @FXML
    public void OnOpen() {
        JSONParser parser = new JSONParser();
        String a;
        try (Reader reader = new FileReader("src/main/java/data/data.json")) {
            JSONArray jsonArray = (JSONArray) parser.parse(reader);
            Iterator<JSONObject> it = jsonArray.iterator();
            while (it.hasNext()) {
                JSONObject obj = it.next();
                a = obj.get("hotelName").toString();
                NameH.setText(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void AddRooms(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/AddRooms.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("add rooms");
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            System.out.println("Cant load the window");
        }
    }


        }







