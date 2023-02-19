package util;

import game.*;

public class King extends Piece{

    public King(boolean white) {
	super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
	if(!super.isLegal(move, game))
	    return false;
	//rules for king only!
	return true;
    }
    @Override
    public String toString() {
	return white?"\u2654":"\u265A";
    }
}
