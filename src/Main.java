import Models.*;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static DatabaseConnection database;

    @Override
    public void start(Stage stage) throws Exception {
        database = new DatabaseConnection("MusicPlayerDatabase.db");

        BorderPane root = new BorderPane();


        Scene scene = new Scene(root, 1024, 768);

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();

        HBox boxOfButtons = new HBox(1);

        Button[] myButtons = new Button[5];

        myButtons[0] = new Button("Search");
        myButtons[0].setPrefSize(200, 50);
        myButtons[0].setOnAction((ActionEvent ae) -> doSomething(ae));

        myButtons[1] = new Button("Search");
        myButtons[1].setPrefSize(200, 50);
        myButtons[1].setOnAction((ActionEvent ae) -> doSomething(ae));

        myButtons[2] = new Button("Home");
        myButtons[2].setPrefSize(200, 50);
        myButtons[2].setOnAction((ActionEvent ae) -> doSomething(ae));

        myButtons[3] = new Button("Playlist");
        myButtons[3].setPrefSize(200, 50);
        myButtons[3].setOnAction((ActionEvent ae) -> doSomething(ae));

        myButtons[4] = new Button("Settings");
        myButtons[4].setPrefSize(200, 50);
        myButtons[4].setOnAction((ActionEvent ae) -> doSomething(ae));
        boxOfButtons.getChildren().addAll(myButtons);
        root.setTop(boxOfButtons);

        /*HBox mid = new HBox(0);
        mid.setPadding(new Insets(10));
        root.setCenter(mid);
        ObservableList<Person> people = FXCollections.observableArrayList(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
        );
        TableView table = new TableView<>();
        table.setPrefSize(400, 300);
        table.setItems(people);

        TableColumn firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        table.getColumns().add(firstNameColumn);

        TableColumn lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        table.getColumns().add(lastNameColumn);

        TableColumn emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.getColumns().add(emailColumn);

        root.getChildren().add(table);
        /*ListView<String> list = new ListView<>();
        HBox.setHgrow(list, Priority.ALWAYS);
        mid.getChildren().add(list);*/


        HBox leftAndRightBox = new HBox(2);
        leftAndRightBox.setAlignment(Pos.CENTER);
        leftAndRightBox.setPadding(new Insets(15));

        VBox details = new VBox();


        Label songlabel = new Label("Song");
        songlabel.setFont(new Font(20));
        details.getChildren().add(songlabel);

        Label albumlabel = new Label("Album");
        albumlabel.setFont(new Font(20));
        details.getChildren().add(albumlabel);

        Label artistlabel = new Label("Artist");
        artistlabel.setFont(new Font(20));
        details.getChildren().add(artistlabel);
        leftAndRightBox.getChildren().add(details);


        Button bottomButton1 = new Button("I am on the left.");
        leftAndRightBox.getChildren().add(bottomButton1);


        Button bottomButton2 = new Button("I am also on the left.");
        leftAndRightBox.getChildren().add(bottomButton2);

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(75);

        HBox rightSection = new HBox(20);

        HBox.setHgrow(rightSection, Priority.ALWAYS);
        rightSection.setAlignment(Pos.CENTER_RIGHT);


        /*ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefSize(400, 30);
        progressBar.setProgress(0.5);

        slider.valueProperty().addListener(
                (observable, old_value, new_value) -> progressBar.setProgress(new_value.doubleValue() / 100));*/

        rightSection.getChildren().addAll(slider/*, progressBar*/);

        /*Button bottomButton3 = new Button("I am on the right.");
        rightSection.getChildren().add(bottomButton3);*/
        leftAndRightBox.getChildren().add(rightSection);
        root.setBottom(leftAndRightBox);

        ArrayList<SongDetails> testList = new ArrayList<>();

        SongDetailsService.selectAll(testList, database);

        for (SongDetails c: testList) {
            System.out.println(c);
        }

        ArrayList<ArtistDetails> testList1 = new ArrayList<>();

        ArtistDetailsService.selectAll(testList1, database);

        for (ArtistDetails c: testList1) {
            System.out.println(c);
        }
        ArrayList<AlbumDetails> testList2 = new ArrayList<>();

        AlbumDetailsService.selectAll(testList2, database);

        for (AlbumDetails c: testList2) {
            System.out.println(c);
        }
    }

    public static void doSomething(ActionEvent ae) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Feature coming soon...");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}