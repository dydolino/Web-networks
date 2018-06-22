package sample;

import Methods.Cat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.json.JSONObject;

import java.util.List;

import static Methods.Http.getCats;

public class Lista {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label name;
    @FXML
    private Label votes;
    @FXML
    private ImageView photo;


    private JSONObject JsonObj;
    private List<Cat> cats;
    private static int counter=0;


    public void setJsonObj(JSONObject obj) throws Exception {

        this.JsonObj = obj;
        cats = getCats(JsonObj);
        name.setText(cats.get(counter).getName());
        votes.setText(String.valueOf(cats.get(counter).getVotes()));
        Image image=new Image(cats.get(counter).getURL());
        photo.setImage(image);
        counter++;

    }

    public void nextCat(ActionEvent event) {
        name.setText(cats.get(counter).getName());
        votes.setText(String.valueOf(cats.get(counter).getVotes()));
        Image image=new Image(cats.get(counter).getURL());
        photo.setImage(image);
        counter++;


    }
}
