package Models;

public class PlaylistSong {
    private int PlaylistID;
    private int SongID;

    public PlaylistSong(int playlistID, int songID) {
        PlaylistID = playlistID;
        SongID = songID;
    }


    public int getPlaylistID() {
        return PlaylistID;
    }

    public void setPlaylistID(int playlistID) {
        PlaylistID = playlistID;
    }

    public int getSongID() {
        return SongID;
    }

    public void setSongID(int songID) {
        SongID = songID;
    }


}
