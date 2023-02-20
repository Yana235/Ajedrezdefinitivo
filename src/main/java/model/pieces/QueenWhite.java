package model.pieces;

import java.model.Cell;
import java.model.Piece;

public class QueenWhite extends Queen {
    public QueenWhite(Cell cell){
        super(Piece.Type.WHITE_QUEEN,cell);
    }
}
