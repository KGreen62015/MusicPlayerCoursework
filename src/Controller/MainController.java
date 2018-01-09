package Controller;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class MainController {

    public static DatabaseConnection database;

    public static void init() {

        database = new DatabaseConnection("MusicPlayerDatabase.db");

    }

    public static ObservableList<SongView> getSongsForTable() {

        ArrayList<SongView> songViews = new ArrayList<>();

        ArrayList<SongDetails> allSongs = new ArrayList<>();

        SongDetailsService.selectAll(allSongs, database);

        for (SongDetails s: allSongs) {
            songViews.add(new SongView(
                    s.getSongID(),
                    s.getSongName(),
                    ArtistDetailsService.selectById(s.getArtistID(), database).getFirstName(),
                    AlbumDetailsService.selectById(s.getAlbumID(), database).getAlbumName()
            ));
        }

        return FXCollections.observableList(songViews);

    }


    public static void search() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Search coming soon...");
        alert.showAndWait();
    }
    public static void search1() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("X coming soon...");
        alert.showAndWait();
    }
    public static void home() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Home coming soon...");
        alert.showAndWait();
    }
    public static void playlist() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Playlist coming soon...");
        alert.showAndWait();
    }
    public static void settings() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Settings coming soon...");
        alert.showAndWait();
    }
    public static void backbutton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Backbutton coming soon...");
        alert.showAndWait();
    }
    public static void playbutton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("PlayButton coming soon...");
        alert.showAndWait();
    }
    public static void nextbutton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Nextbutton coming soon...");
        alert.showAndWait();
    }


    public static void databaseTest() {


        ArrayList<SongDetails> testList = new ArrayList<>();

        SongDetailsService.selectAll(testList, database);

        for (SongDetails c: testList) {
            System.out.println(c);
        }

        ArrayList<ArtistDetails> testList1 = new ArrayList<>();

        ArtistDetailsService.selectAll(testList1, database);

        for (ArtistDetails c: testList1) {
            System.out.println(c);
        }
        ArrayList<AlbumDetails> testList2 = new ArrayList<>();

        AlbumDetailsService.selectAll(testList2, database);

        for (AlbumDetails c: testList2) {
            System.out.println(c);
        }

    }

}
