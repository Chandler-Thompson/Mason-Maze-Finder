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
import javax.swing.border.BevelBorder;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JScrollBar;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UserLocationPanel extends JPanel {

	public UserLocationPanel() {
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buildings");
		lblNewLabel.setBounds(211, 5, 111, 43);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 240, 245));
		lblNewLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 26));
		add(lblNewLabel);
		
		JMenu academic = new JMenu("Academic Buildings");
		academic.setBackground(new Color(176, 224, 230));
		academic.setForeground(new Color(0, 0, 0));
		academic.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		academic.setBounds(10, 77, 191, 27);
		add(academic);
		
		JButton btnNewButton = new JButton("Aquia");
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		academic.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(176, 224, 230));
		
		JButton btnNewButton_1 = new JButton("Art and Design");
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		btnNewButton_1.setBackground(new Color(102, 205, 170));
		academic.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("David King Hall");
		academic.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("East Building");
		academic.add(btnNewButton_3);
		
		JButton btnEngineerig = new JButton("Engineering Building");
		academic.add(btnEngineerig);
		
		JButton btnNewButton_4 = new JButton("Enterprise Hall");
		academic.add(btnNewButton_4);
		
		JButton btnExploratory = new JButton("Exploratory Hall");
		btnExploratory.setBackground(new Color(176, 224, 230));
		btnExploratory.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		academic.add(btnExploratory);
		
		JButton btnNewButton_11 = new JButton("Innovation");
		btnNewButton_11.setBackground(new Color(176, 224, 230));
		btnNewButton_11.setFont(new Font("Yu Gothic", Font.PLAIN, 11));
		academic.add(btnNewButton_11);
		
		JMenu diningRec = new JMenu("Dining and Recreational");
		diningRec.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		diningRec.setBounds(10, 115, 225, 27);
		add(diningRec);
		
		JButton btnNewButton_6 = new JButton("Akeno Sushi");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		diningRec.add(btnNewButton_6);
		
		JButton btnAquaticFitnessCenter = new JButton("Aquatic  Fitness Center (AFC)");
		diningRec.add(btnAquaticFitnessCenter);
		
		JButton btnNewButton_7 = new JButton("Argo Tea");
		diningRec.add(btnNewButton_7);
		
		JButton btnBlazePizza = new JButton("Blaze Pizza");
		diningRec.add(btnBlazePizza);
		
		JButton btnChicFilA = new JButton("Chic Fil A");
		diningRec.add(btnChicFilA);
		
		JButton btnDunkin = new JButton("Dunkin");
		diningRec.add(btnDunkin);
		
		JButton btnGarbanzo = new JButton("Garbanzo");
		diningRec.add(btnGarbanzo);
		
		JButton btnGlobe = new JButton("Globe");
		diningRec.add(btnGlobe);
		
		JButton btnNewButton_5 = new JButton("Ike's");
		diningRec.add(btnNewButton_5);
		
		JButton btnIndaroma = new JButton("IndAroma/ Red Hot & Blue");
		diningRec.add(btnIndaroma);
		
		JButton btnJohnsonCenterjc = new JButton("Johnson Center (JC)");
		diningRec.add(btnJohnsonCenterjc);
		
		JButton btnSouthside = new JButton("Southside");
		diningRec.add(btnSouthside);
		
		JButton btnStarbucks = new JButton("Starbucks");
		diningRec.add(btnStarbucks);
		
		JMenu mnParking = new JMenu("Parking");
		mnParking.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		mnParking.setBounds(10, 153, 113, 27);
		add(mnParking);
		
		JButton btnNewButton_8 = new JButton("Lot A");
		mnParking.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Lot C");
		mnParking.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Lot D");
		mnParking.add(btnNewButton_10);
		
		JButton btnRappahanockDeck = new JButton("Rappahannock Parking Deck");
		mnParking.add(btnRappahanockDeck);
		
		JButton btnShandondoah = new JButton("Sandy Creek Parking Deck");
		mnParking.add(btnShandondoah);
		
		JMenu mnResidence = new JMenu("Residence");
		mnResidence.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		mnResidence.setBounds(10, 191, 142, 27);
		add(mnResidence);
		
		JMenu mnAquia = new JMenu("Aquia");
		mnAquia.setBackground(new Color(255, 240, 245));
		mnResidence.add(mnAquia);
		
		JMenu mnPresidentsPark = new JMenu("President's Park");
		mnResidence.add(mnPresidentsPark);
		
		JMenu mnRappahannock = new JMenu("Rappahannock");
		mnResidence.add(mnRappahannock);
		
		JMenu mnShanondoah = new JMenu("Shenandoah");
		mnResidence.add(mnShanondoah);
		
		JMenu mnTheCommons = new JMenu("The Commons");
		mnResidence.add(mnTheCommons);
		
		JButton btnNewButton_12 = new JButton("Set Starting Point");
		btnNewButton_12.setBackground(new Color(176, 224, 230));
		btnNewButton_12.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_12.setBounds(10, 576, 125, 23);
		add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Set Destination");
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
		add(btnClearSelection);
		
		JButton btnSaveScreenshot = new JButton("Save  Screenshot");
		btnSaveScreenshot.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnSaveScreenshot.setBackground(new Color(176, 224, 230));
		btnSaveScreenshot.setBounds(10, 633, 125, 23);
		add(btnSaveScreenshot);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	public void main()
	{
		UserLocationPanel panel = new UserLocationPanel();
	}
}
