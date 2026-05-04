package tic_tac_toe;

import player.Move;
import player.Player;

public class Game {
	private Board board;
	Player[] players;
	int playerIndex;
	
	 
	Game(Player p1, Player p2, int size) {
		board = new Board(size);
		players = new Player[] {p1, p2};
		playerIndex = 0;
	}
	
	public void start() {
		while (true) {
			Player currPlayer = players[playerIndex];
			board.printBoard();
			Move move = currPlayer.makeMove();
			
			if (!board.isValidMove(move.row, move.col)) {
				System.out.println("Enter valid move !!");
				continue;
			}
			board.placeMove(move, currPlayer.getSymbol());
			// check whether the game is over
			if (board.isWin()) {
				System.out.println(" player "+ currPlayer.getName() + " WON the match !!");
				break;
			}
			if (board.isDraw()) {
				System.out.println(" the game is draw. start over !!");
				break;
			}
			// change the player 
			playerIndex = playerIndex == 0 ? 1 : 0;
		}
	}

	
}
