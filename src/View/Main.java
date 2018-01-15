package View;

import Controller.MainController;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static Image imgplay;
    public static Image imgpause;
    public static ImageView imgViewPlayPause;

    public static Slider volumeSlider;

    public static VBox root;

    public static HBox generateControls() {

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

        Image imgback = new Image("Images/backarrow.jpg");
        ImageView imgView = new ImageView(imgback);
        imgView.setFitHeight(30);
        imgView.setFitWidth(30);

        imgView.setOnMouseClicked((x) -> MainController.backbutton());
        centreSection.getChildren().add(imgView);

        imgplay = new Image("Images/playbutton.jpg");
        imgpause = new Image ("Images/pausebutton.jpg");
        imgViewPlayPause = new ImageView(imgplay);
        imgViewPlayPause.setFitHeight(30);
        imgViewPlayPause.setFitWidth(30);

        imgViewPlayPause.setOnMouseClicked((x) -> MainController.playbutton());
        centreSection.getChildren().add(imgViewPlayPause);

        Image imgforward = new Image("Images/forwardarrow.jpg");
        ImageView imgView3 = new ImageView(imgforward);
        imgView3.setFitHeight(30);
        imgView3.setFitWidth(30);

        imgView3.setOnMouseClicked((x) -> MainController.nextbutton());
        centreSection.getChildren().add(imgView3);


        /*Button backButton = new Button("Previous");
        centreSection.getChildren().add(backButton);

        Button playButton = new Button("Play");
        centreSection.getChildren().add(playButton);

        Button forwardButton = new Button("Next");
        centreSection.getChildren().add(forwardButton);*/

        volumeSlider = new Slider();
        volumeSlider.setMin(0);
        volumeSlider.setMax(100);
        volumeSlider.setValue(75);

        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                MainController.setVolume(Double.parseDouble(new_val.toString()));
            }
        });

        HBox rightSection = new HBox(20);

        HBox.setHgrow(rightSection, Priority.ALWAYS);
        rightSection.setAlignment(Pos.CENTER_RIGHT);


        /*ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefSize(400, 30);
        progressBar.setProgress(0.5);

        volumeSlider.valueProperty().addListener(
                (observable, old_value, new_value) -> progressBar.setProgress(new_value.doubleValue() / 100));*/

        rightSection.getChildren().addAll(volumeSlider/*, progressBar*/);

        /*Button bottomButton3 = new Button("I am on the right.");
        rightSection.getChildren().add(bottomButton3);*/
        leftAndRightBox.getChildren().add(rightSection);

        return leftAndRightBox;

    }



    public static HBox generateButtons() {
        HBox boxOfButtons = new HBox(1); //Create a horizontal box for all the UI Buttons

        Button[] myButtons = new Button[3];



        myButtons[0] = new Button("Home");
        myButtons[0].setPrefSize(200, 50);
        myButtons[0].setOnAction((ActionEvent ae) -> Main.goHome());

        myButtons[1] = new Button("Playlist");
        myButtons[1].setPrefSize(200, 50);
        myButtons[1].setOnAction((ActionEvent ae) -> MainController.playlist());

        myButtons[2] = new Button("Settings");
        myButtons[2].setPrefSize(200, 50);
        myButtons[2].setOnAction((ActionEvent ae) -> MainController.settings());
        boxOfButtons.getChildren().addAll(myButtons);

        return boxOfButtons;
    }

    public static void goHome() {

        Main.root.getChildren().clear();
        Main.root.getChildren().addAll(Main.generateButtons(), Home.generateScene(), Main.generateControls());
    }

    @Override
    public void start(Stage stage) throws Exception {

        root = new VBox();

        Scene scene = new Scene(root, 450, 768); //Creates the scene with correct aspect ratio

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();

        goHome();

    }

    public static void main(String[] args) {

        MainController.init();
        MainController.databaseTest();

        launch(args);

    }
}