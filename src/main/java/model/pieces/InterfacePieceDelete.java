package model.pieces;

import model.Piece;

public interface InterfacePieceDelete {
    void addPiece(Piece piece);
    int count(Piece.Type type);
    Piece removeLast();
}
