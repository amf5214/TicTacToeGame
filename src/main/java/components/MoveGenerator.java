package components;

import exceptions.InvalidBoardSpace;

import java.util.Objects;

public class MoveGenerator {

    private final int[][] patterns = new int[][]{{0,1,2},{0,2,1},{1,2,0}, // Horizontal 1st Row
                                            {3,4,5},{3,5,4},{4,5,3}, // Horizontal 2nd Row
                                            {6,7,8},{6,8,7},{7,8,6}, // Horizontal 3rd Row
                                            {0,3,6},{0,6,3},{3,6,0}, // Vertical 1st Column
                                            {1,4,7},{1,7,4},{4,7,1}, // Vertical 2nd Column
                                            {2,5,8},{2,8,5},{5,8,2}, // Vertical 3rd Column
                                            {0,4,8},{0,8,4},{4,8,0}, // Diagonal from top left
                                            {2,4,6},{2,6,4},{4,6,2} // Diagonal from top right
                                            };


    public int getSpace(Board board) {
        for(int[] i : patterns) {
            if ((!Objects.isNull(board.getGameBoard()[i[0]])) && (!Objects.isNull(board.getGameBoard()[i[0]])) && (board.getGameBoard()[i[0]] == board.getGameBoard()[i[1]])) {
                if (Objects.isNull(board.getGameBoard()[i[2]])) {
                    System.out.println("Pattern: " + i[0] + "-" + i[1]);
                    System.out.println(i[2]);
                    return i[2];
                }
            }
        }
        for(int i = 0; i < board.getGameBoard().length; i++) {
            if(board.getGameBoard()[i] == null) {
                return i;
            }
        }
          return -1;
    }
}
