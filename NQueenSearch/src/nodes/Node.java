package nodes;
import driver.Driver;


public  class Node {

	public boolean[][] state = new boolean[Driver.QUEENS][Driver.QUEENS];
	public int[] position;

	
	public Node(int[] position) {
		genarateState(position);
		this.position = position;	
		}
	
	
	public boolean[][] getState() {
		return state;
	}

	public void setState(boolean[][] state) {
		this.state = state;
	}

	public int[] getPosition() {
		return position;
	}

	public void setposition(int[] position) {
		this.position = position;
	}

	public void genarateState(int[] position) {

		for (int i = 0; i < state.length; i++) {
			state[i][position[i]] = true;
		}

	}
	
	public boolean isSolved() {

		for (int i = 0; i < state.length; i++) {
			int truePosition = position[i];

			for (int j = i + 1; j < state.length; j++) {
				if (state[j][truePosition] == true) 
					return false;
			}

			// sw
			int posOfI = i + 1;
			for (int j = truePosition + 1; j < state.length && posOfI < state.length; j++) {
				if (state[posOfI][j] == true) 
					return false;

				posOfI++;
			}

			// SE
			posOfI = 0;
			posOfI = i + 1;
			for (int j = truePosition - 1; j >= 0 && posOfI < state.length; j--) {
				if (state[posOfI][j] == true) 
					return false;

				posOfI++;

			}

		}

		return true;
	}

	public int countConflicts() {

		int count = 0;
		for (int i = 0; i < state.length; i++) {
			int truePosition = position[i];

			for (int j = i + 1; j < state.length; j++) {
				if (state[j][truePosition] == true) 
					count++;
			}

			// sw
			int posOfI = i + 1;
			for (int j = truePosition + 1; j < state.length && posOfI < state.length; j++) {
				if (state[posOfI][j] == true) 
					count++;

				posOfI++;
			}

			// SE
			posOfI = 0;
			posOfI = i + 1;
			for (int j = truePosition - 1; j >= 0 && posOfI < state.length; j--) {
				if (state[posOfI][j] == true) 
					count++;

				posOfI++;

			}

		}

		return count;
	}

	
}
