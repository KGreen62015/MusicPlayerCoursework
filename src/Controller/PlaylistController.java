package Controller;

import Models.PlaylistDetails;
import Models.PlaylistDetailsService;
import View.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistController {

    public static List<PlaylistDetails> getItems() {

        List<PlaylistDetails> playlists = new ArrayList<>();
        PlaylistDetailsService.selectAll(playlists, MainController.database);
        return playlists;

    }

}
