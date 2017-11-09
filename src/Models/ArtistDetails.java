package Models;

public class ArtistDetails {
    private int ArtistID;
    private String ArtistName;



    public ArtistDetails(int artistID, String firstName) {
        ArtistID = artistID;
        ArtistName = firstName;

    }


    public int getArtistID() {
        return ArtistID;
    }

    public void setArtistID(int artistID) {
        ArtistID = artistID;
    }

    public String getFirstName() {
        return ArtistName;
    }

    public void setFirstName(String firstName) {
        ArtistName = firstName;
    }



    @Override
    public String toString() {
        return ArtistName;
    }
}
