package Controller;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class HomeController {

    public static ObservableList<SongView> getSongsForTable() {

        ArrayList<SongView> songViews = new ArrayList<>();

        ArrayList<SongDetails> allSongs = new ArrayList<>();

        SongDetailsService.selectAll(allSongs, MainController.database);

        for (SongDetails s: allSongs) {
            songViews.add(new SongView(
                    s.getSongID(),
                    s.getSongName(),
                    ArtistDetailsService.selectById(s.getArtistID(), MainController.database).getFirstName(),
                    AlbumDetailsService.selectById(s.getAlbumID(), MainController.database).getAlbumName()
            ));
        }

        return FXCollections.observableList(songViews);

    }

    public static void setSelectedSong (SongView s) {
        MainController.selectedSong = s;
    }


}
