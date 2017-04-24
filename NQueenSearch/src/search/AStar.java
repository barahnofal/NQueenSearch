package search;

import java.util.HashMap;
import java.util.PriorityQueue;
import nodes.Node;

public class AStar extends Search {

	private PriorityQueue<Node> q;
	public AStar(int[] position) {
		q = new PriorityQueue<Node>();
		check = new HashMap<Integer , Boolean>();
		this.position = position;
		this.solutionState = search();

	}

	@Override
	public void insert(Node n) {
		q.add((Node) n);
	}

	@Override
	public Node extract() {
		return (Node) q.poll();
	}

	@Override
	public boolean isEmpty() {
		return q.isEmpty();
	}


}
