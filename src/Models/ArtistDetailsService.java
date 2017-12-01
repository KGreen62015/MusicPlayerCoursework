package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ArtistDetailsService {
    public static void selectAll(List<ArtistDetails> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT ArtistID, ArtistName FROM ArtistDetails ORDER BY ArtistID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new ArtistDetails(
                                results.getInt("ArtistID"),
                                results.getString("ArtistName")));
                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }

    public static ArtistDetails selectById(int id, DatabaseConnection database) {

        ArtistDetails result = null;

        PreparedStatement statement = database.newStatement("SELECT ArtistID, ArtistName FROM ArtistDetails WHERE ArtistID = ?");

        try {
            if (statement != null) {

                statement.setInt(1, id);
                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    result = new ArtistDetails(
                            results.getInt("ArtistID"),
                            results.getString("ArtistName"));
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select by id error: " + resultsException.getMessage());
        }

        return result;
    }


}
