package Models;

import javafx.beans.property.SimpleStringProperty;

public class SongView {
    /////////////////////////////////////OBJECT SONG FOR TABLE VIEW/////////////////////////////////////
    public int id;
    public SimpleStringProperty name;
    public SimpleStringProperty artist;
    public SimpleStringProperty album;

    public SongView(int id, String name, String artist, String album) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.artist = new SimpleStringProperty(artist);
        this.album = new SimpleStringProperty(album);
    }
    /////////////////////////////////////GETTER AND SETTER/////////////////////////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getArtist() {
        return artist.get();
    }

    public SimpleStringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getAlbum() {
        return album.get();
    }

    public SimpleStringProperty albumProperty() {
        return album;
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }
}
