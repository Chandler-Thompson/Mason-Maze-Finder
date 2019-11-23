package Map;


import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
    private Node topNode;
    private Node leftNode;
    private Node rightNode;
    private Node bottomNode;
    private boolean valid;
    private int id;
    private Terrain terrain;//values are walkable or blocked as of 10/22/19 RT
    private String label;
    private int x;
    private int y;

    public Node(int id, 
    		    String label, 
    		    boolean valid,
    		    int x,
    		    int y,
    		    Node top, 
    		    Node left, 
    		    Node right, 
    		    Node bottom)
    {
        this.id = id;
        this.label = label;
        this.valid = valid;
        this.x = x;
        this.y = y;
        this.topNode = top;
        this.leftNode = left;
        this.rightNode = right;
        this.bottomNode = bottom;
    }
    
    //dummy node constructor (used by Profile{ loadProfile() })
    public Node(int x, int y) {
    	
    	this.id = -1;
    	this.label = "";
    	this.valid = true;//assuming being used by loadProfile, if was part of a path, then is valid
    	this.x = x;
    	this.y = y;
    	this.topNode = null;
    	this.leftNode = null;
    	this.rightNode = null;
    	this.bottomNode = null;
    	
    }
    
    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj instanceof Node) {
    		Node other = (Node)obj;
    		return this.x == other.x && this.y == other.y;
    	}
    	
    	return false;
    }
    
    /**
     * Hash code using the Cantor pairing function.
     * 
     * f(x,y) = 1 + [( [x + y] * [x + y + 1] ) / 2] 
     */
    @Override
    public int hashCode() {
    	// https://stackoverflow.com/questions/919612/mapping-two-integers-to-one-in-a-unique-and-deterministic-way
    	return (((x + y) * (x + y + 1)) / 2) + 1;
    }
    
    public boolean isValid() {
    	return valid;
    }

    public int getId()
    {
        return id;
    }
    
    public Terrain getTerrain()
    {
    	return terrain;
    }
    
    public Node getTopNode() {
    	return topNode;
    }
    
    public void setTopNode(Node n) {
    	this.topNode = n;
    }
    
    public Node getLeftNode() {
    	return leftNode;
    }
    
    public void setLeftNode(Node n) {
    	this.leftNode = n;
    }
    
    public Node getRightNode() {
    	return rightNode;
    }
    
    public void setRightNode(Node n) {
    	this.rightNode = n;
    }
    
    public Node getBottomNode() {
    	return bottomNode;
    }
    
    public void setBottomNode(Node n) {
    	this.bottomNode = n;
    }

    public String getLabel()
    {
        return label;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    
    public void setTerrain(Terrain terrain)
    {
    	this.terrain = terrain;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }
    
    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public Point getPoint() {
    	return new Point(x,y);
    }
    
    public Point getPointFlipped() {
    	return new Point(y,x);
    }    
    
}
