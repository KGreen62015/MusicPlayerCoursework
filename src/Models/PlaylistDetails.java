package Models;

public class PlaylistDetails {
    private int PlaylistID;
    private String PlaylistName;
    private String CreatorName;



    public PlaylistDetails(int playlistID, String playlistName, String creatorName) {
        PlaylistID = playlistID;
        PlaylistName = playlistName;
        CreatorName = creatorName;

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

    @Override
    public String toString() {
        return PlaylistName + "\t\t\t\t\t\t\t" + CreatorName;
    }
}
