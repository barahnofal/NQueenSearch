package nodes;

public class AStarNode extends Node implements Comparable<Node>{

	public AStarNode(int[] position) {
		super(position);
		
	}

	@Override
	public int compareTo(Node node2) {
		if(this.countConflicts() > node2.countConflicts())
			return 1;
		else if(this.countConflicts() < node2.countConflicts())
			return -1;
		else
			return 0;
		
	}
	
	

}
