package UI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements KeyListener {
	private boolean controlPressed = false;
	
	public MainFrame() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void keyPressed(KeyEvent eventArgs) {
		if (eventArgs.getKeyCode() == KeyEvent.VK_CONTROL)
			controlPressed = true;
		
	}

	public void keyReleased(KeyEvent eventArgs) {
		if (eventArgs.getKeyCode() == KeyEvent.VK_CONTROL)
			controlPressed = false;
		
	}

	public void keyTyped(KeyEvent eventArgs) {
		// TODO Auto-generated method stub
	}	
	
	public boolean getControlPressed() {
		return controlPressed;
	}
}