import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Scanner
		Scanner scan = new Scanner(System.in);
		
		//Setting the height and width
		System.out.print("How high do you want to make the board: ");
		int boardHeight = scan.nextInt();
		System.out.print("How wide do you want to make the board: ");
		int boardWidth = scan.nextInt();
		boolean[][] board = new boolean[boardHeight][boardWidth];
		
		//Get them inputs
		String currentString = new String();
		
		System.out.println("Print your input below (0 is blank and 1 is full): ");
		for(int i = 0; i < boardHeight; i ++) {
			currentString = scan.next();
			for(int k = 0; i < currentString.length(); i++) {
				String point = currentString.substring(i);
				System.out.println(point);
			}
			if(currentString.equals("1")) {
				board[i][0] = true;
			} else {
				board[i][0] = false;
			}
		}
		for(int i = 0; i < boardHeight; i++) {
			System.out.println();
			for(int k = 0; k < boardWidth; k++) {
				System.out.print(board[i][k]);
			}
		}
	}
}
