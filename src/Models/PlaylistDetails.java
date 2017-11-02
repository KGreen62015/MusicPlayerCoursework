package Models;

public class PlaylistDetails {
    private int PlaylistID;
    private String PlaylistName;
    private String CreatorName;
    private int AmountOfSongs;


    public PlaylistDetails(int playlistID, String playlistName, String creatorName, int amountOfSongs) {
        PlaylistID = playlistID;
        PlaylistName = playlistName;
        CreatorName = creatorName;
        AmountOfSongs = amountOfSongs;
    }


    public int getPlaylistID() {
        return PlaylistID;
    }

    public void setPlaylistID(int playlistID) {
        PlaylistID = playlistID;
    }

    public String getPlaylistName() {
        return PlaylistName;
    }

    public void setPlaylistName(String playlistName) {
        PlaylistName = playlistName;
    }

    public String getCreatorName() {
        return CreatorName;
    }

    public void setCreatorName(String creatorName) {
        CreatorName = creatorName;
    }

    public int getAmountOfSongs() {
        return AmountOfSongs;
    }

    public void setAmountOfSongs(int amountOfSongs) {
        AmountOfSongs = amountOfSongs;
    }

    @Override
    public String toString() {
        return PlaylistName;
    }
}
