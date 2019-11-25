package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import org.junit.BeforeClass;
import org.junit.Test;

import Map.Node;
import UI.MainWindow;
import UI.MapPanel;
import UI.UserLocationPanel;

public class UserLocationPanelTest {
	
	private static MainWindow mainWindow;
	private static MapPanel mapPanel;
	private static UserLocationPanel locationPanel;
	private static Node[][] nodes;

	private static final String regularCampusMapPath = "src\\Res\\campus_map.png";
	private static final String campusMapForNodesPath = "src\\Res\\CampusMapForNodes.png";
	private static final String campusMapForNodesJpgPath = "src\\Res\\CampusMapForNodes.jpg";
	
	@BeforeClass
	public static void setup() throws IOException {
		mainWindow = new MainWindow(regularCampusMapPath, campusMapForNodesJpgPath);
		mapPanel = mainWindow.getMapPanel();
		locationPanel = new UserLocationPanel(mapPanel);
		nodes = mapPanel.getGraph();
	}
	
	@Test
	public void testSetNodeForStart()
	{
		boolean startingNode = true;
		int x = 658;
		int y = 1445;
		locationPanel.setNode(startingNode,x,y);
		assertEquals(mapPanel.getStartingNode().getX(),x);
		assertEquals(mapPanel.getStartingNode().getY(),y);
		
	}
	
	@Test
	public void testSetNodeForDest()
	{
		boolean startingNode = false;
		int x = 658;
		int y = 1445;
		locationPanel.setNode(startingNode,x,y);
		assertEquals(mapPanel.getDestinationNode().getX(),x);
		assertEquals(mapPanel.getDestinationNode().getY(),y);
		
	}

}
