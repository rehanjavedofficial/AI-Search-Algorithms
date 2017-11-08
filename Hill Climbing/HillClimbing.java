import java.util.ArrayList;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class HillClimbing {

	public enum COMPARISON{ MINIMUM, MAXIMUM };
	
	/**
	 * no-args constructor.
	 */
	public HillClimbing(){
		
	}
	
	/**
	 * Find the node in the array
	 * using hill climbing, which is
	 * a local optimum but
	 * not a global optimum.
	 * 
	 * @param root
	 * @param comparison
	 * @return found Node.
	 */
	public Node search(Node root, COMPARISON comparison){
		
		if(root == null)
			return null;
		
		Node neighbour;
		Node current = root;
		
		while((neighbour = get(current.getNeighboursList(), comparison)) != null){
			
			if((comparison == COMPARISON.MAXIMUM && current.getValue() >= neighbour.getValue()) || 
					(comparison == COMPARISON.MINIMUM && current.getValue() <= neighbour.getValue()))
				break;
			else
				current = neighbour;
			
		}
		
		return current;
		
	}
	
	/**
	 * Find maximum/minimum in the list
	 * and return it.
	 * 
	 * @param list
	 * @param comparison
	 * @return maximum/minimum
	 */
	private Node get(ArrayList<Node> list, COMPARISON comparison){
		
		Node node = null;
		
		if(list.size() > 0)
			node = list.get(0);
		else
			return null;
		
		for(int i = 0; i < list.size(); i++){
			
			if(list.get(i).isVisited())
				continue;
			
			if(comparison == COMPARISON.MAXIMUM && node.getValue() < list.get(i).getValue())
				node = list.get(i);
			else if(comparison == COMPARISON.MINIMUM && node.getValue() > list.get(i).getValue())
				node = list.get(i);
			
		}
		
		return node;
		
	}
	
	/**
	 * Main Method to start execution.
	 * Hard code testing of Hill Climbing.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		HillClimbing hc = new HillClimbing();
		
		// Testing BFS Algorithm
		Node parent = new Node(1);
		parent.addNeighbour(new Node(2));
		parent.addNeighbour(new Node(3));
		Node sub = new Node(4);
		sub.addNeighbour(new Node(5));
		Node subsub = new Node(6);
		subsub.addNeighbour(new Node(7));
		sub.addNeighbour(subsub);
		Node temp = new Node(-1);
		temp.addNeighbour(new Node(10));
		sub.addNeighbour(temp);
		parent.addNeighbour(sub);

		System.out.println(hc.search(parent, COMPARISON.MAXIMUM).getValue());
		
	}
	
}
