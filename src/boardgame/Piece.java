package boardgame;

public abstract class Piece { 
    
    protected Position position; //Only visible in board layer 
    private Board board;

    public Piece(Board board) {
        this.board = board; //Informing a board when creating a piece
        position = null; 
        //The position of a newly created piece will initially be null meaning that it's not placed on the board yet
    }
    
    protected Board getBoard() {
    //The board must be used only within the board layer, and not the chess layer
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) { //HookMethod
        //Checks if the piece can move to the given position
        return possibleMoves()[position.getRow()][position.getColumn()]; 
    }

    public boolean isThereAnyPossibleMove() {
        //Checks if there is at least one possible movement for the piece
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
