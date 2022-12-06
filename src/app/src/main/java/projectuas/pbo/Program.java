package projectuas.pbo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import java.util.Arrays;

public class Program implements Initializable, Interface {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Text text;

    @FXML
    private Text scoreX;

    @FXML
    private Text scoreO;

    @FXML
    private Text turn;

    Stage stage;

    private int playerTurn = 0;
    private int xCount = 0;
    private int oCount = 0;

    ArrayList<Button> buttons;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttons = new ArrayList<>(
                Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }

    @Override
    public void setPlayerSymbol(Button btn) {
        if (playerTurn % 2 == 0) {
            // text X
            turn.setText("PLAYER O");
            btn.setText("X");
            playerTurn = 1;
        } else {
            // text O
            turn.setText("PLAYER X");
            btn.setText("O");
            playerTurn = 0;
        }
    }

    @FXML
    public void restartGame(ActionEvent evt) {
        buttons.forEach(this::resetButton);
        text.setText("Tic-Tac-Toe");
        playerTurn = 0;
        turn.setText("PLAYER X");
    }

    @Override
    public void resetButton(Button btn) {
        btn.setDisable(false);
        btn.setText("");
    }

    private void setupButton(Button btn) {
        btn.setOnMouseClicked(MouseEvent -> {
            setPlayerSymbol(btn);
            btn.setDisable(true);
            checkIfGameIsOver(btn);
        });
    }

    @Override
    public void checkIfGameIsOver(Button btn) {
        for (int i = 0; i < 8; i++) {
            String line = switch (i) {
                case 0 -> button1.getText() + button2.getText() + button3.getText(); //horizontal
                case 1 -> button4.getText() + button5.getText() + button6.getText(); //horizontal
                case 2 -> button7.getText() + button8.getText() + button9.getText(); //horizontal
                case 3 -> button1.getText() + button5.getText() + button9.getText(); //diagonal
                case 4 -> button3.getText() + button5.getText() + button7.getText(); //diagonal
                case 5 -> button1.getText() + button4.getText() + button7.getText(); //vertikal
                case 6 -> button2.getText() + button5.getText() + button8.getText(); //vertikal
                case 7 -> button3.getText() + button6.getText() + button9.getText(); //vertikal
                default -> null;
            };

            // X Winner
            if (line.equals("XXX")) {
                text.setText("X won!");

                // Hitung Skor
                xCount++;
                scoreX.setText(String.valueOf(xCount));

                // Error handling, biar klo ada yang udah menang, ga di cek lagi
                i = 8;

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("NOTIFICATION");
                alert.setHeaderText("PLAYER X WIN !");

                // Untuk keluar Program
                if (alert.showAndWait().get() == ButtonType.OK) {
                    buttons.forEach(this::resetButton);
                    playerTurn = 0;
                    text.setText("Tic-Tac-Toe");
                    turn.setText("PLAYER X");
                } else {
                    buttons.forEach(this::resetButton);
                }
            }
            // O Winner
            else if (line.equals("OOO")) {
                text.setText("O won!");

                // Hitung Skor
                oCount++;
                scoreO.setText(String.valueOf(oCount));

                // Error handling, biar klo ada yang udah menang, ga di cek lagi
                i = 8;

                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("NOTIFICATION");
                alert.setHeaderText("PLAYER O WIN !");

                // Untuk keluar Program
                if (alert.showAndWait().get() == ButtonType.OK) {
                    buttons.forEach(this::resetButton);
                    playerTurn = 0;
                    text.setText("Tic-Tac-Toe");
                    turn.setText("PLAYER X");
                } else {
                    buttons.forEach(this::resetButton);
                }
            }
        }

        //seri
        String line1 = button1.getText() + button2.getText() + button3.getText(); //horizontal
        String line2 = button4.getText() + button5.getText() + button6.getText(); //horizontal
        String line3 = button7.getText() + button8.getText() + button9.getText(); //horizontal
            
        // Tie
        if (line1.equals("XOX")){
            if (line2.equals("XOO")){
                if (line3.equals("OXX")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
            }
            if (line3.equals("OXO")){
                if (line2.equals("OXX")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
                if  (line2.equals("XXO")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
            }
            if (line3.equals("XXO")){
                if (line2.equals("OOX")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
            }
        }
        if (line3.equals("XOX")){
            if (line2.equals("OOX")){
                if (line1.equals("XXO")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
            }
            if (line2.equals("XOO")){
                if (line1.equals("OXX")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
            }
            if (line1.equals("OXO")){
                if (line2.equals("OXX")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
                if (line2.equals("XXO")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
                if (line2.equals("XOX")) {
                    text.setText("It's a Tie!");

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("NOTIFICATION");
                    alert.setHeaderText("IT'S A TIE!");

                    // Untuk keluar Program
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        buttons.forEach(this::resetButton);
                        playerTurn = 0;
                        text.setText("Tic-Tac-Toe");
                        turn.setText("PLAYER X");
                    } 
                    else {
                        buttons.forEach(this::resetButton);   
                    }
                }
            }

        }
    }
    

    @Override
    public void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
    }

    //Exit
    @Override
    public void exitApp(ActionEvent evt) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit!");

        // Untuk keluar Program
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) anchorPane.getScene().getWindow();
            delay();
            stage.close();
        }
    }
}