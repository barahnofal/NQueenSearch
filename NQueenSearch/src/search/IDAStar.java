package search;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import driver.Driver;
import nodes.Node;

public class IDAStar extends Search {

	Node root;
	PriorityQueue<Node> q;
	Stack<Node> lastLevel;

	public IDAStar(int[] position) {
		q = new PriorityQueue<Node>();
		lastLevel = new Stack<Node>();
		root = new Node(position);
		check = new HashMap<Integer , Boolean>();
		this.position = position;
		this.solutionState = search();

	}


	@Override
	public boolean[][] search() {


		insert(root);
		check.put(index(root.getPosition()), true);
		Node currentState = null;
		int[] child;
		int depth = 0, limit = 2;
		Node node;

		while (isEmpty() == false) {

			if(depth <= limit)
			{
				currentState = extract();
				if (currentState.isSolved()) {
					this.position = currentState.getPosition();
					break;
				}

				position = currentState.getPosition();

				for (int i = 0; i < Driver.QUEENS; i++) {

					child = position.clone();
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
				depth++;
			}

			else{
				while(!isEmpty())
				{
					currentState = extract();
					lastLevel.push(currentState);
					if (currentState.isSolved()) {
						this.position = currentState.getPosition();
						break;
					}
				}
			}
			if(!currentState.isSolved() && depth > limit)
			{
				limit++;
				while(!lastLevel.isEmpty()){
					insert(lastLevel.pop());
				}
			}
		}
		
		return currentState.getState();
	}

	

	@Override
	public void insert(Node n) {
		q.add(n);

	}

	@Override
	public Node extract() {
		return (Node)q.poll();
	}

	@Override
	public boolean isEmpty() {
		return (q.isEmpty());
	}


}
