package tic_tac_toe;

import player.Player;
import player.PlayerA;
import player.PlayerB;
import player.Symbol;

public class Main {
	public static void main(String[] args) {
		Player p1 = new PlayerA("chenna", Symbol.O);
		Player p2 = new PlayerB("ramu", Symbol.X);
		
		
		Game game = new Game(p1, p2, 3);
		game.start();
	}
}
