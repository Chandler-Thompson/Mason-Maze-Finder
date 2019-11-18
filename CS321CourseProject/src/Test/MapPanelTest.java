package Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import Map.Node;
import UI.MainWindow;
import UI.MapPanel;
import org.junit.Assert;

/**
 * Note: an example of coordinates of two valid nodes that have a path between them is (705, 524) and (642, 384).
 */
public class MapPanelTest {
	
	private static MainWindow mainWindow;
	private static MapPanel mapPanel;
	private static Node[][] nodes;

	private static final String regularCampusMapPath = "src\\Res\\campus_map.png";
	private static final String campusMapForNodesPath = "src\\Res\\CampusMapForNodes.png";
	private static final String campusMapForNodesJpgPath = "src\\Res\\CampusMapForNodes.jpg";
	
	@BeforeClass
	public static void setup() throws IOException {
		mainWindow = new MainWindow(regularCampusMapPath, campusMapForNodesJpgPath);
		mapPanel = mainWindow.getMapPanel();
		nodes = mapPanel.getGraph();
	}
	
	/**
	 * Manually set the destination node.
	 * 
	 * Use the getter to retrieve it.
	 * 
	 * Check that the value returned is equal to the value passed to the setter.
	 */
	@Test
	public void setGetDestinationNodeTest() {
		Node n1 = nodes[100][100];
		mapPanel.setDestinationNode(n1);
		
		Node n2 = mapPanel.getDestinationNode();
		
		Assert.assertTrue(n1.equals(n2));
	}
	
	/**
	 * Manually set the starting node.
	 * 
	 * Use the getter to retrieve it.
	 * 
	 * Check that the value returned is equal to the value passed to the setter.
	 */	
	@Test
	public void setGetStartingNodeTest() {
		Node n1 = nodes[100][100];
		mapPanel.setStartingNode(n1);
		
		Node n2 = mapPanel.getStartingNode();
		
		Assert.assertTrue(n1.equals(n2));
	}
	
	/**
	 * This function tests that clearSelection() correctly clears the selection.
	 */
	@Test
	public void clearSelectionTest() {
		// Not sure how to mock this correctly... 
	}
	
	/**
	 * This function tests that clearPathNodes() correctly sets the user-specified start and end 
	 * destinations to null and clears the current path list.
	 */
	@Test
	public void clearPathNodesTest() {
		Node n1 = nodes[524][705];
		Node n2 = nodes[384][642];
		mapPanel.setStartingNode(n1);
		mapPanel.setDestinationNode(n2);
		
		mapPanel.generatePaths();
		
		mapPanel.clearPathNodes();
		
		Assert.assertNull(mapPanel.getStartingNode());
		Assert.assertNull(mapPanel.getDestinationNode());
		Assert.assertTrue(mapPanel.getShortestPath().size() == 0);
	}
}
