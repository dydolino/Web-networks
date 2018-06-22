package sample;

import Methods.Cat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private Button nextBtn;
    @FXML
    private Button pageBtn;
    @FXML
    private Button previousCat;
    @FXML
    private Button previousPage;


    private JSONObject JsonObj;
    private List<Cat> cats;
    private static int counter = 0;
    private static int pageNumber = 1;


    public void setJsonObj(JSONObject obj) throws Exception {
        previousCat.setDisable(true);
        previousPage.setDisable(true);

        this.JsonObj = obj;
        cats = getCats(JsonObj, pageNumber);
        name.setText(cats.get(counter).getName());
        votes.setText(String.valueOf(cats.get(counter).getVotes()));
        Image image = new Image(cats.get(counter).getURL());
        photo.setImage(image);
        counter++;

    }


    public void nextCat(ActionEvent event) {
        previousCat.setDisable(false);
        counter++;
        try {
            name.setText(cats.get(counter).getName());
            votes.setText(String.valueOf(cats.get(counter).getVotes()));
            Image image = new Image(cats.get(counter).getURL());
            photo.setImage(image);
            if (cats.size() == counter + 1) {
                nextBtn.setDisable(true);
            }
        } catch (Exception e) {

        }

    }

    public void nextPage(ActionEvent event) {
        previousPage.setDisable(false);
        pageNumber++;
        counter = 0;
        try {
            cats = getCats(JsonObj, pageNumber);
            name.setText(cats.get(counter).getName());
            votes.setText(String.valueOf(cats.get(counter).getVotes()));
            Image image = new Image(cats.get(counter).getURL());
            photo.setImage(image);
            nextBtn.setDisable(false);
            previousCat.setDisable(true);
        } catch (Exception e) {
            pageBtn.setDisable(true);
            nextBtn.setDisable(false);
            previousCat.setDisable(true);
        }


    }

    public void preCat(ActionEvent event) {
        counter--;
        try {
            name.setText(cats.get(counter).getName());
            votes.setText(String.valueOf(cats.get(counter).getVotes()));
            Image image = new Image(cats.get(counter).getURL());
            photo.setImage(image);
            nextBtn.setDisable(false);
            if (counter == 0) {
                previousCat.setDisable(true);
            }
        } catch (Exception e) {
            previousCat.setDisable(true);

        }
    }

    public void prePage(ActionEvent event) {
        pageNumber--;
        counter = 0;
        try {
            cats = getCats(JsonObj, pageNumber);
            name.setText(cats.get(counter).getName());
            votes.setText(String.valueOf(cats.get(counter).getVotes()));
            Image image = new Image(cats.get(counter).getURL());
            photo.setImage(image);
            pageBtn.setDisable(false);
            previousCat.setDisable(true);

            if (pageNumber == 1) {
                previousPage.setDisable(true);
            }
        } catch (Exception e) {
        }

    }
}
