package player;

import java.util.Scanner;

public class PlayerB implements Player{
	String name;
	Symbol symbol;
	
	public PlayerB(String name,Symbol symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Symbol getSymbol() {
		return symbol;
	}

	@Override
	public Move makeMove() {
		int row = -1, col = -1;
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Player B : enter row and col");
		row = sc.nextInt();
		col = sc.nextInt();
		return new Move(row, col);
	}

}
