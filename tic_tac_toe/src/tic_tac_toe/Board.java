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
		
		// initialize
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
        // rows
        for (int i = 0; i < size; i++) {
            if (checkLine(board[i][0], i, 0, 0, 1)) return true;
        }

        // columns
        for (int j = 0; j < size; j++) {
            if (checkLine(board[0][j], 0, j, 1, 0)) return true;
        }

        // main diagonal
        if (checkLine(board[0][0], 0, 0, 1, 1)) return true;

        // anti diagonal
        if (checkLine(board[0][size - 1], 0, size - 1, 1, -1)) return true;

        return false;
    }

    private boolean checkLine(Symbol symbol, int row, int col, int rStep, int cStep) {
        if (symbol == Symbol.EMPTY) return false;

        for (int i = 0; i < size; i++) {
            if (board[row + i * rStep][col + i * cStep] != symbol) {
                return false;
            }
        }
        return true;
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
