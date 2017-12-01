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
    }

    public static AlbumDetails selectById(int id, DatabaseConnection database) {

        AlbumDetails result = null;

        PreparedStatement statement = database.newStatement("SELECT AlbumID, AlbumName, ArtistID FROM AlbumDetails WHERE AlbumID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new AlbumDetails(
                            results.getInt("AlbumID"),
                            results.getString("AlbumName"),
                            results.getInt("ArtistID"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }

}
