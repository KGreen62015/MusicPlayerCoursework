package Models;

import java.io.Console;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SongDetailsService {

    public static void selectAll(List<SongDetails> targetList, DatabaseConnection database) {
        /////////////////////////////////////SELECT ALL FROM SONG/////////////////////////////////////
        PreparedStatement statement = database.newStatement("SELECT SongID, SongName, RunTime, ArtistID, AlbumID FROM SongDetails ORDER BY SongID");
//connect to database an get the stuff
        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new SongDetails(
                                results.getInt("SongID"),
                                results.getString("SongName"),
                                results.getInt("RunTime"),
                                results.getInt("ArtistID"),
                                results.getInt("AlbumID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }
}
