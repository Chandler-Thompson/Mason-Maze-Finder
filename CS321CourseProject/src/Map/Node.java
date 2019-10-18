package Map;


import java.util.ArrayList;
import java.util.List;

public class Node {
    private List <Node> nodeList = new ArrayList<Node>();
    private int id;
    private String nodeLabel;

    public Node(int id, String label, List<Node> nodeList)
    {
        this.id = id;
        this.nodeList = nodeList;
        nodeLabel = label;
    }

    public int getId()
    {
        return id;
    }

    public List<Node> getNodeList()
    {
        return nodeList;
    }

    public String getNodeLabel()
    {
        return nodeLabel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNodeLabel(String label)
    {
        nodeLabel = label;
    }

}
