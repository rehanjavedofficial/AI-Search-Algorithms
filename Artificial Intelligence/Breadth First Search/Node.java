import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class Node {
    
    private Object value;
    private boolean visited = false;
    private ArrayList<Node> neighbours;
    
    /**
     * Constructor.
     *
     * @param value
     */
    public Node(Object value) {
        
        this.value = value;
        neighbours = new ArrayList<Node>();
        
    }
    
    /**
     * Constructor.
     *
     * @param value
     * @param visited
     * @param neighbours
     */
    public Node(Object value, boolean visited, ArrayList<Node> neighbours) {
        
        this.value = value;
        this.visited = visited;
        this.neighbours = neighbours;
        
    }
    
    /**
     * @return value
     */
    public Object getValue() {
        
        return value;
        
    }
    
    /**
     * Set new Value.
     *
     * @param object
     */
    public void setValue(Object object) {
        
        this.value = object;
        
    }
    
    /**
     * @return visited
     */
    public boolean isVisited() {
        
        return visited;
        
    }
    
    /**
     * Set new visited status.
     *
     * @param visited
     */
    public void setVisited(boolean visited) {
        
        this.visited = visited;
        
    }
    
    /**
     * @return iterative neighbours
     */
    public Iterator<Node> getNeighbours() {
        
        return neighbours.iterator();
        
    }
    
    /**
     * Set new Neighbours.
     *
     * @param neighbours
     */
    public void setNeighbours(ArrayList<Node> neighbours) {
        
        this.neighbours = neighbours;
        
    }
    
    /**
     * Adding new Neighbour.
     * 
     * @param node
     */
    public void addNeighbour(Node node){
        
        this.neighbours.add(node);
        
    }
    
    /**
     * @return neighbours list.
     */
    public ArrayList<Node> getNeighboursList() {
        
        return neighbours;
        
    }
    
}
