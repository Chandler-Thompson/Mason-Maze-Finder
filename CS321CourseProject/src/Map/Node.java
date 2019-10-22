package Map;


import java.util.ArrayList;
import java.util.List;

enum Terrain{
	WALKABLE, BLOCKED
}

public class Node {
    private List <Node> nodeList = new ArrayList<Node>();
    private int id;
    private Terrain terrain;//values are walkable or blocked as of 10/22/19 RT
    private String label;

    public Node(int id, String label, List<Node> nodeList)
    {
        this.id = id;
        this.nodeList = nodeList;
        this.label = label;
    }

    public int getId()
    {
        return id;
    }
    
    public Terrain getTerrain()
    {
    	return terrain;
    }

    public List<Node> getList()
    {
        return nodeList;
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

}
