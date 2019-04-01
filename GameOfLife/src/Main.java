import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	public static void main(String[] args) {
		Logger.getGlobal().setLevel(Level.OFF);
		//Scanner
		Scanner scan = new Scanner(System.in);
		
		//Setting the height and width
		System.out.print("How high do you want to make the board: ");
		int boardHeight = scan.nextInt();
		System.out.print("How wide do you want to make the board: ");
		int boardWidth = scan.nextInt();
		int[][] board = new int[boardHeight][boardWidth];
		
		//Get them inputs
		String currentString = new String();
		String dash = new String();
		System.out.println("Print your input below (0 is blank and 1 is full, and any not filled in spots turn into 0 if the first spot has either a 0 or a 1 in it): ");
		for(int dashcount = 0; dashcount < boardWidth; dashcount++) {
			dash += "-";
		}
		System.out.println(dash);
		for(int i = 0; i < boardHeight; i ++) {
			currentString = scan.next();
			for(int k = 0; k < currentString.length(); k++) {
				String point = currentString.substring(k, k+1);
				board[i][k] = Integer.parseInt(point);
			}
		}
		
		//Confirm
		String confirm = new String();
		do {
			System.out.println("Is this the board you want (Y/N)?");
			printArray(board);
			System.out.println();
			confirm = scan.next();
			confirm = confirm.toUpperCase();
			if(!confirm.equals("Y")) {
				currentString = new String();
				dash = new String();
				System.out.println("Print your input below (0 is blank and 1 is full): ");
				for(int dashcount = 0; dashcount < boardWidth; dashcount++) {
					dash += "-";
				}
				System.out.println(dash);
				for(int i = 0; i < boardHeight; i ++) {
					currentString = scan.next();
					for(int k = 0; k < currentString.length(); k++) {
						String point = currentString.substring(k, k+1);
						board[i][k] = Integer.parseInt(point);
					}
				}
			}
		} while (!(confirm.equals("Y")));
		
		//Continue Running cycles
		String cont = new String();
		do {
			System.out.println("How many cycles would you like to run?");
			int cycles = scan.nextInt();
			for(int i = 0; i < cycles; i++) {
				nextCycle(board);
			}
			System.out.println();
			printArray(board);
			System.out.println();
			System.out.println("Continue? (Y/N): ");
			cont = scan.next();
			cont = cont.toUpperCase();
		} while (cont.equals("Y"));
		scan.close();
	}
	
	//Computes the next cycles
	public static void nextCycle(int[][] board) {
		int neighbors = 0;
		int[][] boardNouveau = new int[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int k = 0; k < board[0].length; k++) {
				//On the top
				if(i == 0) {
					if (k == 0) {
						//And in the left corner
						Logger.getGlobal().info("i = 0, k = 0");
						neighbors = board[i][k+1] + board[i+1][k] + board[i+1][k+1];
					} else if (k == board[0].length-1) {
						//And in the right corner
						Logger.getGlobal().info("i = 0, k = length");
						neighbors = board[i][k - 1] + board[i + 1][k - 1] + board[i + 1][k];
					} else {
						//Or just on top
						Logger.getGlobal().info("i = 0");
						neighbors = board[i][k-1] + board[i][k+1] + board[i+1][k-1] + board[i+1][k] + board[i+1][k+1];
					}
				} else if(i == board.length-1) {
					//On the bottom
					if(k == 0) {
						//And in the left corner
						Logger.getGlobal().info("i = height, k = 0");
						neighbors = board[i-1][k] + board[i-1][k+1] + board[1][k+1];
					} else if (k == board[0].length-1) {
						//And in the right corner
						Logger.getGlobal().info("i = height, k = length");
						neighbors = board[i-1][k-1] + board[i-1][k] + board[1][k-1];
					} else {
						//Or just on bottom
						Logger.getGlobal().info("i = height");
						neighbors = board[i-1][k-1] + board[i-1][k] + board[i-1][k+1] + board[i][k-1] + board[i][k+1];
					}
				} else if(k == 0) {
					//On the left side
					Logger.getGlobal().info("k = 0");
					neighbors = board[i-1][k] + board[i+1][k] + board[i-1][k+1] + board[i+1][k+1] + board[i][k+1];
				} else if(k == board[0].length-1) {
					//On the right side
					Logger.getGlobal().info("k = length");
					neighbors = board[i-1][k-1] + board[i-1][k] + board[i][k-1] + board[i+1][k-1] + board[i+1][k];
				} else {
					//Or just somewhere in the very middle
					Logger.getGlobal().info("i = ?, k = ?");
					neighbors = board[i-1][k-1] + board[i-1][k] + board[i-1][k+1] + board[i][k-1] + board[i][k+1] + board[i+1][k-1] + board[i+1][k] + board[i+1][k+1];
				}
				//Get the neighbor count
				if(neighbors == 3) {
					boardNouveau[i][k] = 1;
				} else if(neighbors <= 1) {
					boardNouveau[i][k] = 0;
				} else if(neighbors >= 4) {
					boardNouveau[i][k] = 0;
				} else {
					boardNouveau[i][k] = board[i][k];
				}
			}
		}
		//Set the new board
		for(int i = 0; i < board.length; i++) {
			for(int k = 0; k < board[0].length; k++) {
				board[i][k] = boardNouveau[i][k];
			}
		}
	}
	
	//Prints the board
	public static void printArray(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			System.out.println();
			for(int k = 0; k < board[0].length; k++) {
				System.out.print(board[i][k]);
			}
		}
	}
}