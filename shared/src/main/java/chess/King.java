package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class King {

    private final ChessBoard board;
    private final ChessPosition myPosition;
    private final ChessGame.TeamColor color;

    public King(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor color) {
        this.board = board;
        this.myPosition = myPosition;
        this.color = color;
    }

    public Collection<ChessMove> kingMoves() {
        List<ChessMove> possibleMoves = new ArrayList<>();
        int[][] moves = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
        for (int[] move : moves){
            ChessPosition moveTo = myPosition.addMove(move);
            if(board.availablePosition(moveTo, color)){
                possibleMoves.add(new ChessMove(myPosition, moveTo, null));
            }
        }
        return possibleMoves;
    }
}
