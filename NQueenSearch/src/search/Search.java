package search;

import java.util.HashMap;
import java.util.Stack;
import driver.Driver;


public abstract class Search {
	public int[] position;
	public boolean[][] solutionState;
	HashMap<Integer , Boolean> check;

	
	public int[] getposition() {
		return position;
	}

	public void setposition(int[] position) {
		this.position = position;
	}
	

	
	
	protected int index(int[] position) { //this works for keys up to 10 digits

		StringBuffer numbers = new StringBuffer();
		int ind;
		for (int i = 0; i < position.length ; i++) {
			numbers.append(position[i]);
		}
		ind = Integer.parseInt(numbers.toString());
		return ind;
	}
	
}
