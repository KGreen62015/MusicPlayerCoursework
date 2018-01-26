package View;

import Controller.HomeController;
import Controller.MainController;
import Models.SongView;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class Home {

    public static TableView<SongView> songTable;

    public static BorderPane generateScene() {

        BorderPane homePane = new BorderPane();

        Label title = new Label("HOME");
        homePane.setTop(title);
        TextField search = new TextField();
        search.setPromptText("Search");
        homePane.setLeft(search);

        search.textProperty().addListener((observable, oldValue, newValue) -> {
            songTable.setItems(HomeController.getSongsForTable(newValue));
        });

        songTable = new TableView<>();

        TableColumn nameColumn = new TableColumn<>("Song");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.33));
        songTable.getColumns().add(nameColumn);

        TableColumn artistColumn = new TableColumn<>("Artist");
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        artistColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.333));
        songTable.getColumns().add(artistColumn);

        TableColumn albumColumn = new TableColumn<>("Album");
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
        albumColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.33));
        songTable.getColumns().add(albumColumn);

        songTable.setItems(HomeController.getSongsForTable(""));

        songTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            HomeController.setSelectedSong(newSelection);
        });

        homePane.setBottom(songTable);

        return homePane;

    }



}
