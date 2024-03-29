package model.pieces;

import model.*;
import tad.ListCoor;

public abstract class Pawn extends Piece {



    public Pawn(Piece.Type type, Cell cell) {
        super(type, cell);
    }
    public abstract void transform();

    @Override
    public boolean moveTo(Cell p){
        boolean moved =super.moveTo(p);
    }

 /*   public void moveTo(Coordinate c) {
        super.moveTo(c);
        if (getCell().getCoordinate().getRow() == 8 ||
                getCell().getCoordinate().getRow() == 1)
            transform();
    }

  */


    protected void checkPawnKiller(Coordinate c) {
        Board board = getCell().getBoard();
         if ((board.getCell(c) != null) && (board.getCell(c).getPiece().getColor() != getColor()))
            coordinates.add(c);
    }

    protected void checkPawnMove(Coordinate c) {
        Board board = getCell().getBoard();
        if ((board.getCell(c) != null) && (board.getCell(c).isEmpty()))
            coordinates.add(c);
    }

}
