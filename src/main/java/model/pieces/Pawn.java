package model.pieces;

import model.*;
import tad.ListCoor;

public abstract class Pawn extends Piece {
    private ListCoor coordinates;



    public Pawn(Piece.Type type, Cell cell) {
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
