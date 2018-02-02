package Models;

public class SongDetails {
    /////////////////////////////////////SONG DETAILS OBJECT/////////////////////////////////////
    private int SongID;
    private String SongName;
    private int RunTime;
    private int ArtistID;
    private int AlbumID;

    public SongDetails(int songID, String songName, int runTime, int artistID, int albumID) {
        SongID = songID;
        SongName = songName;
        RunTime = runTime;
        ArtistID = artistID;
        AlbumID = albumID;
    }


    public int getSongID() {
        return SongID;
    }

    public void setSongID(int songID) {
        SongID = songID;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public int getRunTime() {
        return RunTime;
    }

    public void setRunTime(int runTime) {
        RunTime = runTime;
    }

    public int getArtistID() {
        return ArtistID;
    }

    public void setArtistID(int artistID) {
        ArtistID = artistID;
    }

    public int getAlbumID() {
        return AlbumID;
    }

    public void setAlbumID(int albumID) {
        AlbumID = albumID;
    }

    @Override
    public String toString() {
        return SongName;
    }
}
