package util;

import game.*;

public class Pawn extends Piece {
    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean isLegal(Move move, Game game) {
        if (!super.isLegal(move, game))
            return false;
        //rules for pawn only!
        int rowDiff = move.getRow1() - move.getRow0();
        int colDiff = move.getCol1() - move.getCol0();
        if (rowDiff > 0 && white || rowDiff < 0 && !white)
            return false;//pawn doesn't move backward!
        //add more rules here
        if (game.getPiece(move.getRow1(), move.getCol1()) == null) { // moving not capturing
            if (colDiff != 0 || Math.abs(rowDiff) > 2)    // if moving sideways or more than two spaces return false
                return false;
            boolean isInitialSpace = (move.getRow0() == 1 && !white) || (move.getRow0() == 6 && white);
            if (Math.abs(rowDiff) > 1 && !isInitialSpace) // if moving more than one space
                return false;

        } else { // capturing
            if (Math.abs(colDiff) != 1 && Math.abs(rowDiff) != 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return white ? "\u2659" : "\u265F";
    }
}
