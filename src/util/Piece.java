package util;

import game.*;

public class Piece {
    protected boolean white;//white if true, black otherwise

    public boolean isLegal(Move move, Game game) {
        if (white != game.isWhiteTurn())
            return false;
        Piece captured = game.getPiece(move.getRow1(), move.getCol1());
        // if the position moving to is empty or the piece in that position does not match the piece moving there return true otherwise false
        return (captured == null || captured.white != this.white);

    }

    public Piece(boolean white) {
        this.white = white;
    }
}
