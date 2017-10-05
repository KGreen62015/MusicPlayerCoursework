import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

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

        HBox mid = new HBox(0);
        mid.setPadding(new Insets(20));
        root.setCenter(mid);
        ListView<String> list = new ListView<>();
        HBox.setHgrow(list, Priority.ALWAYS);
        mid.getChildren().add(list);



        HBox leftAndRightBox = new HBox(2);
        leftAndRightBox.setAlignment(Pos.CENTER_LEFT);

        VBox details = new VBox();
        Label songlabel = new Label("a label");
        details.getChildren().add(songlabel);
        leftAndRightBox.getChildren().add(details);

        Button bottomButton1 = new Button("I am on the left.");
        leftAndRightBox.getChildren().add(bottomButton1);

        Button bottomButton2 = new Button("I am also on the left.");
        leftAndRightBox.getChildren().add(bottomButton2);

        HBox rightSection = new HBox(20);
        HBox.setHgrow(rightSection, Priority.ALWAYS);
        rightSection.setAlignment(Pos.CENTER_RIGHT);

        Button bottomButton3 = new Button("I am on the right.");
        rightSection.getChildren().add(bottomButton3);
        leftAndRightBox.getChildren().add(rightSection);
        root.setBottom(leftAndRightBox);
    }

    public static void doSomething(ActionEvent ae) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Wow, you clicked the button with style!");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}