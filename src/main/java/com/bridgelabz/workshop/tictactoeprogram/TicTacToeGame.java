package com.bridgelabz.workshop.tictactoeprogram;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	public static final Scanner SC = new Scanner(System.in);
	public static char[] board;
	public static char[] inputs=new char[2];
	public static final int USER = 1;
	public static final int COMPUTER = 2;

//UC1 :	ADD BOARD
	private static char[] addBoard() {
		board = new char[10];
		Arrays.fill(board, ' ');
		return board;
	}

//UC2 : SELECT INPUT
	private static char[] selectInput() {
		System.out.println("Choose X or O :");
		char choice = SC.next().charAt(0);
		char userInput = ' ';
		char computerInput = ' ';
		if (choice == 'X' || choice == 'O') {
			userInput = choice == 'X' ? 'X' : 'O';
			computerInput = userInput == 'X' ? 'O' : 'X';
		} else {
			System.out.println("Invalid input chosen");
		}
		System.out.println("Player Input: " + userInput + " | Computer Input: " + computerInput);
		char[] inputs = { userInput, computerInput };
		return inputs;
	}

//UC3 : SHOW BOARD
	private void showBoard(char[] boardInputs) {
		int i, j = 0;
		int boardPosition = 1;
		char[][] gameBoard = new char[3][3];
		System.out.println("Displaying Board :");
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				gameBoard[i][j] = boardInputs[boardPosition];
				System.out.print(gameBoard[i][j]);
				if (j < 2)
					System.out.print(" | ");
				boardPosition++;
			}
			System.out.println();
			if (i < 2)
				System.out.println("---------");
		}
	}

//UC 4 : MOVE TO BOARD LOCATION AND CHECK EMPTY POSITION
	private boolean isEmptyAtPosition(char[] boardInputs, int boardPosition) {
		boolean isEmpty = false;
		if (boardPosition >= 1 && boardPosition <= 9) {
			if (boardInputs[boardPosition] == ' ')
				isEmpty = true;
		} else
			System.out.println("Invalid position entered");
		return isEmpty;
	}

//UC 5 : MAKE THE MOVE AT GIVEN POSITION
	private char[] makeMoveAtPosition(char[] board) {
		this.board = board;
		System.out.println("Select position from 1 to 9 to make a move : ");
		int boardPosition = SC.nextInt();
		boolean isEmptyPosition = isEmptyAtPosition(board, boardPosition);
		if (isEmptyPosition) {
			System.out.println("Position is empty");
			board[boardPosition] = inputs[0];
		} else
			System.out.println("Position is not empty");
		return board;
	}

//UC 6 : TOSS TO CHECK FIRST PLAYER
	public char[] toss() {
		int toss = (int) (Math.random() * 10 % 2) + 1;
		if (toss == USER){
			System.out.println("User plays first");
			inputs = selectInput();
		}
		else {
			System.out.println("Computer plays first");
			this.inputs[0] = 'O';
			this.inputs[1] = 'X';
		}
		return inputs;
	}

	public static void main(String[] args) {
		TicTacToeGame gameObject = new TicTacToeGame();
		char[] newBoard = gameObject.addBoard();
		inputs = gameObject.toss();
//		gameObject.showBoard(newBoard);
//		newBoard = gameObject.makeMoveAtPosition(newBoard);
//		gameObject.showBoard(newBoard);
	}

}
