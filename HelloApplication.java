package com.example.demo1;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//import java.time.Duration;
//import java.util.ArrayList;

//import static java.time.Duration.ofSeconds;

public class HelloApplication extends Application {
    private int index = 0;

    @Override
    public void start(Stage stage) {

        //StackPane pane = new StackPane();
        BorderPane borderPane= new BorderPane();
        BorderPane borderPane2= new BorderPane();

        ImageView imgVIEW = new ImageView();

        Button btk= new Button("Play");
        Image decreaseImg = new Image("C:\\\\Users\\\\denaa\\\\OneDrive\\\\Desktop\\\\javaprojects\\\\pics\\\\decreaseSpeed.png");
        Image increaseImg = new Image("C:\\\\Users\\\\denaa\\\\OneDrive\\\\Desktop\\\\javaprojects\\\\pics\\\\increaseSpeed.png");
        ImageView increaseImgV = new ImageView(increaseImg);
        ImageView decreaseImgV = new ImageView(decreaseImg);

        Button increaseSpeedButton = new Button();
        increaseSpeedButton.setGraphic(increaseImgV);
        Button decreaseSpeedButton = new Button();
        decreaseSpeedButton.setGraphic(decreaseImgV);

        borderPane2.setCenter(btk);
        borderPane2.setRight(increaseSpeedButton);
        borderPane2.setLeft(decreaseSpeedButton);
        Image[] img= new Image[3];
         img[0] = new Image("C:\\\\Users\\\\denaa\\\\OneDrive\\\\Desktop\\\\javaprojects\\\\pics\\\\download.jpg");
         img[1] = new Image("C:\\\\Users\\\\denaa\\\\OneDrive\\\\Desktop\\\\javaprojects\\\\pics\\\\download (1).jpg");
         img[2]= new Image("C:\\\\Users\\\\denaa\\\\OneDrive\\\\Desktop\\\\javaprojects\\\\pics\\\\d.jpg");
         borderPane.setBottom(borderPane2);
        borderPane.setCenter(imgVIEW);

        //ImageView imageView = new ImageView();
        //imageView.setImage(myImages.get(0));

        Timeline animation = new Timeline(new KeyFrame(javafx.util.Duration.seconds(2), event -> {
            index = (index + 1) % img.length;
            imgVIEW.setImage(img[index]);
        }));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        btk.setOnAction(event -> {
            if (animation.getStatus() == Animation.Status.RUNNING) {
                animation.pause();
                btk.setText("Play");
            } else {
                animation.play();
                btk.setText("Pause");
            }
        });
        increaseSpeedButton.setOnAction(event -> {
            animation.setRate(animation.getRate() + 0.1);
        });

        decreaseSpeedButton.setOnAction(event -> {
            animation.setRate(animation.getRate() - 0.1);
        });

        Scene scene = new Scene(borderPane);
        stage.setTitle("Animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

