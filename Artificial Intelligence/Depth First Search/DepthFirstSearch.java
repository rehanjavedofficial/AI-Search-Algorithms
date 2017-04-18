import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author Rehan Javed
 * @Company RJ APPS
 * @version 1.0
 */
public class DepthFirstSearch {
    
    /**
     * Constructor
     */
    public DepthFirstSearch(){
        
        
    }
    
    /**
     * Algorithm to execute the Depth
     * First search by iteration method.
     * When you pass root node, it will
     * start executing from the node and
     * move to the end.
     *
     * @param node
     */
    public void executeDFSIteration(Node node, Object toFind){
        
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        Node current;
        
        while(!stack.isEmpty()){
            
            current = stack.pop();
            if(current == null)
                continue;
            System.out.println("Item: "+current.getValue().toString());
            
            if(current.getValue().equals(toFind)){
                System.out.println(toFind.toString() + " Object Found");
                break;
            }
            
            ArrayList<Node> iterator = current.getNeighboursList();
            
            for(int i = iterator.size() - 1; i >= 0; i--){
                
                current = iterator.get(i);
                if(!current.isVisited()){
                    
                    current.setVisited(true);
                    stack.add(current);
                    
                }
                
            }
            
        }
        
    }
    
    /**
     * Algorithm to execute the Depth
     * First search by recursive method.
     * When you pass root node, it will
     * start executing from the node and
     * move to the end.
     *
     * @param node
     */
    public void executeDFSRecursive(Node node, Object toFind){
        
        Node current;
        if(node == null)
            return;
        
        if(node.getValue().equals(toFind)){
            System.out.println(toFind.toString() + " Object Found");
            return;
        }
        
        Iterator<Node> iterator = node.getNeighbours();
        System.out.println(node.getValue().toString());
        
        while(iterator.hasNext()){
            
            current = iterator.next();
            if(!current.isVisited()){
                current.setVisited(true);
                executeDFSRecursive(current, toFind);
            }
            
        }
        
    }
    
    /**
     * Algorithm to execute iterative deeping
     * depth first search until the given depth
     * level to find the specific object in it.
     *
     * @param root
     * @param depthLevel
     * @param toFind
     */
    public void executeIterativeDeepingDFSIteratation(Node root, int depthLevel, Object toFind){
        
        Stack<Node> stack = new Stack<>();
        root.setDepthLevel(0);
        stack.add(root);
        Node current = null;
        
        while(!stack.isEmpty()){
            
            current = stack.pop();
            
            if(current == null)
                continue;
            
            if(current.isVisited())
                continue;
            
            System.out.println(current.getValue().toString());
            current.setVisited(true);
            if(current.getValue().equals(toFind)){
                System.out.println("Found....");
                break;
            }
            
            if(current.getDepthLevel() >= depthLevel)
                continue;
            
            for(Node n: current.getNeighboursList()){
                n.incrementDepthLevel();
                stack.push(n);
            }
            
        }
        
        
    }
    
    /**
     * Main method to start execution.
     * Hard Code Testing the DFS..
     * 
     * @param args
     */
    public static void main(String[] args){
        
        DepthFirstSearch dfs = new DepthFirstSearch();
        
        Node parent = new Node(1);
        parent.addNeighbour(new Node(2));
        parent.addNeighbour(new Node(3));
        Node sub = new Node(4);
        sub.addNeighbour(new Node(5));
        Node subsub = new Node(6);
        subsub.addNeighbour(new Node(7));
        sub.addNeighbour(subsub);
        parent.addNeighbour(sub);
        
        dfs.executeDFSIteration(parent, 3);
        //dfs.executeDFSRecursive(parent, 4);
        //dfs.executeIterativeDeepingDFSIteratation(parent, 6, 7);
        
    }
    
}
