package Models;

public class ArtistDetails {
    private int ArtistID;
    private String FirstName;
    private String LastName;


    public ArtistDetails(int artistID, String firstName, String lastName) {
        ArtistID = artistID;
        FirstName = firstName;
        LastName = lastName;
    }


    public int getArtistID() {
        return ArtistID;
    }

    public void setArtistID(int artistID) {
        ArtistID = artistID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return FirstName + LastName;
    }
}
