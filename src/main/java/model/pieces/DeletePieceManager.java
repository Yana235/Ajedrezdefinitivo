package model.pieces;

import tad.ListPieces;

import java.model.Cell;
import java.model.Piece;

import static com.diogonunes.jcolor.Ansi.colorize;


public class DeletePieceManager implements InterfacePieceDelete{

    private ListPieces pieces;
    public DeletePieceManager(){
        pieces= new ListPieces();

    }

    @Override
    public void addPiece(Piece piece){
        pieces.add(piece);
    }
    public int count(Piece.Type type){
        return pieces.count(type);
    }
    public Piece removeLast(){
        return pieces.remove(0);
    }


    public Piece removelast(){
        return pieces.remove(0);
    }

    @Override
    public String toString(){
        String output="";

        for (Piece.Type type : Piece.Type.values())
            output += colorize(" " + type.getShape() +" ",type.getColor().getPieceColor(),Cell.Color.BLACK_CELL.getAttribute());

        output += "\n";

        for (Piece.Type type : Piece.Type.values())
            output += colorize(" " + pieces.count(type) +" ",type.getColor().getPieceColor(),Cell.Color.WHITE_CELL.getAttribute());

        return output;

    }
}
