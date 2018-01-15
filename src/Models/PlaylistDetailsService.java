package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlaylistDetailsService {


    public static void selectAll(List<PlaylistDetails> targetList, DatabaseConnection database) {

        PreparedStatement statement = database.newStatement("SELECT PlaylistID, PlaylistName, CreatorName, AmountOfSongs FROM PlaylistDetails ORDER BY PlaylistID");

        try {
            if (statement != null) {

                ResultSet results = database.executeQuery(statement);

                if (results != null) {
                    while (results.next()) {
                        targetList.add(new PlaylistDetails(
                                results.getInt("PlaylistID"),
                                results.getString("PlaylistName"),
                                results.getString("CreatorName"),
                                results.getInt("AmountOfSongs")));

                    }
                }
            }
        } catch (SQLException resultsException) {
            System.out.println("Database select all error: " + resultsException.getMessage());
        }
    }




}


