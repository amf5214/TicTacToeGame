package components;

import exceptions.InvalidBoardSpace;

public class WinLoseEndChecker {

    private static final int[][] patterns = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    private static final String playerWinStr = "Player %s has won the game! Game Over!";
    private static final String drawStr = "The game has come to a draw";
    public static final String noEndStr = "false";

    private Player player;
    private Board board;

    public String runCheck(Player player, Board board) {
        this.player = player;
        this.board = board;
        if(checkPlayerWin()) {
            return playerWinStr.formatted(player.getPlayerPiece());
        }
        if(checkDraw()) {
            return drawStr;
        }
        return noEndStr;
    }

    public boolean checkPlayerWin() {
        String piece = player.getPlayerPiece();
        try {
            for (int[] i : patterns) {
                if (board.getGamePiece(i[0]).equals(piece) && board.getGamePiece(i[1]).equals(piece) && board.getGamePiece(i[2]).equals(piece)) {
                    return true;
                }
            }
            return false;
        } catch(InvalidBoardSpace e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkDraw() {
        int pieceCount = 0;
        Player[] playerBoard = board.getGameBoard();
        for (Player value : playerBoard) {
            if (value != null) {
                pieceCount += 1;
            }
        }
        return pieceCount >= 9;
    }
}
