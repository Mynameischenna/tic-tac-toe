package tic_tac_toe;

import java.util.Arrays;

import player.Move;
import player.Symbol;

public class Board {
	
	int size;
	Symbol[][] board;
	Board(int size) {
		this.size = size;
		board = new Symbol[size][size];
		
		// initilize
		for (int i = 0; i < size; i++) {
			Arrays.fill(board[i], Symbol.EMPTY);
		}
	}
	 boolean isDraw() {
		 int empty = 0;
		 for (int i = 0; i < size; i++) {
			 for (int j = 0; j < size; j++) {
				 if (board[i][j] == Symbol.EMPTY) empty ++;
			 } 
		 }
		return empty == 0;
	}

	 boolean isWin() {
		 int one = 0;
		 int two = 0;
		 for (int i = 0; i < size; i++) {
			 for (int j = 0; j < size; j++) {
				 if (board[i][j] == Symbol.O) one ++;
				 if (board[i][j] == Symbol.X) two ++;
			 }
			 if (one == size || two == size) return true; 
			 one = 0;
			 two = 0;
			 for (int j = 0; j < size; j++) {
				 if (board[j][i] == Symbol.O) one ++;
				 if (board[j][i] == Symbol.X) two ++;
			 }
			 if (one == size || two == size) return true; 
			 one = 0;
			 two = 0;
			 for (int j = 0; j < size; j++) {
				 if (i == j)
					 if (board[j][i] == Symbol.O) one ++;
				 if (i == j)
					 if (board[j][i] == Symbol.X) two ++;
			 }
			 if (one == size || two == size) return true; 
			 
		 }
		return false;
	}

	void placeMove(Move move, Symbol symbol) {
		board[move.row][move.col] = symbol;
		
	}
	public boolean isValidMove(int row, int col) {
		if (row < 0 || col < 0 || row >= size || col >= size) return false;
		return board[row][col] == Symbol.EMPTY;
	}
	public void printBoard() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
		}
	}
	
}
