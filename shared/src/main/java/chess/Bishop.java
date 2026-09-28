package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Bishop {

    private final ChessBoard board;
    private final ChessPosition myPosition;
    private final ChessGame.TeamColor color;

    public Bishop(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor color) {
        this.board = board;
        this.myPosition = myPosition;
        this.color = color;
    }

    public Collection<ChessMove> bishopMoves() {
        List<ChessMove> possibleMoves = new ArrayList<>();
        int[][] moves = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] move : moves){
            ChessPosition current = myPosition;
            for (int i = 0; i <= 8; i++){
                ChessPosition moveTo = current.addMove(move);
                if(board.availablePosition(moveTo, color)) {
                    possibleMoves.add(new ChessMove(myPosition, moveTo, null));
                } else {break;}
                if(board.enemyPosition(moveTo, color)){break;}
                current = moveTo;
            }
        }
        return possibleMoves;
    }
}
