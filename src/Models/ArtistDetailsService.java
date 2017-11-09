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




}
