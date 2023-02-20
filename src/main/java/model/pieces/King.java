package model.pieces;

import model.*;
import tad.ListCoor;

public abstract class King extends Piece {
    private ListCoor coordinates;



    public King(Piece.Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public ListCoor getNextMovements() {
        coordinates = new ListCoor();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;



        //Faltan movimientos



        //Up
        c = position.up();
        check(c);

        //Down
        c = position.down();
        check(c);

        //Right
        c = position.right();
        check(c);
        //Left
        c = position.left();
        check(c);
        return coordinates;
    }

    public void check(Coordinate c){
        Board board = getCell().getBoard();

        if(board.getCell(c) != null){
            if(board.getCell(c).isEmpty() ||
                    board.getCell(c).getPiece().getColor() != getColor())
                coordinates.add(c);
        }


    }

}