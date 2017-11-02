package Models;

public class AlbumDetails {
    private int AlbumID;
    private String AlbumName;
    private int ArtistID;

    public AlbumDetails(int albumID, String albumName, int artistID) {
        AlbumID = albumID;
        AlbumName = albumName;
        ArtistID = artistID;
    }


    public int getAlbumID() {
        return AlbumID;
    }

    public void setAlbumID(int albumID) {
        AlbumID = albumID;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public int getArtistID() {
        return ArtistID;
    }

    public void setArtistID(int artistID) {
        ArtistID = artistID;
    }

    @Override
    public String toString() {
        return AlbumName;
    }
}
