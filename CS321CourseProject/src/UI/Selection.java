package UI;

import java.util.ArrayList;

import Map.ClickableNode;

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

	ArrayList<ClickableNode> nodes;
	
	public Selection(ArrayList<ClickableNode> nodes) {
		this.nodes = nodes;
	}
	
	public ArrayList<ClickableNode> getNodes(){
		return nodes;
	}
	
}
