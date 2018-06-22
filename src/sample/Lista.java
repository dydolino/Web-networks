package sample;

import Methods.Cat;
import Methods.Http;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class Lista implements Initializable{

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<JSONObject> catsTable;
    @FXML
    private TableColumn<JSONObject,String>colName;
    @FXML
    private TableColumn<JSONObject,String>colVote;
    @FXML
    private TableColumn<JSONObject,String>colUrl;

    private JSONObject JsonObj;

@Override
public void initialize(URL url, ResourceBundle resourceBundle){

    try {
        List<Cat> cats= Http.getCats(JsonObj);
        updateTable(cats);

    } catch (Exception e) {
        e.printStackTrace();
    }

}

    private void updateTable(List<Cat> cats) {
        cats = Optional.ofNullable(cats).orElse(new ArrayList<>());

        ObservableList<Cat> observableCats = FXCollections.observableArrayList(cats);

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUrl.setCellValueFactory(new PropertyValueFactory<>("URL"));
        colVote.setCellValueFactory(new PropertyValueFactory<>("vote"));


        catsTable.getItems().clear();
        catsTable.setItems(observableCats);
    }






    public void setJsonObj(JSONObject obj) {

        this.JsonObj = obj;
    }


}
