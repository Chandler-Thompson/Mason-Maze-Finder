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
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof QueueNode)
		{
			QueueNode other = (QueueNode)obj;
			return this.node.equals(other.node);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		if (node == null)
			throw new IllegalStateException("node cannot be null...");
		return this.node.hashCode();
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
