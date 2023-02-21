package model;
import model.pieces.PawnWhite;
import tad.ListCoor;

import java.util.Scanner;

public class PruebaMain {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Board b = new Board();

       // System.out.println(b);
        b.startPieces();
        System.out.println(b);


            System.out.println("Put coordinate :");
            String coordinate="";
            while(coordinate.length()==2){
               if(coordinate.charAt(0)>'A' && coordinate.charAt(0)<'H'){
                   if(coordinate.charAt(1)>1 && coordinate.charAt(1)<8){
       Coordinate c = new Coordinate(coordinate.charAt(0),coordinate.charAt(1));

                   }

            }


                System.out.println(coordinate);
            }




     /*   Piece p;
        p =new PawnWhite(getCell(new Coordinate('A',4)));
        p.putInYourPlace();
        Coordinate c=new Coordinate('A',5 );
        coordinate=sc.nextLine();


      */

      // Coordinate[] coordinates = b1.getCell(new Coordinate('H',6)).getPiece().getNextMovements();
        // b1.highlight(coordinates);
     //   System.out.println(b1);
      //  b1.resetColors();
   //     System.out.println(b1);
     /*   b = new Board();
        b.testPlacePawn();
    ListCoor coordinates = b.getCell(new Coordinate('C',7)).getPiece().getNextMovements();
       b.highlight(coordinates);
      System.out.println(b);
       b.resetColors();
       System.out.println(b);

      */



    }


}
