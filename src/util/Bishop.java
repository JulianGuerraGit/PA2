package util;

import game.*;

public class Bishop extends Queen{
    public Bishop(boolean white) {
	super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
	if(!super.isLegal(move, game))
	    return false;
	//rules for bishop only!
	return true;
    }
    @Override
    public String toString() {
	return white?"\u2657":"\u265D";
    }
}
