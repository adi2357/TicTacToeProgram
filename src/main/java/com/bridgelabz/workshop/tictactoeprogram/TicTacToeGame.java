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
		Scanner sc =new Scanner(System.in);
		System.out.println("Choose X or O :");
		char choice=sc.next().charAt(0);
		char userInput=' ';
		char computerInput=' ';
		switch(choice) {
			case 'X':
				userInput=choice;
				computerInput='O';
				break;
			case 'O':
				userInput=choice;
				computerInput='X';
				break;
			default:
				System.out.println("Invalid Input chosen");
		}
		char[] inputs= {userInput,computerInput};
		return inputs;
		
	}

	public static void main(String[] args) {
		TicTacToeGame gameObj = new TicTacToeGame();
		char[] newBoard = gameObj.addBoard();
		char[] inputs=gameObj.selectInput();			
	}

}
