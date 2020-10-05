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

	public static void main(String[] args) {
		TicTacToeGame gameObj = new TicTacToeGame();
		char[] newBoard = gameObj.addBoard();
		char[] inputs = gameObj.selectInput();
	}

}
