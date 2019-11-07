package UI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import User.Profile;

public class MainWindow {

	private MainFrame frame;
	
	private static final int width = 1280;
	private static final int height = 720;
	private static final float resizeWeight = 0.3333f;
	private static final float dividerLocation = 0.3333f;
	
	private static final String regularCampusMapPath = "src\\Res\\campus_map.png";
	private static final String campusMapForNodesPath = "src\\Res\\CampusMapForNodes.png";
	private static final String campusMapForNodesJpgPath = "src\\Res\\CampusMapForNodes.jpg";

	private String displayImagePath = null;
	private String nodesImagePath = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow(regularCampusMapPath, campusMapForNodesJpgPath);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace()	;
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public MainWindow(String displayImagePath, String nodesImagePath) throws IOException {
		this.displayImagePath = displayImagePath;
		this.nodesImagePath = nodesImagePath;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//TODO: Remove "TestUser" and replace with actual login
		frame = new MainFrame("TestUser");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {width};
		gridBagLayout.rowHeights = new int[] {0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		// Create JPanels for the map and the control area.
		JPanel controlPanel = new JPanel();
		JPanel mapPanel = new JPanel();
		
		// We use a split pane to divide the UI into two separate sections: controls & map.
		JSplitPane splitPane = new JSplitPane(SwingConstants.VERTICAL, controlPanel, mapPanel);
		
		splitPane.setDividerLocation(dividerLocation);
		splitPane.setResizeWeight(resizeWeight);
		
		ImageIcon mapIcon = new ImageIcon(this.displayImagePath);
		JLabel mapImageLabel = new JLabel(mapIcon);
		
		mapImageLabel.setPreferredSize(new Dimension(mapIcon.getIconWidth(), mapIcon.getIconHeight()));
		
		mapPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		MapPanel mapImagePanel = new MapPanel(frame, this.displayImagePath, this.nodesImagePath);
		mapImagePanel.setPreferredSize(new Dimension(mapIcon.getIconWidth(), mapIcon.getIconHeight()));
		mapPanel.add(mapImagePanel);
		mapImagePanel.setPreferredSize(new Dimension(mapIcon.getIconWidth(), mapIcon.getIconHeight()));
		splitPane.setOrientation(SwingConstants.VERTICAL);
		splitPane.setBackground(Color.GREEN);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.weighty = 1.0;
		gbc_splitPane.weightx = 1.0;
		gbc_splitPane.insets = new Insets(0, 0, 5, 0);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		frame.getContentPane().add(splitPane, gbc_splitPane);

		JButton setStartingPointButton = new JButton("Set Starting Point");
		setStartingPointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapImagePanel.setNextClickStart(true);
			}
		});
		
		JButton btnSetDestination = new JButton("Set Destination");
		btnSetDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapImagePanel.setNextClickDest(true);
			}
		});		
		
		JButton btnCalculatePath = new JButton("Calculate Path");
		btnCalculatePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapImagePanel.generatePaths();
			}
		});
		
		JButton btnClearSetNodes = new JButton("Clear Path");
		btnClearSetNodes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapImagePanel.clearPathNodes();
			}
		});
		
		JButton btnSavePath = new JButton("Save Path");
		btnSavePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapImagePanel.savePath();
			}
		});
		
		JButton btnClearSelectedNodes = new JButton("Clear Selection");
		btnClearSelectedNodes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapImagePanel.clearSelection();
			}
		});
		
		JButton btnTakeScreenshot = new JButton("Take Screenshot");
		btnTakeScreenshot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapImagePanel.takeScreenshot();
			}
		});
		
		controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		controlPanel.add(setStartingPointButton);
		controlPanel.add(btnSetDestination);
		controlPanel.add(btnCalculatePath);
		controlPanel.add(btnClearSetNodes);
		controlPanel.add(btnSavePath);
		controlPanel.add(btnClearSelectedNodes);
		controlPanel.add(btnTakeScreenshot);

	}

}
