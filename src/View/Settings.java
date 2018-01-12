package View;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Settings {

    public static BorderPane generateScene() {

        BorderPane settingsPane = new BorderPane();

        Label title = new Label("SETTINGS");
        settingsPane.setTop(title);


        return settingsPane;
    }
}
