package sample;

import Methods.Http;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class Controller {

    @FXML
    private TextField emailBox;
    @FXML
    private PasswordField passBox;
    @FXML
    private AnchorPane field;

    public void logInPress(ActionEvent event) throws Exception {

        String mail = emailBox.getText();
        String pass = passBox.getText();

        Http http = new Http();
        StringBuilder response;

        response = http.connection(mail, pass);

        if (response != null) {
            System.out.println("Udalo ci sie zalogowac");
            System.out.println(response.toString());
            Parent rootPane = FXMLLoader.load(getClass().getResource("/Resources/List.fxml"));
            field.getChildren().setAll(rootPane);

        } else {
            System.out.println("Nie udalo Ci sie zalogowac");
            Parent rootPane = FXMLLoader.load(getClass().getResource("/Resources/Fault.fxml"));
            field.getChildren().setAll(rootPane);
        }
    }
}
