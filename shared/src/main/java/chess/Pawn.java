package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn {

    private final ChessBoard board;
    private final ChessPosition myPosition;
    private final ChessGame.TeamColor color;

    public Pawn(ChessBoard board, ChessPosition myPosition, ChessGame.TeamColor color) {
        this.board = board;
        this.myPosition = myPosition;
        this.color = color;
    }

    public Collection<ChessMove> pawnMoves() {
        List<ChessMove> possibleMoves = new ArrayList<>();
        int[] firstMove = {2, 0};
        int[] forwardMove = {1,0};
        int[][] diagonalMoves = {{1,1},{1,-1}};
        int startPosition = 2;
        int promotionTime = 7;
        if (color.equals(ChessGame.TeamColor.BLACK)){
            firstMove = new int[]{-2, 0};
            forwardMove = new int[]{-1, 0};
            diagonalMoves = new int[][]{{-1, 1}, {-1, -1}};
            startPosition = 7;
            promotionTime = 2;
        }
        ChessPiece.PieceType[] promotions = {
                ChessPiece.PieceType.QUEEN,
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.ROOK
        };
        if (myPosition.getRow() == startPosition){
            ChessPosition moveFirst = myPosition.addMove(firstMove);
            ChessPosition moveForward = myPosition.addMove(forwardMove);
            if (board.emptySpace(moveFirst) && board.emptySpace(moveForward)){
                possibleMoves.add(new ChessMove(myPosition, moveFirst, null));
            }
        }
        ChessPosition moveForward = myPosition.addMove(forwardMove);
        if (board.emptySpace(moveForward)){
            if (myPosition.getRow() == promotionTime){
                for (ChessPiece.PieceType promotion : promotions){
                    possibleMoves.add(new ChessMove(myPosition, moveForward, promotion));
                }
            } else {possibleMoves.add(new ChessMove(myPosition, moveForward, null));}
        }
        for (int[] diagonalMove : diagonalMoves) {
            ChessPosition moveDiagonal = myPosition.addMove(diagonalMove);
            if (board.availablePosition(moveDiagonal, color)) {
                if (myPosition.getRow() == promotionTime){
                    for (ChessPiece.PieceType promotion : promotions){
                        possibleMoves.add(new ChessMove(myPosition, moveDiagonal, promotion));
                    }
                } else {possibleMoves.add(new ChessMove(myPosition, moveDiagonal, null));}
            }
        }
        return possibleMoves;
    }
}
