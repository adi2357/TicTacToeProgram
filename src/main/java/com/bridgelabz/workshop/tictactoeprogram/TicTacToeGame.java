package com.bridgelabz.workshop.tictactoeprogram;

public class TicTacToeGame {
	
	public static void addBoard() {
		char[] board=new char[10];
		for(int i=0;i<10;i++)
			board[i]=' ';			
	}
	
	public static void main(String[] args) {
		TicTacToeGame gameObj=new TicTacToeGame();
		gameObj.addBoard();
	}

}
