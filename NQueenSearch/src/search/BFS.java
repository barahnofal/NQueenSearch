package search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import driver.Driver;
import nodes.Node;

public class BFS extends Search {

	private Queue<Node> q;
	
	public BFS(int[] position) {
		q = new LinkedList<Node>();
		check = new HashMap<Integer , Boolean>();
		this.position = position;
		this.solutionState = search();
	}

	@Override
	public void insert(Node n) {
		q.add(n);
	}

	@Override
	public Node extract() {
		return q.poll();
	}

	@Override
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	
	
}
