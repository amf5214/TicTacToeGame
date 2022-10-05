package components;

import exceptions.InvalidBoardSpace;

public class Board {

    private Player[] gameBoard;

    public Board() {
        this.gameBoard = new Player[]{null, null, null, null, null, null, null, null, null};
    }

    public Player[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Player[] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String getGamePiece(int index) throws InvalidBoardSpace {
        if(index >=0 && index < 9) {
            if(getGameBoard()[index] == null) {
                return "" + index;
            }
            return getGameBoard()[index].getPlayerPiece();
        } else {
            throw new InvalidBoardSpace("Error: The given space is not valid!");
        }
    }

    public void printBoard() {
        try {
            System.out.println("____________________________________________________");
            System.out.println("|---|---|---|");
            System.out.println("| " + getGamePiece(0) + " | " + getGamePiece(1) + " | " + getGamePiece(2) + " |");
            System.out.println("| " + getGamePiece(3) + " | " + getGamePiece(4) + " | " + getGamePiece(5) + " |");
            System.out.println("| " + getGamePiece(6) + " | " + getGamePiece(7) + " | " + getGamePiece(8) + " |");
            System.out.println("|---|---|---|");
        } catch(InvalidBoardSpace e) {
            System.out.println(e);
        }
    }

    public boolean addPiece(Player current, int space) {
        if(space >= 0 && space < 9) {
            if (gameBoard[space] == null) {
                gameBoard[space] = current;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
