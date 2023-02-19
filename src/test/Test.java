package test;
import game.*;
public class Test {
    public static void main(String[] args) {
	Game game = new Game("Kasparov", "Karpov");
	game.showBoard(System.out);
	
	System.out.println("Make a move: "+"d2d4");
	if(game.move(new Move("d2d4")))
	    game.showBoard(System.out);
	else
	    System.out.println("Illegal Move!");
	
	System.out.println("Make a move: "+"d3d5");
	if(game.move(new Move("d3d5")))
	    game.showBoard(System.out);
	else
	    System.out.println("Illegal Move!");
	
	System.out.println("Make a move: "+"e7e6");
	if(game.move(new Move("e7e6")))
	    game.showBoard(System.out);
	else
	    System.out.println("Illegal Move!");
	
	System.out.println("Make a move: "+"d1d6");
	if(game.move(new Move("d1d6")))
	    game.showBoard(System.out);
	else
	    System.out.println("Illegal Move!");
	
	System.out.println("Make a move: "+"d1d3");
	if(game.move(new Move("d1d3")))
	    game.showBoard(System.out);
	else
	    System.out.println("Illegal Move!");
	
	System.out.println("Make a move: "+"d8h4");
	if(game.move(new Move("d8h4")))
	    game.showBoard(System.out);
	else
	    System.out.println("Illegal Move!");
	
	System.out.println("Make a move: "+"c1e3");
	if(game.move(new Move("c1e3")))
	    game.showBoard(System.out);
	else
	    System.out.println("Illegal Move!");
    }
}
