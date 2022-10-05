package components;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Board gameBoard;
    private Scanner scanner;
    private WinLoseEndChecker checker;
    private String outputStr;
    private boolean continueRunning;
    MoveGenerator mover;

    public Game() {
        this.player1 = null;
        this.player2 = null;
        this.gameBoard = null;
        this.scanner = null;
        this.outputStr = null;
        this.continueRunning = true;
        checker = new WinLoseEndChecker();
        mover = new MoveGenerator();
    }

    public int run() {
        this.scanner = new Scanner(System.in);
        this.gameBoard = new Board();
        getPlayers();
        System.out.println("Player 1: " + player1.getPlayerPiece());
        System.out.println("Player 2: " + player2.getPlayerPiece());

        int space = 91;
        while(this.continueRunning) {
            gameBoard.printBoard();
            System.out.println("Alright, It is " + player1.getPlayerPiece() + "'s turn");
            while(!gameBoard.addPiece(player1, space)) {
                space = getSpace();
            }
            this.outputStr = checker.runCheck(player1, gameBoard);
            if(!outputStr.equals(WinLoseEndChecker.noEndStr)) {
                this.continueRunning = false;
                break;
            } else {
                space = 91;
                gameBoard.printBoard();
                System.out.println("Alright, It is " + player2.getPlayerPiece() + "'s turn");
                while(!gameBoard.addPiece(player2, space)) {
                    if(player2.isAI()) {
                        space = mover.getSpace(gameBoard);
                        if(space == -1) {
                            return -1;
                        }
                    } else {
                        space = getSpace();
                    }
                }
                this.outputStr = checker.runCheck(player2, gameBoard);
                if(!outputStr.equals(WinLoseEndChecker.noEndStr)) {
                    this.continueRunning = false;
                    break;
                }
            }
        }
        gameBoard.printBoard();
        System.out.println(outputStr);

        int rtnInt = -1;
        while(rtnInt != 1 && rtnInt != 0) {
            try {
                System.out.println("Would you like to continue play again? (1)Yes or (0)No");
                rtnInt = scanner.nextInt();
            } catch(InputMismatchException ignored) {
                rtnInt = -1;
                scanner = new Scanner(System.in);
            }
        }
        return rtnInt;
    }

    public void getPlayers() {
        boolean isAI;
        System.out.println("Would you like to be X or O?");
        String piece = scanner.nextLine();
        String piece2;
        while(!piece.equals(Piece.oPiece) && !piece.equals(Piece.xPiece)) {
            System.out.println("Would you like to be X or O?");
            piece = scanner.nextLine();
        }

        System.out.println("Would you like to play with an AI? Yes or No");
        String decision = scanner.nextLine();
        while((!decision.equals("Yes")) && (!decision.equals("No"))) {
            System.out.println("Would you like to play with an AI? Yes or No");
            decision = scanner.nextLine();
        }
        isAI = decision.equals("Yes");
        piece2 = piece.equals(Piece.xPiece) ? Piece.oPiece : Piece.xPiece;
        this.player1 = new Player(piece, false);
        this.player2 = new Player(piece2, isAI);
    }

    public int getSpace() {
        System.out.println("Where would you like to place your piece? ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch(NumberFormatException e) {
            return 91;
        }

    }

}
