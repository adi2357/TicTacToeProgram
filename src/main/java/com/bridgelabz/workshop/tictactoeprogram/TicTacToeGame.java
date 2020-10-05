package com.bridgelabz.workshop.tictactoeprogram;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
	public static final Scanner SC = new Scanner(System.in);
	public static char[] board;
	public static char[] inputs = new char[2];
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
	private char[] makeMoveAtPosition(char[] board, int tossValue) {
		this.board = board;
		boolean isEmptyPosition = false;
		if (tossValue == USER) {
			System.out.println("Select position from 1 to 9 to make a move : ");
			while (!isEmptyPosition) {
				int boardPosition = SC.nextInt();
				isEmptyPosition = isEmptyAtPosition(board, boardPosition);
				if (isEmptyPosition) {
					System.out.println("Position is empty");
					board[boardPosition] = inputs[0];
				} else {
					System.out.println("Position is not empty. Enter another position");
					showBoard(board);
				}
			}
		}
		if (tossValue == COMPUTER) {
			while (!isEmptyPosition) {
				int boardPosition = (int) (Math.random() * 10 % 9) + 1;
				isEmptyPosition = isEmptyAtPosition(board, boardPosition);
				if (isEmptyPosition)
					board[boardPosition] = inputs[1];
			}
		}
		return board;
	}

//UC 6 : TOSS TO SELECT FIRST PLAYER
	public int toss() {
		int toss = (int) (Math.random() * 10 % 2) + 1;
		if (toss == USER) {
			System.out.println("User plays first");
		} else {
			System.out.println("Computer plays first");
		}
		return toss;
	}

//UC 7 : WINNING CONDITION
	public boolean isWinning(char[] board, char character) {

		boolean isWinner = false;
		if (board[1] == character && board[2] == character && board[3] == character)
			isWinner = true;
		else if (board[4] == character && board[5] == character && board[6] == character)
			isWinner = true;
		else if (board[7] == character && board[8] == character && board[9] == character)
			isWinner = true;
		else if (board[1] == character && board[4] == character && board[7] == character)
			isWinner = true;
		else if (board[2] == character && board[5] == character && board[8] == character)
			isWinner = true;
		else if (board[3] == character && board[6] == character && board[9] == character)
			isWinner = true;
		else if (board[1] == character && board[5] == character && board[9] == character)
			isWinner = true;
		else if (board[3] == character && board[5] == character && board[7] == character)
			isWinner = true;
		else
			isWinner = false;
		return isWinner;
	}
	
//CHECK IF BOARD IS FULL
	public boolean isBoardFull(char[] board) {
		for (int i = 1; i < board.length; i++) {
			if (board[i] == ' ')
				return false;
		}
		return true;
	}
	
//START THE GAME
	public void start() {

		char[] board = addBoard();
		showBoard(board);
		int tossValue = toss();
		if (tossValue == USER)
			inputs = selectInput();
		else if (tossValue == COMPUTER) {
			inputs[0] = 'O';
			inputs[1] = 'X';
		}
		boolean winsGame = false;
		boolean userWins = false;
		boolean computerWins = false;
		boolean isFull = false;

		while (!(winsGame || isFull)) {
			board = makeMoveAtPosition(board, tossValue);
			showBoard(board);
			userWins = isWinning(board, inputs[0]);
			computerWins = isWinning(board, inputs[1]);
			winsGame = userWins || computerWins;
			isFull = isBoardFull(board);
			tossValue = tossValue % 2 + 1;
		}
		if (userWins == true)
			System.out.println("User Wins Tic Tac Toe Game");
		else if (computerWins == true)
			System.out.println("Computer Wins Tic Tac Toe Game");
		else if (userWins == false && computerWins == false)
			System.out.println("TIE");
	}

//MAIN METHOD
	public static void main(String[] args) {
		TicTacToeGame gameObject = new TicTacToeGame();
		gameObject.start();
	}

}
