package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    ChessPiece[][] Board = new ChessPiece[8][8];

    public ChessBoard() {
        
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(Board, that.Board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(Board);
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        int row = position.getRow() -1;
        int col = position.getRow() -1;
        Board[row][col] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        int row = position.getRow() -1;
        int col = position.getRow() -1;
        return Board[row][col];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        Board = new ChessPiece[8][8];
        Board[0] = new ChessPiece[]{new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK)
        };
        Board[1] = new ChessPiece[]{new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN)
        };
        Board[6] = new ChessPiece[]{new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN)
        };
        Board[7] = new ChessPiece[]{new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT),
                new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK)
        };
    }

    public boolean emptySpace(ChessPosition position){
        int row = position.getRow() -1;
        int col = position.getRow() -1;
        if (row > 7 | row < 0 | col > 7 | col < 0) {return false;}
        if (Board[row][col] == null) {return true;}
        return false;
    }

    public boolean enemyPosition(ChessPosition position, ChessGame.TeamColor color){
        int row = position.getRow() -1;
        int col = position.getRow() -1;
        if (row > 7 | row < 0 | col > 7 | col < 0) {return false;}
        if (Board[row][col] == null) {return false;}
        if (Board[row][col].getTeamColor().equals(color)) {return false;}
        return true;
    }

    public boolean availablePosition(ChessPosition position, ChessGame.TeamColor color){
        int row = position.getRow() -1;
        int col = position.getRow() -1;
        if (row > 7 | row < 0 | col > 7 | col < 0) {return false;}
        if (Board[row][col] == null) {return true;}
        if (Board[row][col].getTeamColor().equals(color)) {return false;}
        return true;
    }
}
