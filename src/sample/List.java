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

    private JSONObject JsonObj;


    public void setJsonObj(JSONObject obj){

        this.JsonObj=obj;
    }

    public void showJSON(ActionEvent event) throws Exception {

        System.out.println("Token= "+JsonObj.getString("access_token"));

    }
}
