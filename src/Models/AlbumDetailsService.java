package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AlbumDetailsService {
    public static void selectAll(List<AlbumDetails> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT AlbumID, AlbumName, ArtistID FROM AlbumDetails ORDER BY AlbumID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new AlbumDetails(
                                results.getInt("AlbumID"),
                                results.getString("AlbumName"),
                                results.getInt("ArtistID")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
}}
