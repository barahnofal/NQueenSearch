package search;

import java.util.HashMap;
import java.util.PriorityQueue;

import driver.Driver;
import nodes.AStarNode;

public class IDAStar extends Search {

	public IDAStar(int[] position) {
		check = new HashMap<Integer , Boolean>();
		this.position = position;
		this.solutionState = idaStar();

	}
	
	
	public boolean[][] idaStar() {

		AStarNode root = new AStarNode(position);
		PriorityQueue<AStarNode> q = new PriorityQueue<AStarNode>(); //Using a priority queue for AStar
		q.add(root);
		check.put(index(root.getPosition()), true);
		AStarNode curentState = null;
		int depth = 0, limit = 2;
		AStarNode AStarNode;
		int[] childposition;
		
		while (q.isEmpty() == false) {
			
			if(!(depth == limit))
			{
				curentState = q.poll();
				depth++;
				if (curentState.isSolved()) {
					this.position = curentState.getPosition();
					break;
				}
				
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
						AStarNode = new AStarNode(childposition);
						if (AStarNode.isSolved()) {
							position = AStarNode.getPosition();
							return AStarNode.getState();
						}
						q.add(AStarNode);
						check.put(index(childposition), true);
					}

				} else if (childposition[i] == (Driver.QUEENS - 1)) { //At the rightmost column
					childposition[i] = childposition[i] - 1;
					if (!check.containsKey(index(childposition))) {
						AStarNode = new AStarNode(childposition);
						if (AStarNode.isSolved()) {
							position = AStarNode.getPosition();
							return AStarNode.getState();
						}
						q.add(AStarNode);
						check.put(index(childposition), true);
					}
				} else { //Somewhere in the middle
					childposition[i] = childposition[i] - 1;
					if (!check.containsKey(index(childposition))) {
						AStarNode = new AStarNode(childposition);
						if (AStarNode.isSolved()) {
							position = AStarNode.getPosition();
							return AStarNode.getState();
						}
						q.add(AStarNode);
						check.put(index(childposition), true);

					}
					childposition = position.clone();
					childposition[i] = childposition[i] + 1;
					if (!check.containsKey(index(childposition))) {

						AStarNode = new AStarNode(childposition);
						if (AStarNode.isSolved()) {
							position = AStarNode.getPosition();
							return AStarNode.getState();
						}
						q.add(AStarNode);
						check.put(index(childposition), true);

					}
				}
				childposition = position.clone();
			}
		}
			else
			{
					curentState = q.poll();
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
								AStarNode = new AStarNode(childposition);
								if (AStarNode.isSolved()) {
									position = AStarNode.getPosition();
									return AStarNode.getState();
								}
								q.add(AStarNode);
								check.put(index(childposition), true);
							}

						} else if (childposition[i] == (Driver.QUEENS - 1)) { //At the rightmost column
							childposition[i] = childposition[i] - 1;
							if (!check.containsKey(index(childposition))) {
								AStarNode = new AStarNode(childposition);
								if (AStarNode.isSolved()) {
									position = AStarNode.getPosition();
									return AStarNode.getState();
								}
								q.add(AStarNode);
								check.put(index(childposition), true);
							}
						} else { //Somewhere in the middle
							childposition[i] = childposition[i] - 1;
							if (!check.containsKey(index(childposition))) {
								AStarNode = new AStarNode(childposition);
								if (AStarNode.isSolved()) {
									position = AStarNode.getPosition();
									return AStarNode.getState();
								}
								q.add(AStarNode);
								check.put(index(childposition), true);

							}
							childposition = position.clone();
							childposition[i] = childposition[i] + 1;
							if (!check.containsKey(index(childposition))) {

								AStarNode = new AStarNode(childposition);
								if (AStarNode.isSolved()) {
									position = AStarNode.getPosition();
									return AStarNode.getState();
								}
								q.add(AStarNode);
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
