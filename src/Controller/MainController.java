package Controller;

import Models.*;
import View.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainController {
    public static DatabaseConnection database;

    public static MediaPlayer songPlayer;

    public static double volume = 1;

    public static SongView selectedSong;
    public static SongView currentlyPlayingSong;
    public static boolean playing = false;

    public static void init() {

        database = new DatabaseConnection("MusicPlayerDatabase.db");

    }
    //when the corrosponding button is clicked it clears the scene and loads the new scene
    public static void home() {
        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(Main.generateButtons(), Home.generateScene(), Main.generateControls());
    }
    public static void playlist() {
        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(Main.generateButtons(), Playlist.generateScene(), Main.generateControls());
    }
    public static void settings() {
        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(Main.generateButtons(), Settings.generateScene(), Main.generateControls());
    }

    public static void backbutton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Backbutton coming soon...");
        alert.showAndWait();
    }
//sets the volume slider to be out of 1 so it can be used to change the volume of the song (0-1)
    public static void setVolume(double value) {
        volume = value/100;
        if (playing) {
            songPlayer.setVolume(volume);
        }
    }

    public static void playbutton() {
//checks if a song is playing
        //////////////////////HELP///////////////////////
        if (playing) {

            Main.imgViewPlayPause.setImage(Main.imgplay);

            if (songPlayer != null) {

                songPlayer.pause();
                playing = false;
            }

        } else
        {

            if (songPlayer != null && selectedSong != currentlyPlayingSong)
            {
                songPlayer.pause();
                songPlayer = null;
            }

            if (songPlayer == null) {

                if (selectedSong != null) {

                    File songFile = new File("Music/" + Integer.toString(selectedSong.getId()) + ".mp3");
                    //if the song file is not there it pops up this alert
                    if (!songFile.isFile()) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("File not found!");
                        alert.showAndWait();

                    } else {
                        //changes the song lable, depending on the song playing

                        Main.songlabel.setText(selectedSong.getName());
                        Main.albumlabel.setText(selectedSong.getArtist());
                        Main.artistlabel.setText(selectedSong.getAlbum());

                        Media songMedia = new Media(songFile.toURI().toString());
                        songPlayer = new MediaPlayer(songMedia);
                        songPlayer.play();
                        currentlyPlayingSong = selectedSong;
                        playing = true;

                    }

                }

            }
            else {
                songPlayer.play();      //UN-PAUSE
                playing = true;
                currentlyPlayingSong = selectedSong;
            }

            if (playing) {
                Main.imgViewPlayPause.setImage(Main.imgpause);
                songPlayer.setVolume(volume);
            }

        }

    }
    public static void nextbutton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Nextbutton coming soon...");
        alert.showAndWait();
    }

    //testing database conection
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
