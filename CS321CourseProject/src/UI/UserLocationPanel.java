package UI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.border.BevelBorder;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import Map.Node;

@SuppressWarnings("serial")
public class UserLocationPanel extends JPanel {
	
	private JPanel mapPanel;
	
	public UserLocationPanel(final MapPanel mapPanel) {
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		this.mapPanel = mapPanel;
		
		JLabel lbl = new JLabel("Mason MazeFinder");
		lbl.setBounds(63, 27, 250, 43);
		
		lbl.setPreferredSize(new Dimension(1200,43));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBackground(new Color(255, 240, 245));
		lbl.setFont(new Font("Yu Gothic", Font.PLAIN, 26));
		add(lbl);
		
		JLabel academicLabel = new JLabel("Academic Buildings");
		academicLabel.setForeground(new Color(0, 0, 0));
		academicLabel.setBackground(new Color(176, 224, 230));
		academicLabel.setAlignmentX(LEFT_ALIGNMENT);
		academicLabel.setBorder(null);
		
		JButton aquiaBuilding = new JButton("Aquia");
		aquiaBuilding.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		//academic.add(btnAquiaBuilding);
		aquiaBuilding.setForeground(new Color(0, 0, 0));
		aquiaBuilding.setBackground(new Color(176, 224, 230));
		//aquiaBuilding.setAlignmentX(CENTER_ALIGNMENT);
		aquiaBuilding.setBorder(null);
		aquiaBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 340;
				int y = 1181;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				setNode(startLocStatus,x,y);
			}
		});
		
		JButton artDesign = new JButton("Art & Design (3)");
		artDesign.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		artDesign.setForeground(new Color(0, 0, 0));
		artDesign.setBackground(new Color(176, 224, 230));
		artDesign.setBorder(null);
		artDesign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 606;
				int y = 1375;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				setNode(startLocStatus,x,y);
			}
		});
		
		JButton davidKing = new JButton("David King Hall (13)");
		davidKing.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		davidKing.setBackground(new Color(176, 224, 230));
		davidKing.setBorder(null);
		davidKing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 445;
				int y = 1350;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		
		JButton eastBuilding = new JButton("East Building (16)");
		eastBuilding.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		eastBuilding.setBackground(new Color(176, 224, 230));
		eastBuilding.setBackground(new Color(176, 224, 230));
		eastBuilding.setBorder(null);
		eastBuilding.setBorder(null);
		eastBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 262;
				int y = 1254;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				setNode(startLocStatus,x,y);
			}
		});
		
		JButton engineering = new JButton("Engineering (36)");
		engineering.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		//academic.add(btnEngineering);
		engineering.setForeground(new Color(0, 0, 0));
		engineering.setBackground(new Color(176, 224, 230));
		engineering.setBorder(null);
		engineering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 662;
				int y = 1447;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				setNode(startLocStatus,x,y);
			}
		});
		
		
		JButton enterprise = new JButton("Enterprise Hall (17)");
		enterprise.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		enterprise.setForeground(new Color(0, 0, 0));
		enterprise.setBackground(new Color(176, 224, 230));
		enterprise.setBorder(null);
		enterprise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 535;
				int y = 1412;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				setNode(startLocStatus,x,y);
			}
		});
		//academic.add(btnNewButton_4);
		
		JButton exploratory = new JButton("Exploratory Hall (18)");
		exploratory.setBackground(new Color(176, 224, 230));
		exploratory.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		exploratory.setForeground(new Color(0, 0, 0));
		exploratory.setBackground(new Color(176, 224, 230));
		exploratory.setBorder(null);
		exploratory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 486;
				int y = 1428;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				setNode(startLocStatus,x,y);
			}
		});
		//academic.add(btnExploratory);
		
		JButton innovation = new JButton("Innovation (28)");
		innovation.setBackground(new Color(176, 224, 230));
		innovation.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		innovation.setForeground(new Color(0, 0, 0));
		innovation.setBackground(new Color(176, 224, 230));
		innovation.setBorder(null);
		innovation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 605;
				int y = 1312;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				setNode(startLocStatus,x,y);
			}
		});
		//academic.add(btnNewButton_11);
		
		
		final JButton btnAcademic = new JButton("Academic ");
		final JPopupMenu academicMenu = new JPopupMenu("academic buildings");
		
		btnAcademic.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
	    btnAcademic.setBackground(new Color(176, 224, 230));
		btnAcademic.setBounds(26, 93, 86, 23);
		btnAcademic.setBorder(null);
		add(btnAcademic);
		
        academicMenu.setBackground(new Color(176, 224, 230));
        int academicMenuLen = 8 * 23;
        academicMenu.setPreferredSize(new Dimension(200,academicMenuLen));
        academicMenu.setBorder(null);
		academicMenu.add(academicLabel);
        academicMenu.add(aquiaBuilding);
        academicMenu.add(artDesign);
        academicMenu.add(davidKing);
        academicMenu.add(eastBuilding);
        academicMenu.add(engineering);
        academicMenu.add(enterprise);
        academicMenu.add(exploratory);
        academicMenu.add(innovation);
        
      
		btnAcademic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 academicMenu.show(btnAcademic,0, 0);
			}
		});
		
		//DINING AND REC
		
		int countDiningRec = 0;
		
		JButton akeno = new JButton("Akeno Sushi");
		akeno.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		akeno.setBackground(new Color(176, 224, 230));
		akeno.setBorder(null);
		akeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 470;
				int y = 1315;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton afc = new JButton("Aquatic  Fitness Center (AFC)");
		afc.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		afc.setBackground(new Color(176, 224, 230));
		afc.setBorder(null);
		afc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 758;
				int y = 1488;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton argo = new JButton("Argo Tea (22)");
		argo.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		argo.setBackground(new Color(176, 224, 230));
		argo.setBorder(null);
		argo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 348;
				int y = 1337;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton blaze = new JButton("Blaze Pizza (JC)");
		blaze.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		blaze.setBackground(new Color(176, 224, 230));
		blaze.setBorder(null);
		blaze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 470;
				int y = 1315;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton chicFilA = new JButton("Chic Fil A (SUB 1)");
		chicFilA.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		chicFilA.setBackground(new Color(176, 224, 230));
		chicFilA.setBorder(null);
		chicFilA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 350;
				int y = 1222;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				System.out.println("we doin it right");
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton dunkin = new JButton("Dunkin (68)");
		dunkin.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		dunkin.setBackground(new Color(176, 224, 230));
		dunkin.setBorder(null);
		dunkin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 336;
				int y = 1388;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		
		JButton garbanzo = new JButton("Garbanzo (JC)");
		garbanzo.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		garbanzo.setBackground(new Color(176, 224, 230));
		garbanzo.setBorder(null);
		garbanzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 470;
				int y = 1315;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton globe = new JButton("Globe");
		globe.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		globe.setBackground(new Color(176, 224, 230));
		globe.setBorder(null);
		globe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 547;
				int y = 906;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton ikes = new JButton("Ike's");
		ikes.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		ikes.setBackground(new Color(176, 224, 230));
		ikes.setBorder(null);
		ikes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 570;
				int y = 1602;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton indaroma = new JButton("IndAroma/ Red Hot & Blue (JC)");
		indaroma.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		indaroma.setBackground(new Color(176, 224, 230));
		indaroma.setBorder(null);
		indaroma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 470;
				int y = 1315;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton jc = new JButton("Johnson Center (JC)");
		jc.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		jc.setBackground(new Color(176, 224, 230));
		jc.setBorder(null);
		jc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 470;
				int y = 1315;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
					//System.out.println("we doin it right");
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
		
		JButton skyline = new JButton("Skyline (66)");
		skyline.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		skyline.setBackground(new Color(176, 224, 230));
		skyline.setBorder(null);
		skyline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 352;
				int y = 1406;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		
		countDiningRec++;
		JButton southside = new JButton("Southside (67)");
		southside.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		southside.setBackground(new Color(176, 224, 230));
		southside.setBorder(null);
		southside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 370;
				int y = 1441;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		countDiningRec++;
	
		
		JButton starbucks = new JButton("Starbucks (JC)");
		starbucks.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		starbucks.setBackground(new Color(176, 224, 230));
		starbucks.setBorder(null);
		starbucks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 470;
				int y = 1315;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		
		final JButton btnResidence = new JButton("Dining and Rec");
		final JPopupMenu diningRecMenu = new JPopupMenu("dining and rec");
		
		btnResidence.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		btnResidence.setBackground(new Color(176, 224, 230));
		btnResidence.setBounds(26, 127, 109, 23);
		btnResidence.setBorder(null);
		add(btnResidence);
		
		
		diningRecMenu.setBackground(new Color(176, 224, 230));
		int diningRecLen = countDiningRec * 23;
		diningRecMenu.setPreferredSize(new Dimension(200,diningRecLen));
		diningRecMenu.setBorder(null);
		diningRecMenu.add(akeno);
		diningRecMenu.add(afc);
		diningRecMenu.add(argo);
		diningRecMenu.add(blaze);
		diningRecMenu.add(chicFilA);
		diningRecMenu.add(dunkin);
		diningRecMenu.add(garbanzo);
		diningRecMenu.add(globe);
		diningRecMenu.add(ikes);
		diningRecMenu.add(indaroma);
		diningRecMenu.add(jc);
		diningRecMenu.add(skyline);
		diningRecMenu.add(southside);
		diningRecMenu.add(starbucks);
		
		btnResidence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 diningRecMenu.show(btnResidence,0, 0);
			}
		});
		
		JButton lotA = new JButton("Lot A");
		lotA.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		lotA.setBackground(new Color(176, 224, 230));
		lotA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 730;
				int y = 1287;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		lotA.setBorder(null);
		
		JButton lotL = new JButton("Lot L");
		lotL.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		lotL.setBackground(new Color(176, 224, 230));
		lotL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 803;
				int y = 1131;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		lotL.setBorder(null);
		
		JButton lotC = new JButton("Lot C");
		lotC.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		lotC.setBackground(new Color(176, 224, 230));
		lotC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 849;
				int y = 1389;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		lotC.setBorder(null);
		
		JButton rappDeck = new JButton("Rappahannock Parking Deck");
		rappDeck.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		rappDeck.setBackground(new Color(176, 224, 230));
		rappDeck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 153;
				int y = 1424;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		rappDeck.setBorder(null);
		
		JButton shenDeck = new JButton("Shenandoah Parking Deck");
		shenDeck.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		shenDeck.setBackground(new Color(176, 224, 230));
		shenDeck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				int x = 563;
				int y = 1488;
				boolean startLocStatus = false;
				if(mapPanel.getStartingNode()==null)
				{
					startLocStatus = true;
				}
				setNode(startLocStatus,x,y);
			}
		});
		shenDeck.setBorder(null);
		
		final JButton btnParking = new JButton("Parking");
		final JPopupMenu parkingMenu = new JPopupMenu("parking");
		
		btnParking.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		btnParking.setBackground(new Color(176, 224, 230));
		btnParking.setBounds(10, 161, 93, 23);
		btnParking.setBorder(null);
		add(btnParking);
		
		int parkingMenuLength = 5 * 23;
		parkingMenu.setPreferredSize(new Dimension(200,parkingMenuLength));
	    parkingMenu.setBackground(new Color(176, 224, 230));
		parkingMenu.setBorder(null);
		parkingMenu.add(lotA);
		parkingMenu.add(lotL);
		parkingMenu.add(lotC);
		parkingMenu.add(rappDeck);
		parkingMenu.add(shenDeck);
		btnParking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parkingMenu.show(btnParking,0,0);
			}
		});
		
		JButton whitetop = new JButton("Whitetop");
		whitetop.setBackground(new Color(176, 224, 230));
		whitetop.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		whitetop.setBounds(26, 195, 79, 23);
		whitetop.setBorder(null);
		
		
		JButton rogers = new JButton("Rogers");
		rogers.setBackground(new Color(176, 224, 230));
		rogers.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		rogers.setBounds(26, 195, 79, 23);
		rogers.setBorder(null);
		
		
		final JButton btnAquiaNeighbor = new JButton("Aquia Neighborhood");
		final JPopupMenu aquiaMenu = new JPopupMenu("aquia");
		btnAquiaNeighbor.setBackground(new Color(176, 224, 230));
		btnAquiaNeighbor.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		btnAquiaNeighbor.setBounds(26, 195, 79, 23);
		btnAquiaNeighbor.setBorder(null);
		
		aquiaMenu.setBackground(new Color(176, 224, 230));
		int aquiaMenuLen = 3 * 23;
		aquiaMenu.setPreferredSize(new Dimension(200,aquiaMenuLen));
		aquiaMenu.setBorder(null);
		aquiaMenu.add(whitetop);
		aquiaMenu.add(rogers);
		
		
		btnAquiaNeighbor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 aquiaMenu.show(btnAquiaNeighbor,0, 0);
			}
		});

		
		
		JButton btnCommons = new JButton("The Commons");
		btnCommons.setBackground(new Color(176, 224, 230));
		btnCommons.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		btnCommons.setBounds(26, 195, 79, 23);
		btnCommons.setBorder(null);
		//add(btnCommons);
		
		JButton btnPresPark = new JButton("Presdent's Park");
		btnPresPark.setBackground(new Color(176, 224, 230));
		btnPresPark.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		btnPresPark.setBounds(26, 195, 79, 23);
		btnPresPark.setBorder(null);
		//add(btnPresPark);
		
		JButton btnShenNeighbor = new JButton("Shenandoah Neighborhood");
		btnShenNeighbor.setBackground(new Color(176, 224, 230));
		btnShenNeighbor.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		btnShenNeighbor.setBounds(26, 195, 79, 23);
		btnShenNeighbor.setBorder(null);
		//add(btnShanNeighbor);
		
		JButton btnRappNeighbor = new JButton("Rappahannock Neighborhood");
		btnRappNeighbor.setBackground(new Color(176, 224, 230));
		btnRappNeighbor.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		btnRappNeighbor.setBounds(26, 195, 79, 23);
		btnRappNeighbor.setBorder(null);
		//add(btnRappNeighbor);
		
		final JButton btnRes = new JButton("Residence");
		final JPopupMenu residenceMenu = new JPopupMenu("residence");
		
		btnRes.setBackground(new Color(176, 224, 230));
		btnRes.setFont(new Font("Yu Gothic", Font.PLAIN, 13));
		btnRes.setBounds(26, 195, 79, 23);
		btnRes.setBorder(null);
		add(btnRes);
		
		residenceMenu.setBackground(new Color(176, 224, 230));
		int residenceMenuLen = 8 * 23;
		residenceMenu.setPreferredSize(new Dimension(200,residenceMenuLen));
		residenceMenu.setBorder(null);
		residenceMenu.add(btnAquiaNeighbor);
		residenceMenu.add(btnPresPark);
		residenceMenu.add(btnRappNeighbor);
		residenceMenu.add(btnShenNeighbor);
		residenceMenu.add(btnCommons);
		
		btnRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 residenceMenu.show(btnRes,0, 0);
			}
		});
		
		/*JButton btnSaveScreenshot = new JButton("Save  Screenshot");
		btnSaveScreenshot.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSaveScreenshot.setBackground(new Color(176, 224, 230));
		btnSaveScreenshot.setBounds(10, 633, 125, 23);
		add(btnSaveScreenshot);
		
	    JButton setStartingPointButton = new JButton("Set Starting Point");
		setStartingPointButton.setBackground(new Color(176, 224, 230));
		setStartingPointButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		setStartingPointButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mapPanel.setNextClickStart(true);
			}
		});
		setStartingPointButton.setBounds(10, 576, 125, 23);
		add(setStartingPointButton);*/
		
		/*JButton btnNewButton_13 = new JButton("Set Destination");
		btnNewButton_13.setBackground(new Color(176, 224, 230));
		btnNewButton_13.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton_13.setBounds(145, 576, 125, 23);
		add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Calculate Path");
		btnNewButton_14.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton_14.setBackground(new Color(176, 224, 230));
		btnNewButton_14.setBounds(280, 576, 125, 23);
		add(btnNewButton_14);
		
		JButton btnClearPath = new JButton("Clear Path");
		btnClearPath.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnClearPath.setBackground(new Color(176, 224, 230));
		btnClearPath.setBounds(415, 576, 109, 23);
		add(btnClearPath);
		
		JButton btnSavePath = new JButton("Save Path");
		btnSavePath.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSavePath.setBackground(new Color(176, 224, 230));
		btnSavePath.setBounds(145, 633, 125, 23);
		add(btnSavePath);
		
		JButton btnSaveSelection = new JButton("Save Selection");
		btnSaveSelection.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSaveSelection.setBackground(new Color(176, 224, 230));
		btnSaveSelection.setBounds(280, 633, 125, 23);
		add(btnSaveSelection);
		
		JButton btnClearSelection = new JButton("Clear Selection");
		btnClearSelection.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnClearSelection.setBackground(new Color(176, 224, 230));
		btnClearSelection.setBounds(415, 633, 109, 23);
		add(btnClearSelection); */
	}
	
	void setNode(boolean startLocRequired, int x, int y)
	{
		if(startLocRequired)
		{
			((MapPanel) mapPanel).setStartingNode(x,y);
			System.out.println("done!");
		}
		else {
			((MapPanel) mapPanel).setDestinationNode(x, y);
		}
	}
	
}
