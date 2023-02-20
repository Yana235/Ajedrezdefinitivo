package model;
import java.tad.ListCoor;

public class PruebaMain {

    public static void main(String[] args) {
        Board b = new Board();
        System.out.println(b);

        b.startPieces();
        System.out.println(b);
        b = new Board();

      // Coordinate[] coordinates = b1.getCell(new Coordinate('H',6)).getPiece().getNextMovements();
        // b1.highlight(coordinates);
     //   System.out.println(b1);
      //  b1.resetColors();
   //     System.out.println(b1);

        b.testPlacePawn();
      ListCoor coordinates = b.getCell(new Coordinate('C',7)).getPiece().getNextMovements();
       b.highlight(coordinates);
      System.out.println(b);
       b.resetColors();
       System.out.println(b);
    }
}
