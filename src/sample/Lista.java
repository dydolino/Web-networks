package sample;

import Methods.Cat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.json.JSONObject;

import java.util.List;

import static Methods.Http.getCats;

public class Lista {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<JSONObject> catsTable;
    @FXML
    private TableColumn<JSONObject, String> colName;
    @FXML
    private TableColumn<JSONObject, String> colVote;
    @FXML
    private TableColumn<JSONObject, String> colUrl;

    private JSONObject JsonObj;
    private List<Cat> cats;


    public void setJsonObj(JSONObject obj) throws Exception {

        this.JsonObj = obj;
        cats = getCats(JsonObj);

    }
    
}
