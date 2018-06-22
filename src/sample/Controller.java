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


    public void logInPress(ActionEvent event) throws Exception {

        String mail = emailBox.getText();
        String pass = passBox.getText();

        JSONObject response = null;

        try {
            response = Http.connection(mail, pass);
        } catch (IOException e) {
            System.out.println("Nieprawidłowe hasło lub login");
        }

        if (response != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Resources/Lista.fxml"));

            loader.load();
            Lista lista = loader.getController();
            lista.setJsonObj(response);
            Parent p = loader.getRoot();
            field.getChildren().setAll(p);

        } else {
            label.setText("Nieprawidłowy login lub hasło! ");
        }
    }
}
