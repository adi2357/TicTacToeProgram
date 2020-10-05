package com.bridgelabz.workshop.tictactoeprogram;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

//UC1 :	ADD BOARD
	private static char[] addBoard() {
		char[] board = new char[10];
		Arrays.fill(board, ' ');
		return board;
	}

//UC2 : SELECT INPUT
	private static char[] selectInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose X or O :");
		char choice = sc.next().charAt(0);
		sc.close();
		char userInput = ' ';
		char computerInput = ' ';
		if (choice == 'X' || choice == 'O') {
			userInput = choice == 'X' ? 'X' : 'O';
			computerInput = userInput == 'X' ? 'O' : 'X';
		} else {
			System.out.println("Invalid input chosen");
		}
		char[] inputs = { userInput, computerInput };
		return inputs;
	}

//UC3 : SHOW BOARD
	private void showBoard(char[] boardInputs) {
		int k = 1;
		char[][] gameBoard = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameBoard[i][j] = boardInputs[k];
				System.out.print(gameBoard[i][j]);
				if (j < 2)
					System.out.print(" | ");
			}
			System.out.println();
			if (i < 2)
				System.out.print("_________");
		}
	}

	public static void main(String[] args) {
		TicTacToeGame gameObj = new TicTacToeGame();
		char[] newBoard = gameObj.addBoard();
		char[] inputs = gameObj.selectInput();
		gameObj.showBoard(newBoard);
	}

}
