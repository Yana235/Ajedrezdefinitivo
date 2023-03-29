package model;

import model.pieces.*;

import tad.ListCoor;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
    private Map<Coordinate, Cell> cells;


    public Board() {
        cells = new HashMap<>();
        initializeCells();
    }

    private void initializeCells() { Coordinate coordinate;
        Cell cell; for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                coordinate = new Coordinate((char)
                        ('A' + col), 1 + row);
                cell = new Cell(this, coordinate);
                cells.put(coordinate, cell); }
        }
    }
    private Cell[][] cell;

    private InterfacePieceDelete deletedPiecedManager;
  /*  public Board(){
        deletedPiecedManager= new DeletePieceManager();
        cells = new Cell[8][8];
        //to create every cell
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(this, new Coordinate((char)('A'+j),i+1));
            }
        }


   */

    public void startPieces(){
        Piece p;

        p = new KnightWhite(getCell(new Coordinate('B',8)));
        p.putInYourPlace();

        p = new KnightWhite(getCell(new Coordinate('G',8)));
        p.putInYourPlace();

        p= new RockWhite(getCell(new Coordinate('A',8)));
        p.putInYourPlace();

        p= new RockWhite(getCell(new Coordinate('H',8)));
        p.putInYourPlace();

        p= new QueenWhite(getCell(new Coordinate('E',8)));
        p.putInYourPlace();

        /*
        p= new PawnWhite(getCell(new Coordinate('A',7)));
        p.putInYourPlace();
        p= new PawnWhite(getCell(new Coordinate('B',7)));
        p.putInYourPlace();
        p= new PawnWhite(getCell(new Coordinate('C',7)));
        p.putInYourPlace();
        p= new PawnWhite(getCell(new Coordinate('D',7)));
        p.putInYourPlace();
        p= new PawnWhite(getCell(new Coordinate('E',7)));
        p.putInYourPlace();
        p= new PawnWhite(getCell(new Coordinate('F',7)));
        p.putInYourPlace();
        p= new PawnWhite(getCell(new Coordinate('G',7)));
        p.putInYourPlace();
        p= new PawnWhite(getCell(new Coordinate('H',7)));
        p.putInYourPlace();


         */
        p= new BishopWhite(getCell(new Coordinate('C',8)));
        p.putInYourPlace();

        p= new BishopWhite(getCell(new Coordinate('F',8)));
        p.putInYourPlace();

        p= new KingWhite(getCell(new Coordinate('D',8)));
        p.putInYourPlace();

        p = new KnightBlack(getCell(new Coordinate('B',1)));
        p.putInYourPlace();

        p = new KnightBlack(getCell(new Coordinate('G',1)));
        p.putInYourPlace();

        p= new RockBlack(getCell(new Coordinate('A',1)));
        p.putInYourPlace();

        p= new RockBlack(getCell(new Coordinate('H',1)));
        p.putInYourPlace();

        p= new QueenBlack(getCell(new Coordinate('E',1)));
        p.putInYourPlace();
/*
        p= new PawnBlack(getCell(new Coordinate('A',2)));
        p.putInYourPlace();
        p= new PawnBlack(getCell(new Coordinate('B',2)));
        p.putInYourPlace();
        p= new PawnBlack(getCell(new Coordinate('C',2)));
        p.putInYourPlace();
        p= new PawnBlack(getCell(new Coordinate('D',2)));
        p.putInYourPlace();
        p= new PawnBlack(getCell(new Coordinate('E',2)));
        p.putInYourPlace();
        p= new PawnBlack(getCell(new Coordinate('F',2)));
        p.putInYourPlace();
        p= new PawnBlack(getCell(new Coordinate('G',2)));
        p.putInYourPlace();
        p= new PawnBlack(getCell(new Coordinate('H',2)));
        p.putInYourPlace();

 */
        p= new BishopBlack(getCell(new Coordinate('C',1)));
        p.putInYourPlace();

        p= new BishopBlack(getCell(new Coordinate('F',1)));
        p.putInYourPlace();

        p= new KingBlack(getCell(new Coordinate('D',1)));
        p.putInYourPlace();

        for (int i = 0; i < 8; i++) {
            p = new PawnBlack(getCell(new Coordinate((char)('A'+i),2)));
            p.putInYourPlace();
            p = new PawnWhite(getCell(new Coordinate((char)('A'+i),7)));
            p.putInYourPlace();
        }

/*
        for (int i = 0; i >8; i++) {
            for(int j=0;j> 8;j++){
                p= new PawnWhite(getCell(new Coordinate( ('A'),7)));
                p.putInYourPlace();
            }


        }

 */


    }

   /* public void highlight(ListCoor coordinates){
//        Coordinate c;
//        while ((c = coordinates.remove(0)) != null)
//            getCell(c).highlight();

        for (int i = 0; i < coordinates.size(); i++) {
            getCell(coordinates.get(i)).highlight();
        }
    }

    */
    public void highlight(Set<Coordinate> coordinates){
        for(Coordinate c : coordinates)
            cells.get(c).highlight(); }
    List<Piece> n=new ArrayList<>();
    private List<Piece> getPieces(){
        return cells.values().stream() .filter(cell -> cell.containsPiece())
                .map(cell -> cell.getPiece()) .collect(Collectors.toList()); }



