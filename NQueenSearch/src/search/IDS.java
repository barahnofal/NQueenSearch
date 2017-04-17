package search;

import java.util.HashMap;
import java.util.Stack;
import driver.Driver;
import nodes.Node;

public class IDS extends Search {

	public IDS(int[] position) {
		check = new HashMap<Integer , Boolean>();
		this.position = position;
		this.solutionState = ids();

	}


	public boolean[][] ids() {

		Node root = new Node(position);
		Stack<Node> stack = new Stack<Node>(); //Using a stack for DFS
		stack.push(root);
		check.put(index(root.getPosition()), true);
		Node curentState = null;
		int[] childposition;
		int depth = 0, limit = 2;
		Node node;
		
		while (stack.isEmpty() == false) {

			if(!(depth == limit))
			{
				curentState = stack.pop();
				depth++;
				if (curentState.isSolved()) {
					this.position = curentState.getPosition();
					break;
				}

				position = curentState.getPosition();

				for (int i = 0; i < Driver.QUEENS; i++) {
					
					childposition = position.clone();
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
			else
			{
				curentState = stack.pop();
				depth++;
				if(limit < 10)
					limit = limit+2;
				
				if (curentState.isSolved()) {
					this.position = curentState.getPosition();
					break;
				}

				position = curentState.getPosition();

				for (int i = 0; i < Driver.QUEENS; i++) {
					
					childposition = position.clone();
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
		}
		return curentState.getState();
	}

}
