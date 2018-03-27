
/**
 * Purpose : Tic-tac-toe game with computer as player 2
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 13-03-2018
 */
package com.bridgelab.functionalprograms;

import java.util.Arrays;
import java.util.Random;

import com.bridgelab.utility.Utility;

public class TicTacToe {

	public static void main(String args[]) {
		Utility utility = new Utility();
		int moves = 0;
		boolean player1 = false, player2 = false, switchTurn = false;
		char[][] arr = new char[3][3];

		// fill the two dimensional array with '_'
		for (char[] row : arr)
			Arrays.fill(row, '_');

		// until player 1 wins or player 2 wins or the moves become 9
		while (moves < 9 && !player1 && !player2) {
			Utility.displayBoard(arr);
			if (switchTurn) {
				boolean isEmpty = true;
				Random random = new Random();

				// until the computer finds empty space and plays
				while (isEmpty) {

					int pick = random.nextInt(9);

					switch (pick) {
					case 0:
						if (arr[0][0] == '_') {
							arr[0][0] = 'O';
							isEmpty = false;
						}
						break;
					case 1:
						if (arr[0][1] == '_') {
							arr[0][1] = 'O';
							isEmpty = false;
						}
						break;
					case 2:
						if (arr[0][2] == '_') {
							arr[0][2] = 'O';
							isEmpty = false;
						}
						break;
					case 3:
						if (arr[1][0] == '_') {
							arr[1][0] = 'O';
							isEmpty = false;
						}
						break;
					case 4:
						if (arr[1][1] == '_') {
							arr[1][1] = 'O';
							isEmpty = false;
						}
						break;
					case 5:
						if (arr[1][2] == '_') {
							arr[1][2] = 'O';
							isEmpty = false;
						}
						break;
					case 6:
						if (arr[2][0] == '_') {
							arr[2][0] = 'O';
							isEmpty = false;
						}
						break;
					case 7:
						if (arr[2][1] == '_') {
							arr[2][1] = 'O';
							isEmpty = false;
						}
						break;
					case 8:
						if (arr[2][2] == '_') {
							arr[2][2] = 'O';
							isEmpty = false;
						}
						break;
					}
				}
				switchTurn = false;
			} else {
				System.out.print("Enter the x and y value to mark : ");
				int x = utility.readInt();
				int y = utility.readInt();
				if(arr[x][y] == '_'){
					arr[x][y] = 'X';
					switchTurn = true;
				}else{
					System.out.println("Already marked position. Enter Another position!\n");
					moves--;
				}
				
			}
			moves++;

			if (Utility.checkCol(arr, 'X') || Utility.checkRows(arr, 'X') || Utility.checkDiag(arr, 'X'))
				player1 = true;
			else if (Utility.checkCol(arr, 'O') || Utility.checkRows(arr, 'O') || Utility.checkDiag(arr, 'O')) {
				player2 = true;

			}
		}

		Utility.displayBoard(arr);

		if (player1)
			System.out.println("You win");
		else if (player2)
			System.out.println("Computer Wins");
		else
			System.out.println("Game Draw");
	}
}