/*
    public void resetColors(){
        for(Cell[] row : cells)
            for(Cell c : row)
                c.resetColor();
    }

 */
    public void resetColor(){
        for(Coordinate c : cells.keySet())
            cells.get(c).resetColor(); }
/*
    public Cell getCell(Coordinate c) {
        return cells.get(c); }

 */

   public Cell getCell(Coordinate coordinate){
        if(coordinate.getRow()<1 || coordinate.getRow()>8)
            return null;
        if(coordinate.getColumn()<'A' || coordinate.getColumn()>'H')
            return null;
        return cell[coordinate.getRow()-1][coordinate.getColumn()-'A'];
    }
    public Cell getCell(Coordinate c) {
       return cells.get(c); }



    @Override
    public String toString() {
        String output = "   A  B  C  D  E  F  G  H\n";
        for (int i = 0; i < 8; i++) {
            output += (i+1) + " ";
            for (int j = 0; j < 8; j++) {
                output += cell[i][j];
            }
            output += " " + (i+1) + "\n";
        }

        output += "   A  B  C  D  E  F  G  H";
        return output;
    }
    /*

    public void testPlacePawn(){
        Piece p;
        p = new PawnWhite(getCell(new Coordinate('B',6)));
        p.putInYourPlace();
        p = new PawnWhite(getCell(new Coordinate('B',7)));
        p.putInYourPlace();
        p = new PawnBlack(getCell(new Coordinate('B',2)));
        p.putInYourPlace();
    }

     */
    /*

    public void testPlaceBishop(){
        Piece p;
        p = new BishopWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',4)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('B',4)));
        p.putInYourPlace();
    }

    public void testPlaceRook(){
        Piece p;
        p = new RockWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new RockWhite(getCell(new Coordinate('A',6)));
        p.putInYourPlace();
        p = new RockBlack(getCell(new Coordinate('H',6)));
        p.putInYourPlace();
    }

    public void testPlaceQueen(){
        Piece p;
        p = new QueenWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new RockWhite(getCell(new Coordinate('A',6)));
        p.putInYourPlace();
        p = new RockBlack(getCell(new Coordinate('H',6)));
        p.putInYourPlace();
        p = new BishopWhite(getCell(new Coordinate('F',4)));
        p.putInYourPlace();
        p = new BishopBlack(getCell(new Coordinate('B',4)));
        p.putInYourPlace();
    }

    public void testPlaceKing(){
        Piece p;
        p = new KingWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new RockWhite(getCell(new Coordinate('E',6)));
        p.putInYourPlace();
        p = new RockBlack(getCell(new Coordinate('C',6)));
        p.putInYourPlace();
    }


    public void testPlaceKnight(){
        Piece p;
        p = new KnightWhite(getCell(new Coordinate('D',6)));
        p.putInYourPlace();
        p = new KnightWhite(getCell(new Coordinate('F',7)));
        p.putInYourPlace();
        p = new KnightBlack(getCell(new Coordinate('B',7)));
        p.putInYourPlace();
    }

     */
         }
