package model;
import model.pieces.KingWhite;
import model.pieces.PawnWhite;
import tad.ListCoor;

import java.util.Scanner;

public class PruebaMain {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Board b = new Board();

        b.startPieces();
        System.out.println(b);


      /*  System.out.println("Choose piece:");
        Piece type;
        Piece p= new Piece(Piece.Type.BLACK_PAWN,new Cell(this,new Coordinate('A',2)));


       */
        Board b2= new Board();
        b2.startPieces();
        boolean answerIncorrect=true;
        do{

            System.out.println("Put coordinate :");
            String coordinate="";
            coordinate=sc.nextLine();
            //falta if de 2--> coordinate.length()!=2 && answerIncorrect!=false
            if (coordinate.length()==2) {
               if(coordinate.charAt(0)>='A' && coordinate.charAt(0)<='H'){
                   if(coordinate.charAt(1)>=49 && coordinate.charAt(1)<=56){
                  //    Piece p = new Piece(Piece.Type.BLACK_PAWN,new Cell(b2 ,new Coordinate(coordinate.charAt(0),coordinate.charAt(1)-48)));
                    //  p.moveTo(new Coordinate(coordinate.charAt(0),coordinate.charAt(1)-48));

                    //   System.out.println(p);
                       Piece p= new PawnWhite(new Cell(b2,new Coordinate(coordinate.charAt(0),coordinate.charAt(1)-48)));
                       Piece p2= new KingWhite(new Cell(b2,new Coordinate(coordinate.charAt(0),coordinate.charAt(1)-48)));

                       answerIncorrect = false;

                   }
               }
            }

        }while(answerIncorrect);

        System.out.println(b2);


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
