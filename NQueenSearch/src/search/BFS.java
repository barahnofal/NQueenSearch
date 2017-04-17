package search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import driver.Driver;
import nodes.Node;

public class BFS extends Search {

	public BFS(int[] position) {
		check = new HashMap<Integer , Boolean>();
		this.position = position;
		this.solutionState = bfs();

	}
	
	
	public boolean[][] bfs() {

		Node root = new Node(position);
		Queue<Node> queue = new LinkedList<Node>(); //Using a queue for DFS
		queue.add(root);
		check.put(index(root.getPosition()), true);
		Node curentState = null;
		while (queue.isEmpty() == false) {

			curentState = queue.poll();
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
						queue.add(node);
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
						queue.add(node);
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
						queue.add(node);
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
						queue.add(node);
						check.put(index(childposition), true);

					}
				}
				childposition = position.clone();
			}
		}

		return curentState.getState();
	}
}
