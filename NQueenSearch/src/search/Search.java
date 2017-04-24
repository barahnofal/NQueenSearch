package search;

import java.util.HashMap;
import java.util.Stack;
import driver.Driver;
import nodes.Node;


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

	public boolean[][] search() {

		Node root = new Node(position);
		insert(root);
		check.put(index(root.getPosition()), true);
		Node curentState = null;

		while (isEmpty() == false) {

			curentState = extract();
			if (curentState.isSolved()) {
				this.position = curentState.getPosition();
				break;
			}

			position = curentState.getPosition();

			for (int i = 0; i < Driver.QUEENS; i++) {
				Node node;
				int[] child = position.clone();
				if (child[i] == 0) { //At the leftmost column

					child[i] = child[i] + 1;
					if (!check.containsKey(index(child))) {
						node = new Node(child);
						if (node.isSolved()) {
							position = node.getPosition();
							return node.getState();
						} 
						insert(node);
						check.put(index(child), true);
					}

				} else if (child[i] == (Driver.QUEENS - 1)) { //At the rightmost column
					child[i] = child[i] - 1;
					if (!check.containsKey(index(child))) {
						node = new Node(child);
						if (node.isSolved()) {
							position = node.getPosition(); 
							return node.getState();
						} 
						insert(node);
						check.put(index(child), true);
					}
				} else { //Somewhere in the middle
					child[i] = child[i] - 1;
					if (!check.containsKey(index(child))) {
						node = new Node(child);
						if (node.isSolved()) {
							position = node.getPosition(); 
							return node.getState();
						} 
						insert(node);
						check.put(index(child), true);

					}
					child = position.clone();
					child[i] = child[i] + 1;
					if (!check.containsKey(index(child))) {

						node = new Node(child);
						if (node.isSolved()) {
							position = node.getPosition();
							return node.getState();
						} 
						insert(node);
						check.put(index(child), true);

					}
				}
				
				child = position.clone();
			}
		}

		return curentState.getState();
	}

	public abstract void insert(Node n);
	public abstract Node extract();
	public abstract boolean isEmpty();
}
