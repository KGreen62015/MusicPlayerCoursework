package Controller;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class HomeController {

    public static ObservableList<SongView> getSongsForTable(String searchQuery) {

        ArrayList<SongView> songViews = new ArrayList<>();

        ArrayList<SongDetails> allSongs = new ArrayList<>();

        SongDetailsService.selectAll(allSongs, MainController.database);

        for (SongDetails s: allSongs) {

            String artist = ArtistDetailsService.selectById(s.getArtistID(), MainController.database).getFirstName();
            String album = AlbumDetailsService.selectById(s.getAlbumID(), MainController.database).getAlbumName();

            if (s.getSongName().toLowerCase().contains(searchQuery.toLowerCase()) ||
                    artist.toLowerCase().contains(searchQuery.toLowerCase()) ||
                    album.toLowerCase().contains(searchQuery.toLowerCase())) {

                songViews.add(new SongView(
                        s.getSongID(), s.getSongName(), artist, album
                ));
            }
        }

        return FXCollections.observableList(songViews);

    }

    public static void setSelectedSong (SongView s) {
        MainController.selectedSong = s;
    }


}
