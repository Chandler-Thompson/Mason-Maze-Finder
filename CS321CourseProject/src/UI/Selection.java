package UI;

import java.util.HashSet;
import java.util.Set;

import Map.Node;
import Map.Terrain;

/***
 * 
 * Class for holding and manipulating multiple ClickableNodes at once.
 * 
 * Will be used for implementing user-defined NoGo Areas
 * 
 * @author arari
 *
 */
public class Selection {

	Set<Node> nodes;
	
	public Selection() {
		nodes = new HashSet<>();
	}
	
	public Selection(Set<Node> nodes) {
		this.nodes = nodes;
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void setNodesTerrain(Terrain terrain) {
		for(Node node : nodes) {
			node.setTerrain(terrain);
		}
	}
	
	public void clear() {
		nodes.clear();
	}
	
	public boolean isEmpty() {
		return nodes.isEmpty();
	}
	
	public Set<Node> getNodes(){
		return nodes;
	}
	
}
