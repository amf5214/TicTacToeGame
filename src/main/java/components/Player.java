package components;

public class Player {

    private String playerPiece;
    private boolean isAI;

    public Player(String playerPiece, boolean isAI) {
        this.playerPiece = playerPiece;
        this.isAI = isAI;
    }

    public Player(String playerPiece) {
        this.playerPiece = playerPiece;
    }

    public Player() {
    }

    public String getPlayerPiece() {
        return playerPiece;
    }

    public void setPlayerPiece(String playerPiece) {
        this.playerPiece = playerPiece;
    }

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean AI) {
        isAI = AI;
    }
}
