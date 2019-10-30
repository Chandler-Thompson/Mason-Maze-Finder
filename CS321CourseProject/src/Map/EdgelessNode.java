package Map;

import java.io.Serializable;

/**
 * We serialize an array of these to avoid recursive stack overflow from
 * serializing normal graph of nodes. Then we re-construct the original
 * graph from the deserialized grid of EdgelessNodes.
 */
public class EdgelessNode implements Serializable {
	/**
	 * The x-coordinate of the node.
	 */
	int x;
	
	/**
	 * The y-coordinate of the node.
	 */
	int y;
	
	/**
	 * Flag indicating whether or not the node is valid.
	 */
	boolean valid;
	
	public EdgelessNode(int x, int y, boolean valid) {
		this.x = x;
		this.y = y;
		this.valid = valid;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean getValid() {
		return valid;
	}
}