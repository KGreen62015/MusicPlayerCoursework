package View;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Playlist {

    public static BorderPane generateScene() {

        BorderPane playListPane = new BorderPane();

        Label title = new Label("PLAYLIST");
        playListPane.setTop(title);

        return playListPane;
    }
}
