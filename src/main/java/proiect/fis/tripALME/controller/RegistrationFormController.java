package proiect.fis.tripALME.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import proiect.fis.tripALME.exceptions.UsernameAlreadyExistsException;
import proiect.fis.tripALME.services.UserService;


public class RegistrationFormController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField email;

    @FXML
    private TextField address;

    @FXML
    private TextField hotelName;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label emailLable;

    @FXML
    private Label addressLable;

    @FXML
    private Label hotelNameLable;

    @FXML
    private Label registrationInfo;

    @FXML
    private CheckBox id_Client;

    @FXML
    private CheckBox id_Hotel;

    private boolean emptyField;
    private String role;

    @FXML
    public void Login(ActionEvent event) {

        emptyField = false;

        usernameLabel.setText("");
        passwordLabel.setText("");
        emailLable.setText("");
        addressLable.setText("");
        hotelNameLable.setText("Just for hotel managers");

        if(username.getText().isEmpty()) {
            usernameLabel.setText("Empty filed");
            emptyField = true;
        }
        if(password.getText().isEmpty()) {
            passwordLabel.setText("Empty filed");
            emptyField = true;
        }
        if(email.getText().isEmpty()) {
            emailLable.setText("Empty filed");
            emptyField = true;
        }
        if(address.getText().isEmpty()) {
            addressLable.setText("Empty filed");
            emptyField = true;
        }
        if(hotelName.getText().isEmpty() && id_Hotel.isSelected()) {
            hotelNameLable.setText("Empty filed");
            emptyField = true;
        }

        if(emptyField){
            registrationInfo.setText("Registration failed");
            return;
        }

        if(!id_Hotel.isSelected() && !id_Client.isSelected()){
            registrationInfo.setText("Choose one role");
            return;
        }

        if(id_Hotel.isSelected() && id_Client.isSelected()){
            registrationInfo.setText("Choose just one role");
            return;
        }

        if(id_Client.isSelected())
            role="client";
        if(id_Hotel.isSelected());
            role="manager";

        try {
            UserService.addUser(username.getText(), password.getText(), email.getText(), address.getText(), hotelName.getText(), role);
            registrationInfo.setText("Registration successful");
        } catch (UsernameAlreadyExistsException e) {
            registrationInfo.setText(e.getMessage());
        }
    }



   }


