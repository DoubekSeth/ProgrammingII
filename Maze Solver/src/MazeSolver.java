public class MazeSolver {
	
	static int mazeHeight;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] originalMaze = mapMaze("* ********     * ** ***** ** * *   ** * *** **   *   **** * * **     * ******** *", 9);
		solveMaze(1, 0, originalMaze);
	}
	
	public static String[][] mapMaze(String mazeString, int mazeWidth) {
		int charCount = 0;
		mazeHeight = mazeString.length()/mazeWidth;
		String[][] maze = new String[mazeWidth][mazeHeight];
		
		int rowCount = -1;
		while(charCount < mazeString.length()) {
			rowCount++;
			for(int i = 0; i < mazeWidth; i++) {
				maze[rowCount][i] = Character.toString(mazeString.charAt(charCount));
				charCount++;
			}
		}
		return maze;
	}
	
	//Returns an Array where index 0 = up, 1 = right, 2 = down, 3 = left
	public static int[] findNeighbors(int xPos, int yPos, String[][] maze) {
		int[] neighbors = {0,0,0,0};
		if(!(yPos - 1 < 0)) {
			if(!(maze[yPos - 1][xPos].equals("*"))) {
				neighbors[0] = 1;
				System.out.println("up");
			}
		}
		if(!(xPos + 1 < 0)) {
			if(!(maze[yPos][xPos + 1].equals("*"))) {
				neighbors[1] = 1;
				System.out.println("right");
			}
		}
		if(!(yPos + 1 < 0)) {
			if(!(maze[yPos + 1][xPos].equals("*"))) {
				neighbors[2] = 1;
				System.out.println("down");
			}
		}
		if(!(xPos - 1 < 0)) {
			if(!(maze[yPos][xPos - 1].equals("*"))) {
				neighbors[3] = 1;
				System.out.println("left");
			} 
		}
		return neighbors;
	}
	
	public static String[][] solveMaze(int xPos, int yPos, String[][] maze){
		int[] neighbors = findNeighbors(xPos, yPos, maze);
		if(yPos == mazeHeight && maze[yPos][xPos] == " ") {
			System.out.println("We Did it!");
		}
		System.out.println(xPos);
		System.out.println(yPos);
		System.out.println(maze[yPos][xPos]);
		System.out.println(" ");
		maze[yPos][xPos] = "&";
		
		if(neighbors[0] == 1) {
			solveMaze(xPos, yPos - 1, maze);
		}
		if(neighbors[1] == 1) {
			solveMaze(xPos + 1, yPos, maze);
		}
		if(neighbors[2] == 1) {
			solveMaze(xPos, yPos + 1, maze);
		}
		if(neighbors[3] == 1) {
			solveMaze(xPos - 1, yPos, maze);
		}
		
		return maze;
	}
}
