package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
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

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) { //Removes the piece from the source position and places it on the target position
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target) {  
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target); //Captures a piece on target position if there is any 
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) { //Checks if there is a piece on source position and if there is any possible move
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) { //Places a new piece on the board
        board.placePiece(piece, new ChessPosition(column, row).toPosition());

    }

    private void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
} 
