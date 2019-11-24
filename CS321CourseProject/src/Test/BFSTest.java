package Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import Map.Node;
import Pathfinding.ShortestPathAlgorithm;
import UI.MainWindow;
import UI.MapPanel;
import org.junit.Assert;

public class BFSTest {
	private static  MainWindow mainWindow;
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
	 * Test that the BFS algorithm works for nodes that are directly adjacent to one another.
	 */
	@Test
	public void BFSAdjacentNodesTest() {
		Node n1 = nodes[524][705];
		Node n2 = nodes[524][706];
		
		mapPanel.setStartingNode(n1);
		mapPanel.setDestinationNode(n2);
		
		mapPanel.generatePaths();
		
		ArrayList<Node> path = mapPanel.getShortestPath();
		
		System.out.println("Path: " + path.toString());
		
		Assert.assertTrue("The path ArrayList should not be null.", path != null);
		Assert.assertTrue("The path should contain just two nodes.", path.size() == 2);
		Assert.assertTrue("Path should contain the starting node.", path.contains(n1));
		Assert.assertTrue("Path should contain the destination node.", path.contains(n2));
	}
	
	@Test
	public void BFSNonAdjacentNodesTest() {
		Node n1 = nodes[524][705];
		Node n2 = nodes[524][706];
		Node n3 = nodes[524][707];
		
		mapPanel.setStartingNode(n1);
		mapPanel.setDestinationNode(n3);
		
		mapPanel.generatePaths();	
		
		ArrayList<Node> path = mapPanel.getShortestPath();
		
		System.out.println("Path: " + path.toString());
		
		Assert.assertTrue("The path ArrayList should not be null.", path != null);
		Assert.assertTrue("The path should contain just three nodes.", path.size() == 3);	
		Assert.assertTrue("Path should contain the starting node.", path.contains(n1));
		Assert.assertTrue("Path should contain the node inbetween the start and destination nodes.", path.contains(n2));
		Assert.assertTrue("Path should contain the destination node.", path.contains(n3));		
	}
	@Test
	public void BFSInvalidPathAmount()
	{
		Node destNode = nodes[524][705];
		Node[][]copyNodes = nodes;
		HashMap<Node,Node>discovered = new HashMap<Node,Node>();
		LinkedList<Node> path = new LinkedList<Node>();
		path.add(destNode);
		ShortestPathAlgorithm alg = new ShortestPathAlgorithm(path,copyNodes);
		Assert.assertEquals(-1, alg.calculateShortestPath(discovered));//Error caught
		
	}
	@Test
	public void BFSInvalidNode()
	{
		Node startNode = nodes[530][702];
		Node destNode = nodes[900][0];
		Node[][]copyNodes = nodes;
		HashMap<Node,Node>discovered = new HashMap<Node,Node>();
		LinkedList<Node> path = new LinkedList<Node>();
		path.add(startNode);
		path.add(destNode);
		ShortestPathAlgorithm alg = new ShortestPathAlgorithm(path,copyNodes);
		Assert.assertEquals(-1, alg.calculateShortestPath(discovered));//Path invalid
	}
}
