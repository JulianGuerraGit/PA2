package util;

import game.*;

public class King extends Piece {
    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean isLegal(Move move, Game game) {
        if (!super.isLegal(move, game))
            return false;
        //rules for king only!
        int rowDiff = move.getRow1() - move.getRow0();
        int colDiff = move.getCol1() - move.getCol0();
        return Math.abs(colDiff) <= 1 && Math.abs(rowDiff) <= 1;
    }

    @Override
    public String toString() {
        return white ? "\u2654" : "\u265A";
    }
}
