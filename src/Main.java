import Controller.MainController;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 450, 768); //Creates the scene with correct aspect ratio

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();

        HBox boxOfButtons = new HBox(1); //Create a horizontal box for all the UI Buttons

        Button[] myButtons = new Button[5];

        myButtons[0] = new Button("Search"); //Name inside Button
        myButtons[0].setPrefSize(200, 50);
        myButtons[0].setOnAction((ActionEvent ae) -> MainController.doSomething(ae)); //"doSomething  is a place filler

        myButtons[1] = new Button("Search");
        myButtons[1].setPrefSize(200, 50);
        myButtons[1].setOnAction((ActionEvent ae) -> MainController.doSomething(ae));

        myButtons[2] = new Button("Home");
        myButtons[2].setPrefSize(200, 50);
        myButtons[2].setOnAction((ActionEvent ae) -> MainController.doSomething(ae));

        myButtons[3] = new Button("Playlist");
        myButtons[3].setPrefSize(200, 50);
        myButtons[3].setOnAction((ActionEvent ae) -> MainController.doSomething(ae));

        myButtons[4] = new Button("Settings");
        myButtons[4].setPrefSize(200, 50);
        myButtons[4].setOnAction((ActionEvent ae) -> MainController.doSomething(ae));
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

        TableColumn artistColumn = new TableColumn<>("First Name");
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        table.getColumns().add(artistColumn);

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

        HBox centreSection = new HBox(30);
        HBox.setHgrow(centreSection, Priority.ALWAYS);
        centreSection.setAlignment(Pos.CENTER);
        leftAndRightBox.getChildren().add(centreSection);
        root.setBottom(leftAndRightBox);

        ImageView img = new ImageView("C://Users//62015//IdeaProjects//MusicPlayerCoursework1//src//Images//backarrow.jpg");

        img.setOnMouseClicked((MouseEvent e) -> {
            System.out.println("Clicked!"); // change functionality
        })

        Button backButton = new Button("Previous");
        centreSection.getChildren().add(backButton);

        Button playButton = new Button("Play");
        centreSection.getChildren().add(playButton);

        Button forwardButton = new Button("Next");
        centreSection.getChildren().add(forwardButton);

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

        TableView<SongView> songTable = new TableView<>();

        TableColumn nameColumn = new TableColumn<>("Song");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.33));
        songTable.getColumns().add(nameColumn);

        TableColumn artistColumn = new TableColumn<>("Artist");
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        artistColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.333));
        songTable.getColumns().add(artistColumn);

        TableColumn albumColumn = new TableColumn<>("Album");
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("album"));
        albumColumn.prefWidthProperty().bind(songTable.widthProperty().multiply(0.33));
        songTable.getColumns().add(albumColumn);

        songTable.setItems(MainController.getSongsForTable());

        root.setCenter(songTable);
    }

    public static void main(String[] args) {

        MainController.init();
        MainController.databaseTest();

        launch(args);

    }
}