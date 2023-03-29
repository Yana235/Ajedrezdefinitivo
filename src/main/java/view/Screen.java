package view;
import model.Board;
import model.Coordinate;

public class Screen {
   /* public static void main(String[] args) {
        Board b=new Board();
        Screen.getLetters();
        //Screen.getMiddlePart(b,5);
        Screen.show(b);
    }


    */
    private static String getLetters() {
        return " A B C D E F G H\n"; }
    private static String getMiddlePart(Board board, int fila) {
        StringBuilder salida = new StringBuilder(" " + fila + " ");
        for (int col = 0; col < 8; col++) { salida.append(board.getCell(new Coordinate
                ((char) ('A' + col), fila))); }
        return salida.append(" " + fila + "\n").toString(); }


    public static void show(Board board) {
        StringBuilder salida = new StringBuilder();
        salida.append(getLetters()); for (int fila = 1; fila <= 8; fila++) {
            salida.append(getMiddlePart(board, fila)); }
        salida.append(getLetters());
        System.out.println(salida); }

}
