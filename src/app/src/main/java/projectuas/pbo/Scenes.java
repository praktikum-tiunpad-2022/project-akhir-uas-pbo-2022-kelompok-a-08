package projectuas.pbo;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class Scenes {
    private final int WINDOW_WIDTH=640;
    private final int WINDOW_HEIGHT=480;
    private Stage stage;
    private Board board;

    Scenes(Stage stage) {
        this.board=new Board();
        this.stage=stage;
    }

    public void mainMenu() {
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(16));
        root.setHgap(16);
        root.setVgap(8);

        GridPane header=new GridPane();
        Label title=new Label("TIC-TAC-TOE");
        title.setFont(new Font("Source Sans Pro", 24));
        Label oleh=new Label("Aliya-Fel-Dinda");
        oleh.setFont(new Font("Source Sans Po", 18));
        header.addRow(1, title);
        header.addRow(2, oleh);

        GridPane main=new GridPane();
        int mainButtonWidth=100;
        int mainButtonHeight=30;
        Button play=new Button("Play");
        play.setPrefSize(mainButtonWidth, mainButtonHeight);
        Button exit=new Button("Exit");
        exit.setPrefSize(mainButtonWidth, mainButtonHeight);
        play.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                game();
            }
        });
        play.setOnKeyPressed(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                game();
            }
        });

        exit.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.exit(0);
            }
        });
        exit.setOnKeyPressed(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                System.exit(0);
            }
        });
        main.addRow(1, play);
        main.addRow(2, exit);

        root.addRow(1, header);
        root.addRow(2, main);

        Scene scn=new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.stage.setScene(scn);
        this.stage.show();
    }

    public void game() {
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(16));
        root.setHgap(16);
        root.setVgap(8);

        GridPane main=new GridPane();
        GridPane tttBoard=this.board.create(this.stage);

        GridPane playerSymbols=new GridPane();
        Label player1Symbol=new Label("Player 1: X");
        Label player2Symbol=new Label("Player 2: O");
        int symbolFontSize=16;

        player1Symbol.setFont(new Font(symbolFontSize));
        player2Symbol.setFont(new Font(symbolFontSize));


        playerSymbols.addRow(1, player1Symbol);
        playerSymbols.addRow(2, player2Symbol);

        main.addColumn(1, tttBoard);
        main.addColumn(2, playerSymbols);

        root.addRow(1, main);

        Scene scn=new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scn);
        stage.show();
    }

    public void winningMenu() {
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(16));
        root.setHgap(16);
        root.setVgap(8);

        GridPane main=new GridPane();
        GridPane winnerPanel=new GridPane();
        
        if(board.getWinner() == "None") {
            Label tieLabel=new Label("It is a tie");
            winnerPanel.addRow(1, tieLabel);
        } else {
            Label winnerLabel=new Label("Winner of the game");
            System.out.println(this.board.getWinner());
            Label winner=new Label(this.board.getWinner());

            winnerPanel.addRow(1, winnerLabel);
            winnerPanel.addRow(2, winner);
        }
        Button backToMainMenu=new Button("Back to Main Menu");
        backToMainMenu.setOnMouseClicked(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                mainMenu();
            }
        });
        backToMainMenu.setOnKeyPressed(new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                mainMenu();
            }
        });

        main.addRow(1, winnerPanel);
        main.addRow(2, backToMainMenu);

        root.addRow(1, main);

        Scene scn=new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scn);
        stage.show();
    }
}