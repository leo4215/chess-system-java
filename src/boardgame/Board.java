package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;
    
    public Board(int rows, int columns) { //Rows and columns responsible for setting the board size
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns]; //Instantiates the board pieces matrix given the entered rows and columns number
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) { //Returns a piece by receiving the row and column numbers as a parameter
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position) { //Overloading: returns a piece by receiving a type Position as a parameter
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) { //Assigning the piece to the given matrix position
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces [position.getRow()][position.getColumn()] = piece; 
        piece.position = position;
    }

    public Piece removePiece(Position position) { //Checks if position exists and removes a piece
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }

    public boolean positionExists(int row, int column) { //Checking if a position exists by receiving the row and column numbers as a parameter
        return row >= 0 && row < rows && column >= 0 && column < columns; 
    }

    public boolean positionExists(Position position) {  //Overloading: checking if a position exists by receiving a type Position as a parameter
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) { //Checking if there is a piece on a position
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }
}
