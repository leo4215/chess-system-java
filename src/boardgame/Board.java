package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;
    
    public Board(int rows, int columns) { //Rows and columns responsible for setting the board size
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; //Instantiates the board pieces matrix given the entered rows and columns number
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column) { //Returns a piece by receiving the row and column numbers as a parameter
        return pieces[row][column];
    }

    public Piece piece(Position position) { //Overloading: returns a piece by receiving a type Position as a parameter
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) { //Assigning the piece to the given matrix position
        pieces [position.getRow()][position.getColumn()] = piece; 
        piece.position = position;
    }
}
