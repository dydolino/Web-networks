package sample;

import Methods.Http;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class List {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField textField;

    Controller controller = new Controller();
    Http http = controller.http;


    public void showJSON(ActionEvent event) throws Exception {

        JSONArray kotki =http.getObjects();

        for (int i=0;i<kotki.length();i++){
            JSONObject kotek=kotki.getJSONObject(i);
            System.out.println(kotek.getString("name"));
        }

    }
}
