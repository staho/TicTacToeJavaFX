package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Created by staho on 13.05.2017.
 */
public class ticTacToeController {

    private Image imageX;
    private Image imageO;
    private int turnCounter = 0;

    private boolean turn = true;
    private boolean sign = false; //X - true, O - false

    @FXML
    private GridPane gridPane;
    @FXML
    private Label turnLabel;
    @FXML
    private Label signLabel;
    @FXML
    private Label opierdoluLabel;
    @FXML
    private ImageView im1;
    @FXML
    private ImageView im2;
    @FXML
    private ImageView im3;
    @FXML
    private ImageView im4;
    @FXML
    private ImageView im5;
    @FXML
    private ImageView im6;
    @FXML
    private ImageView im7;
    @FXML
    private ImageView im8;
    @FXML
    private ImageView im9;


    @FXML
    public void handleImageClicked(MouseEvent event){
        ImageView img = (ImageView) event.getSource();
        Image temp = img.getImage();
            if(turn){
                if(temp == null){
                    if(sign) img.setImage(imageX);
                    else img.setImage(imageO);

                    endTurn();
                }
            } else {
                opierdoluLabel.setText("CZEKOJ ŻE!");
            }


    }

    public void initialize(){
        imageO = new Image(ticTacToeController.class.getResource("../assets/O.png").toString());
        imageX = new Image(ticTacToeController.class.getResource("../assets/X.png").toString());
        if(sign) signLabel.setText("Twój stah to: chudy");
        else signLabel.setText("Twój stah to: gruby");
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isSign() {
        return sign;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }
    public void endTurn(){
        turnLabel.setText("It's opponent turn!");
        ++turnCounter;
        if(turnCounter >= 5){
            int winner = checkForWinner();
            if(winner >= 0){
                endGame(winner);
            }
        }
        //turn = false;
    }
    public void startTurn(){
        turnLabel.setText("It's your turn!");
       // turn = true;
    }
    public void endGame(int winner){
        String win = "And the winner is: ";
        if(winner == 0) win += "gruby staho";
        else win += "chudy staho";
        turnLabel.setText(win);
    }

    //-1 - no winner
    //0 - O is a winner
    //1 - X is a winner
    public int checkForWinner(){
        //first horizontal
        int winner = checkRow(im1, im2, im3);

        //second horizontal
        if(winner < 0){
            winner = checkRow(im4, im5, im6);
        }

        //third horizontal
        if(winner < 0){
            winner = checkRow(im7, im8, im9);
        }

        //first vertical
        if(winner < 0){
            winner = checkRow(im1, im4, im7);
        }

        //second vertical
        if(winner < 0){
            winner = checkRow(im2, im5, im8);
        }

        //third vertical
        if(winner < 0){
            winner = checkRow(im3, im6, im9);
        }

        //first diagonal
        if(winner < 0){
            winner = checkRow(im1, im5, im9);
        }

        //second diagonal
        if(winner < 0){
            winner = checkRow(im3, im5, im7);
        }
        return winner;

    }
    private int checkRow(ImageView a, ImageView b, ImageView c){
        if(a!=null && (a.getImage() == b.getImage()) && c!=null && (b.getImage() == c.getImage())){
            if(a.getImage() == imageO) return 0;
            else if(a.getImage() == imageX) return 1;
        } else {
            return -1;
        }
        return -1;
    }
}
