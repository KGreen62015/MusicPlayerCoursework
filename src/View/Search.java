package View;

import Controller.MainController;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Search {

    public static BorderPane generateScene() {

        BorderPane searchPane = new BorderPane();

        Label title = new Label("SEARCH");
        searchPane.setTop(title);


        return searchPane;
    }

}
