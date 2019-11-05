package UI;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;

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
		frame = new MainFrame();
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
		
		JButton btnClearSetNodes = new JButton("Clear Selected");
		btnClearSetNodes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapImagePanel.clearSelectedNodes();
			}
		});
		
		controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		controlPanel.add(setStartingPointButton);
		controlPanel.add(btnSetDestination);
		controlPanel.add(btnCalculatePath);
		controlPanel.add(btnClearSetNodes);

	}

}