package driver;
import search.*;


public class Driver{
	
	public static final int QUEENS = 8;
	public static void main(String[] args) {
		boolean[][] initialBoard = new boolean[QUEENS][QUEENS];
		boolean[][] solvedBoard = new boolean[QUEENS][QUEENS];
		int[] queens = new int[QUEENS];
		
		for(int i = 0; i < QUEENS; i++)
		{
			queens[i] = (int)(Math.random() * QUEENS);
		}
		
		
		for (int i = 0; i < queens.length; i++) {
			initialBoard[i][queens[i]] = true;
		}
		
		System.out.println("Initial board setup is : ");
		printBoard(initialBoard);
		
		String numberOfTests = javax.swing.JOptionPane.showInputDialog("How many algorithms would you like to test?");
		int numberOfTestsint = Integer.parseInt(numberOfTests);

		String inputString;
		int choice;

		for(int i = 0; i < numberOfTestsint; i++){
			inputString = javax.swing.JOptionPane.showInputDialog("Select the algorithm, enter: 1 = DFS, 2 = BFS, 3 = A*, 4 = IDS, 5 = IDA*");
			choice = Integer.parseInt(inputString);
			solvedBoard = solve(choice, queens);
			printBoard(solvedBoard);
		}

	}
	
	private static boolean[][] solve(int choice, int[] queens)
	{ //Choices: 1 = DFS, 2 = BFS, 3 = A*, 4 = IDS, 5 = IDA*
		Search searchClass = null;
		double time1 = 0, time2 = 0;
		if(choice == 1)
		{
			System.out.println("DFS:");
			time1 = System.currentTimeMillis();
			searchClass = new DFS(queens);
			time2 = System.currentTimeMillis();
		}
		if(choice == 2)
		{
			System.out.println("BFS:");
			time1 = System.currentTimeMillis();
			searchClass = new BFS(queens);
			time2 = System.currentTimeMillis();
		}
		if(choice == 3)
		{
			System.out.println("AStar:");
			time1 = System.currentTimeMillis();
			searchClass = new AStar(queens);
			time2 = System.currentTimeMillis();
		}
		if(choice == 4)
		{
			System.out.println("IDS");
			time1 = System.currentTimeMillis();
			searchClass = new IDS(queens);
			time2 = System.currentTimeMillis();
		}
		if(choice == 5)
		{
			System.out.println("IDAStar:");
			time1 = System.currentTimeMillis();
			searchClass = new IDAStar(queens);
			time2 = System.currentTimeMillis();
		}
		
		System.out.println("Following solution found in " + (time2-time1) + "ms");
		return searchClass.solutionState;
	}
	
	private static void printBoard(boolean[][] positions)
	{
		for(int i = 0; i < positions.length; i++){
			for(int j=0; j < positions.length; j++)
			{
				if(positions[i][j])
					System.out.print("1 " + "");
				else
					System.out.print("0" + " ");
			}
			System.out.println();
		}
	}
	
}
