package game;

import java.io.PrintStream;
import java.util.*;

import util.*;

public class Game {
    private String player1, player2;
    private ArrayList<Move> moves;
    private Square[][] board;

    public Piece getPiece(int row, int col) {
        return board[row][col].getOccupant();
    }

    public boolean isWhiteTurn() {//specifies whose turn it is: white/player1 or black/player2
        return moves.size() % 2 == 0;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public Game(String player1, String player2) {//sets up the pieces on the board, initializes player's names.
        this.player1 = player1;
        this.player2 = player2;
        moves = new ArrayList<Move>();
        board = new Square[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boolean white = (row + col) % 2 == 0;
                if (row == 1)
                    board[row][col] = new Square(white, new Pawn(false));
                else if (row == 6)
                    board[row][col] = new Square(white, new Pawn(true));
                else if (row == 7 || row == 0) {
                    if (col == 0 || col == 7)
                        board[row][col] = new Square(white, new Rook(row == 7));
                    else if (col == 1 || col == 6)
                        board[row][col] = new Square(white, new Knight(row == 7));
                    else if (col == 2 || col == 5)
                        board[row][col] = new Square(white, new Bishop(row == 7));
                    else if (col == 3)
                        board[row][col] = new Square(white, new Queen(row == 7));
                    else
                        board[row][col] = new Square(white, new King(row == 7));
                } else
                    board[row][col] = new Square(white, null);
            }
        }
    }

    public Game(String player1, String player2, ArrayList<Move> moves) {
        this(player1,player2);
        for( Move move : moves){
            move(move,true);
        }
    }

    public boolean undoMove() {
        if (moves.size() == 0)
            return false;
        moves.remove(moves.size()-1);
        return true;
    }

    public boolean move(Move move, boolean capture) {//makes a move, returns true if successful, false otherwise.
        Square src = board[move.getRow0()][move.getCol0()], dst = board[move.getRow1()][move.getCol1()];
        if (src.getOccupant() == null   //empty src square
                || (dst.getOccupant() != null && !capture) // or if destination is not empty && it is not a capture move
                || !board[move.getRow0()][move.getCol0()].getOccupant().isLegal(move, this))// or if the move is illegal
            return false;

        moves.add(move);
        dst.setOccupant(src.getOccupant());
        src.setOccupant(null);
        return true;
    }

    @Override
    public String toString() {
        return moves.toString();
    }

    public void showBoard(PrintStream stream) {
        stream.println(player2 + "\n______________________________________\n\ta\tb\tc\td\te\tf\tg\th");
        for (int row = 0; row < 8; row++) {
            for (int col = -1; col < 8; col++) {
                if (col < 0)
                    stream.print(8 - row);
                else if (getPiece(row, col) != null)
                    stream.print(getPiece(row, col));
                stream.print(col == -1 ? "\t" : col != 7 ? "\t" : "\n");
            }
        }
        stream.println("______________________________________\n" + player1);
    }
}
