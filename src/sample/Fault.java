package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Fault {

    @FXML
    private AnchorPane anchorPane;

    public void back(ActionEvent event) throws IOException {
        Parent rootPane = FXMLLoader.load(getClass().getResource("/src/Resources/Fault.fxml"));
        anchorPane.getChildren().setAll(rootPane);
    }
}
