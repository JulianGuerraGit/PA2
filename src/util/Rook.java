package util;

import game.*;

public class Rook extends Queen{
    public Rook(boolean white) {
	super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
	if(!super.isLegal(move, game))
	    return false;
	//rules for rook only!
	return true;
    }
    @Override
    public String toString() {
	return white?"\u2656":"\u265C";
    }
}
