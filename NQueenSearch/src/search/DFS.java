package search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import driver.Driver;
import nodes.Node;

public class DFS extends Search {

	public DFS(int[] position) {
		check = new HashMap<Integer , Boolean>();
		this.position = position;
		this.solutionState = dfs();

	}
	
	
	public boolean[][] dfs() {

		Node root = new Node(position);
		Stack<Node> stack = new Stack<Node>(); //Using a stack for DFS
		stack.push(root);
		check.put(index(root.getPosition()), true);
		Node curentState = null;

		while (stack.isEmpty() == false) {

			curentState = stack.pop();
			if (curentState.isSolved()) {
				this.position = curentState.getPosition();
				break;
			}

			position = curentState.getPosition();

			for (int i = 0; i < Driver.QUEENS; i++) {
				Node node;
				int[] childposition = position.clone();
				if (childposition[i] == 0) { //At the leftmost column

					childposition[i] = childposition[i] + 1;
					if (!check.containsKey(index(childposition))) {
						node = new Node(childposition);
						if (node.isSolved()) {
							position = node.getPosition();
							return node.getState();
						}
						stack.push(node);
						check.put(index(childposition), true);
					}

				} else if (childposition[i] == (Driver.QUEENS - 1)) { //At the rightmost column
					childposition[i] = childposition[i] - 1;
					if (!check.containsKey(index(childposition))) {
						node = new Node(childposition);
						if (node.isSolved()) {
							position = node.getPosition();
							return node.getState();
						}
						stack.push(node);
						check.put(index(childposition), true);
					}
				} else { //Somewhere in the middle
					childposition[i] = childposition[i] - 1;
					if (!check.containsKey(index(childposition))) {
						node = new Node(childposition);
						if (node.isSolved()) {
							position = node.getPosition();
							return node.getState();
						}
						stack.push(node);
						check.put(index(childposition), true);

					}
					childposition = position.clone();
					childposition[i] = childposition[i] + 1;
					if (!check.containsKey(index(childposition))) {

						node = new Node(childposition);
						if (node.isSolved()) {
							position = node.getPosition();
							return node.getState();
						}
						stack.push(node);
						check.put(index(childposition), true);

					}
				}
				childposition = position.clone();
			}
		}

		return curentState.getState();
	}
}
