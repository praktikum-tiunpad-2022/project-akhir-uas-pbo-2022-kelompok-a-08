package projectuas.pbo;

import java.util.Vector;

import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Board {
    private final int SIZE = 3;
    private Image X;
    private Image O;
    private Vector<Tile> tiles;
    private User player1;
    private User player2;
    private User currentUser;
    private String winner;

    Board() {
        this.player1=new User("Player1");
        this.player2=new User("Player2");
        this.X=new Image("symbols/x.png");
        this.O=new Image("symbols/o.png");
        this.currentUser=this.player1;
        this.tiles=new Vector<Tile>();
        this.winner="";
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public void setcurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setTiles(Vector<Tile> tiles) {
        this.tiles = tiles;
    }

    public User getPlayer1() {
        return player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public User getcurrentUser() {
        return currentUser;
    }

    public String getWinner() {
        return winner;
    }

    public Vector<Tile> getTiles() {
        return tiles;
    }

    public GridPane create(Stage stage) {
        GridPane board=new GridPane();
        for(int i=0; i<this.SIZE; i++) {
            for(int j=0; j<this.SIZE; j++) {
                final int index=i+(j*3);
                int tileWidth=100;
                int tileHeight=100;
                Tile tile=new Tile(String.valueOf(index), tileWidth, tileHeight);
                tile.setFill(Color.WHITESMOKE);
                tile.setStroke(Color.BLACK);

                board.add(tile, i, j);
                tile.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(currentUser==player1) {
                            tile.setFill(new ImagePattern(X));
                            tile.setValue("X");
                            player1.setPick(index);
                            setWinner(player1.getTitle());
                            setcurrentUser(player2);
                        } else {
                            tile.setFill(new ImagePattern(O));
                            tile.setValue("O");
                            player2.setPick(index);
                            setWinner(player2.getTitle());
                            setcurrentUser(player1);
                        }
                        tile.setDisable(true);

                        Scenes scene=new Scenes(stage);

                        if(gameIsFinished() == 1) {
                            System.out.println("Winner: " + winner);
                            scene.winningMenu();
                        } else if(gameIsFinished() == -1) {
                            System.out.println("Tie");
                            setWinner("None");
                            scene.winningMenu();
                        }
                    }
                });           
                tiles.add(tile);
            }
        }
        return board;
    }

    public int gameIsFinished() {
        /*
        1 (0) | 2 (1) | 3 (2)
        4 (3) | 5 (4) | 6 (5)
        7 (6) | 8 (7) | 9 (8)
        */
        return (
            lineWinning(0,1,2) ? 1 : lineWinning(3,4,5) ? 1 : lineWinning(6,7,8) ? 1 // Horizontal
            :
            lineWinning(0,3,6) ? 1 : lineWinning(1,4,7) ? 1 : lineWinning(2,5,8) ? 1 // Vertical
            :
            lineWinning(0,4,8) ? 1 : lineWinning(2,4,6) ? 1 // Diagonal
            :
            !allIsPicked() ? -1 // Tie
            :
            0 // Still running
        );
    }

    public boolean lineWinning(int tile1, int tile2, int tile3) {
        return (
            this.tiles.get(tile1).getValue() == this.tiles.get(tile2).getValue()
            &&
            this.tiles.get(tile2).getValue() == this.tiles.get(tile3).getValue()
        );
    }

    public boolean allIsPicked() {
        for(int i=0; i<this.tiles.size(); i++) {
            if(this.tiles.get(i).getValue() == String.valueOf(i)) {
                return false;
            }
        }
        return true;
    }
}