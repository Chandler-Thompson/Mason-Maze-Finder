package Map;

public class QueueNode  {
	
	Node node = null;
	int distance = 0;
	QueueNode prevNode = null;
	
	public QueueNode(Node node, int distance, QueueNode prevNode)
	{
		this.node = node;
		this.distance = distance;
		this.prevNode = prevNode;
	}
	
	public Node getNode()
	{
		return this.node;
	}
	public int getDistance()
	{
		return this.distance;
	}
	
	public void setNode(Node newNode)
	{
		this.node = newNode;
	}
	public void setNode(int newDistance)
	{
		this.distance = newDistance;
	}

}
