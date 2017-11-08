import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class BreadthFirstSearch {
    
    /**
     * Constructor
     */
    public BreadthFirstSearch(){
        
    }
    
    /**
     * Algorithm to execute the Breadth
     * First search by iteration method.
     * When you pass root node, it will
     * start executing from the node and
     * move to the end.
     *
     * @param node
     */
    private void executeBFSIteration(Node node, Object toFind){
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        Node current;
        
        while(!queue.isEmpty()){
            
            current = queue.poll();
            if(current == null)
                continue;
            
            if(current.getValue().equals(toFind)){
                System.out.println(toFind.toString() + " Object Found");
                break;
            }
            
            System.out.println(current.getValue().toString());
            Iterator<Node> iterator = current.getNeighbours();
            
            while(iterator.hasNext()){
                
                current = iterator.next();
                if(!current.isVisited()){
                    
                    current.setVisited(true);
                    queue.add(current);
                    
                }
                
            }
            
        }
        
    }
    
    /**
     * Main Method to start execution.
     * Hard code testing of BFS.
     *
     * @param args
     */
    public static void main(String[] args){
        
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        
        // Testing BFS Algorithm
        Node parent = new Node(1);
        parent.addNeighbour(new Node(2));
        parent.addNeighbour(new Node(3));
        Node sub = new Node(4);
        sub.addNeighbour(new Node(5));
        Node subsub = new Node(6);
        subsub.addNeighbour(new Node(7));
        sub.addNeighbour(subsub);
        parent.addNeighbour(sub);
        
        bfs.executeBFSIteration(parent, 3);
        
    }
    
}
