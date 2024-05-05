package boardgame;

public class Piece { 
    
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


}
