package search;

import java.util.HashMap;
import java.util.Stack;

import nodes.Node;

public class DFS extends Search {

	private Stack<Node> stack;
	
	
	public DFS(int[] position) {
		stack = new Stack<Node>();
		check = new HashMap<Integer , Boolean>();
		this.position = position;
		this.solutionState = search();
	}

	@Override
	public void insert(Node n) {
		stack.push(n);
		
	}

	@Override
	public Node extract() {
		return (Node)stack.pop();
	}

	@Override
	public boolean isEmpty() {
		return (stack.isEmpty());
	}

}
