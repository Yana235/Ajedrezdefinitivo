package model;

import com.diogonunes.jcolor.Attribute;

import tad.ListCoor;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {
    protected ListCoor coordinates;
    private Type type;
    protected Cell cell;

    public Piece(Type type, Cell cell) {
        this.cell = cell;
        this.type = type;
    }

    public Cell getCell(){
        return cell;
    }

    public Color getColor() {
        return type.color;
    }
    public Type getType(){return type;}

    public void putInYourPlace(){
        cell.setPiece(this);
    }

    public abstract ListCoor getNextMovements();

    protected void check(Coordinate coordinate, ListCoor coordinates){
        Board board = getCell().getBoard();

        if (board.getCell(coordinate) != null)
            if (board.getCell(coordinate).isEmpty() ||
                    board.getCell(coordinate).getPiece().getColor() != getColor())
                coordinates.add(coordinate);
    }
    /*
    public boolean moveTo(Coordinate c) {
        if (cell == null ||
                !getNextMovements().contains(c))
            return false;
// Si la celda destino tiene ficha la eliminamos de la lista de
// fichas del tablero
        if (c.containsPiece()) {
            c.getPiece().removePiece();
        }
// movemos la ficha eliminandola de su antigua posicion
// y colocandola en la nueva
        cell.setPiece(null);
        cell = c;
        placePiece();
        return true;
    }

     */

    public void moveTo(Coordinate c){
        Board board = getCell().getBoard();
        //Check whether cell exists
        if(board.getCell(c) != null) {
            getCell().setPiece(null);
            Cell cell = board.getCell(c);
            cell.setPiece(this);
            this.cell = cell;
        }
    }




    @Override
    public String toString(){
        return colorize(type.toString(),type.color.getPieceColor(),cell.getColor().getAttribute());
    }

    public enum Color{
        WHITE(Attribute.TEXT_COLOR(255)),
        BLACK(Attribute.TEXT_COLOR(16));
        private final Attribute pieceColor;
        private Color(Attribute pieceColor){
            this.pieceColor = pieceColor;
        }
        public Attribute getPieceColor() { return pieceColor;}
        public Color next(){
            if(this.equals(WHITE))
                return BLACK;
            return WHITE;
        }
    }

    public enum Type{
        WHITE_KING("\u265A", Color.WHITE),
        BLACK_KING("\u265A", Color.BLACK),
        WHITE_QUEEN("\u265B", Color.WHITE),
        BLACK_QUEEN("\u265B", Color.BLACK),
        WHITE_ROOK("\u265C", Color.WHITE),
        BLACK_ROOK("\u265C", Color.BLACK),
        WHITE_BISHOP("\u265D", Color.WHITE),
        BLACK_BISHOP("\u265D", Color.BLACK),
        WHITE_KNIGHT("\u265E", Color.WHITE),
        BLACK_KNIGHT("\u265E", Color.BLACK),
        WHITE_PAWN("\u2659", Color.WHITE),
        BLACK_PAWN("\u2659", Color.BLACK);
        private String shape;
        private Color color;
        private Type(String shape, Color color) {
            this.color = color;
            this.shape = shape;
        }
        public Color getColor() {
            return color;
        }
        public String getShape() {
            return shape;
        }

        @Override
        public String toString() {
            return String.valueOf(shape);
        }

    }


}
