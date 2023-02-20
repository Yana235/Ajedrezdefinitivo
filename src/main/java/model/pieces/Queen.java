package model.pieces;

import model.*;
import tad.ListCoor;

public abstract class Queen extends Piece {
    private ListCoor coordinates;

    public Queen(Type type, Cell cell) {
        super(type, cell);
    }

    @Override
    public ListCoor getNextMovements() {
        coordinates = new ListCoor();
        Coordinate position = getCell().getCoordinate();
        Coordinate c;

        //DownLeft
        c = position.diagonalDownLeft();
        check(c);
        //
        c = position.up().up().right();
        check(c);

        //DownRight
        c=position.diagonalDownRight();
        check(c);

        //UpLeft
        c= position.diagonalUpLeft();
        check(c);

        //UpRight
        c= position.diagonalUpRight();
        check(c);

        return coordinates;
    }

    public void check(Coordinate c){
        Board board = getCell().getBoard();

        if(board.getCell(c) != null){
            if(board.getCell(c).isEmpty() ||
                    board.getCell(c).getPiece().getColor() != getColor())
                coordinates.add( c);
        }

    }
}
