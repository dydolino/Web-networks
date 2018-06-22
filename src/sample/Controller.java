package sample;

import Methods.Http;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.json.JSONObject;

import java.io.IOException;


public class Controller {

    @FXML
    private TextField emailBox;
    @FXML
    private PasswordField passBox;
    @FXML
    private AnchorPane field;
    @FXML
    private Label label;

    Http http;

    public void logInPress(ActionEvent event) {

        String mail = emailBox.getText();
        String pass = passBox.getText();

        http = new Http();
        JSONObject response = null;

        try {
            response = http.connection(mail, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response != null) {
            System.out.println("Udalo ci sie zalogowac");
            System.out.println(response.toString());

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Resources/List.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            List list = loader.getController();
            list.setJsonObj(response);

            Parent p = loader.getRoot();

            field.getChildren().setAll(p);

        } else {
            System.out.println("Nie udalo Ci sie zalogowac");
            label.setText("Nieprawidłowy login lub hasło! ");
        }
    }
}
