package View;

import Controller.PlaylistController;
import Models.PlaylistDetails;
import Models.PlaylistDetailsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class Playlist {

    public static BorderPane generateScene() {

        BorderPane playListPane = new BorderPane();

        Label title = new Label("PLAYLIST");
        playListPane.setTop(title);
        /////////////////////////////////////LIST VIEW/////////////////////////////////////
        ListView<PlaylistDetails> playListlist = new ListView<>();
        playListlist.setItems(FXCollections.observableList(PlaylistController.getItems()));
        playListPane.setCenter(playListlist);

        return playListPane;
    }
}
