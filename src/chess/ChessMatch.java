package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //Class responsible for all the game rules

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8); //ChessMatch is responsible for setting the dimensions of the board 
        initialSetup();
    }

    public ChessPiece[][] getPieces() { 
        /*This method must return the pieces of type ChessPiece[][]. The program must have access to the ChessPiece pieces only, and 
        not the pieces of type Piece, respecting the system layers. It must only be able to see the chess layer, and not the boardgame*/
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; 
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j); //Downcasting from type Piece to ChessPiece
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());

    }

    private void initialSetup() {
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
    }
}
