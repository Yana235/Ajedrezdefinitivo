package model.pieces;

import model.*;
import tad.ListCoor;

public abstract class Bishop extends Piece {
    private ListCoor coordinates;

    public Bishop(Type type, Cell cell) {
        super(type,cell);
    }

    @Override
    public ListCoor getNextMovements() {
        coordinates = new ListCoor();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        //DiagonalUpRight
        c = position.diagonalUpRight();
        check(c);


        //DiagonalUpLeft
        c = position.diagonalUpLeft();
        check(c);

        //DiagonalDownRight
        c = position.diagonalDownRight();
        check(c);

        //DiagonalDownLeft
        c = position.diagonalDownLeft();
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