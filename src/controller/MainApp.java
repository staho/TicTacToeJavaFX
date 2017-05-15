package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by staho on 13.05.2017.
 */
public class MainApp extends Application{
    private Stage primaryStage;
    private BorderPane rootLayout;


    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Stas staś Toe - ");
        initRootLayout();
        initTictactoeLayout();


    }

    private void initRootLayout(){
        try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("../view/rootLayout.fxml"));

        rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e){
            e.printStackTrace();
        }

    }
    private void initTictactoeLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/tictactoeLayout.fxml"));

            AnchorPane anchorPane = loader.load();
            rootLayout.setCenter(anchorPane);
            //primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    public static void main(String[]args){
        launch(args);
    }

}
