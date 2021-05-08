import Forth.Forth;
import asteroids.Game;

public class Asteroids {

	public static void main(String[] args) {
		// reference to the asteroids game
		var game = new Game();

		new Forth(game);
	}

}