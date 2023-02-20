package model.pieces;

import java.model.Cell;
import java.model.Piece;

public class QueenBlack extends Queen {
    public QueenBlack(Cell cell){
        super(Piece.Type.BLACK_QUEEN,cell);
    }
}
