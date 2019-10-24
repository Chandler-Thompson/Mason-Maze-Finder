package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferUShort;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Map.Node;

public class MapPanel extends JPanel implements MouseWheelListener, MouseListener, MouseMotionListener  {

	// NOTE: The default values are what positions the image in the middle of the window when first starting the application.
	// I just printed out the values every repaint(), positioned the image that way, and then used the values that were 
	// printed once I had positioned the image the way I liked it.
	
	/**
	 * This is the image of the map. 
	 */
	private final Image mapImage;
	
	/**
	 * This is the UI component in which this MapPanel is contained. 
	 */
	private MainFrame parent;
	
	/**
	 * The previous amount that the user had zoomed (updated in repaint()).
	 */
	private double prevZoomAount = 0.17075336384126763;

	/** 
	 * Used to zoom relative to the mouse pointer's location.
	 */
	private double xOffset = 6.685615736630126;
	
	/** 
	 * Used to zoom relative to the mouse pointer's location.
	 */	
	private double yOffset = 135.97473533228612;
	
	/**
	 * The current amount of zoom.
	 */
	private double currentZoomAmount = 0.17075336384126763;
	
	/**
	 * How fast zooming "zooms" in and out.
	 */
	private final double zoomSpeed = 1.1;
	
	/**
	 * The maximum amount in which the user can zoom in. This exists to prevent 
	 * the user from being able to zoom in indefinitely.
	 * 
	 * The dual to {@link maxZoomOut}.
	 */
	private double maxZoomIn = 5.0;
	
	/**
	 * The maximum amount in which the user can zoom out. This exists to prevent 
	 * the user from being able to zoom out indefinitely.
	 * 
	 * The dual to {@link maxZoomIn}.
	 */
	private double maxZoomOut = 0.1;
	
	/**
	 * The point at which the user initiated the click-and-drag.
	 */
	private Point mouseDragStart;
	
	/**
	 * Amount of drag in X direction.
	 */
	private double translateX = -5;
	
	/**
	 * Amount of drag in Y direction.
	 */
	private double translateY = -9;
	
	private String imagePath = null;
	
	/**
	 * Indicates whether or not the user has clicked-and-dragged since the last draw.
	 */
	private boolean shouldTranslate = false;
	
	/**
	 * We update {@link xOffset} and {@link yOffset} when the user releases the mouse after transforming.
	 * This flag indicates whether or not we need to do that. Used in repaint().
	 */
	private boolean updateOffsetsOnTranslate = false;
	
	private Rectangle2D imageBounds = null;
	
	private Node[][] nodes = null;
	
	public MapPanel(MainFrame parent, String imagePath) {
		this.parent = parent;
		this.imagePath = imagePath;
		this.mapImage = new ImageIcon(imagePath).getImage();
		
		addMouseWheelListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		try {
			loadNodes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Load nodes based on RGB of image. Eventually we'll just serialize and deserialize them directly.
	 */
	private void loadNodes() throws IOException {
		System.out.println("Loading nodes...");
		BufferedImage bufferedMapImage = ImageIO.read(new File(imagePath));
		//BufferedImage bufferedMapImage = ImageIO.read(MapPanel.class.getResource("C:\\Users\\Benjamin\\Documents\\School\\Fall 2019\\CS 321\\CS321\\CS321CourseProject\\src\\Res\\CampusMapForNodes.png"));
		short[] pixels = ((DataBufferUShort)bufferedMapImage.getRaster().getDataBuffer()).getData();
		
		final int width = bufferedMapImage.getWidth();
        final int height = bufferedMapImage.getHeight();
	    
        int nodeID = 0;	
	    // https://stackoverflow.com/questions/6524196/java-get-pixel-array-from-image
	    // boolean[][] rgbArray = new boolean[height][width];
	    Node[][] nodes = new Node[height][width];
    	final int pixelLength = 4;
    	for (int i = 0, row = 0, col = 0; i + 3 < pixels.length; i += pixelLength) {
    		int argbValue = 0;
    		// The values are stored in the format ARGB (alpha, red, green, blue), so
    		// that's why we compute the offsets the way we do. We also have to mask
    		// the values to extract the specific color value correctly.
    		argbValue += (((int) pixels[i] & 0xff) << 24); // alpha
			argbValue += ((int) pixels[i + 1] & 0xff); // blue
			argbValue += (((int) pixels[i + 2] & 0xff) << 8); // green
			argbValue += (((int) pixels[i + 3] & 0xff) << 16); // red
			Node nextNode = new Node(nodeID, "Node " + nodeID++, (argbValue == 1020), row, col, 
					null, null, null, null);
			nodes[row][col] = nextNode;
			if (col > 0) {
				Node left = nodes[row][col - 1];
				left.setRightNode(nextNode);
				
				nextNode.setLeftNode(left);
			}
			if (row > 0) {
				Node above = nodes[row - 1][col];
				above.setBottomNode(nextNode);
				
				nextNode.setTopNode(above);
			}
			col++;
			// If we've reached the end of a column, reset the column index to zero and increment row.
			if (col == width)
			{
				col = 0;
				row++;
			}
    	}
    	
    	this.nodes = nodes;
	}
	
	/**
	 * Clamp the zoom between {@link maxZoomIn} and {@link maxZoomOut} to ensure 
	 * the user cannot zoom out or zoom in indefinitely. 
	 */
	private void clampZoom() {
		if (currentZoomAmount > maxZoomIn)
			currentZoomAmount = maxZoomIn;
		else if (currentZoomAmount < maxZoomOut)
			currentZoomAmount = maxZoomOut;
	}
	
	/**
	 * Handles mouse scroll events triggered by the user.
	 */
	@Override
    protected void processMouseWheelEvent(MouseWheelEvent eventArgs) {
		// Determine if the user was attempting to zoom in or zoom out based on whether
		// or not the mouse wheel was rotated up or down.
        if (eventArgs.getWheelRotation() < 0) {
        	// Zoom in, then make sure user is within the configured "zoom bounds" by calling clampZoom
        	currentZoomAmount *= zoomSpeed;
            clampZoom();
            repaint();
        }
        if (eventArgs.getWheelRotation() > 0) {
        	// Zoom out, then make sure user is within the configured "zoom bounds" by calling clampZoom
        	currentZoomAmount /= zoomSpeed;
            clampZoom();
        	repaint();
        }
        super.processMouseWheelEvent(eventArgs);
    }
	
	/**
	 * This is related to the UI. We must specify a "preferred size" for this element in order for a parental "scroll pane" to work properly.
	 */
	@Override
    public Dimension getPreferredSize() {
		if (mapImage == null) {
			return parent.getSize();
		}
        return new Dimension(mapImage.getWidth(null), mapImage.getHeight(null));
    }
	
	/**
	 * Draw the map (and possibly other things).
	 */
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    
	    // We use an AffineTransform to scale the image in order to provide zoom functionality.
        AffineTransform transform = new AffineTransform();

        // Get the location of the mouse pointer relative to this UI element. We get the mouse pointer's location
        // as well as the location of "this" UI element (the MapPanel component) to calculate the relative x. 
        double relativeX = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
        double relativeY = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();

        // The amount the zoom has changed relative to the prev. zoom. 
        double zoomRatio = currentZoomAmount / prevZoomAount;

        // We translate the image to allow us to "zoom in/out" relative to the mouse pointer's location.
        // We must first calculate how much to translate the image based on the zoom ratio.
        xOffset = (zoomRatio * xOffset) + (1 - zoomRatio) * relativeX;
        yOffset = (zoomRatio * yOffset) + (1 - zoomRatio) * relativeY;

        // Apply the translation and then the scaling (zoom). Update prev. zoom amount value.
        if (shouldTranslate) {
        	// Need to add the offsets in order to get this to work properly w/zooming.
        	transform.translate(xOffset + translateX, yOffset + translateY);
        	
        	// Update these values when button isn't pressed. If they're always updated,
        	// then you'll be stuck moving in one direction and it'll speed up as you drag. Very weird.
        	if (updateOffsetsOnTranslate) {
        		xOffset += translateX;
        		yOffset += translateY;
            	shouldTranslate = false;
        	}
        }
        else {
        	transform.translate(xOffset, yOffset);
        }
        transform.scale(currentZoomAmount, currentZoomAmount);
        prevZoomAount = currentZoomAmount;
        g2.transform(transform);
        
        // Update the current image bounds based on the transform. Useful for determining if used click image and where. 
        imageBounds = transform.createTransformedShape(new Rectangle(mapImage.getWidth(null), mapImage.getHeight(null))).getBounds2D();
        
    	// printDebugInfo();
        
        for (int i = 0; i < nodes.length; i++) {
        	for (int j = 0; j < nodes[i].length; j++) {
        		Node n = nodes[i][j];
        		if (n.getValid()) {
        			g2.setColor(Color.GREEN);
        			g2.fillOval(i, j, 1, 1);
        		}
        	}
        }
        
        // Draw the image on the screen with transformation applied.
	    g2.drawImage(mapImage,  0,  0,  null);
	}
	
	private Rectangle getImageBounds() {
		int w = mapImage.getWidth(null);
		int h = mapImage.getHeight(null);
		Rectangle rect = new Rectangle(0, 0, w, h);
		
		rect.translate((int)(xOffset + translateX), (int)(yOffset + translateY));
		
		int _w = (int)(currentZoomAmount * w);
		int _h = (int)(currentZoomAmount * h);
		
		rect.grow(_w, _h);
		
		return rect;
	}
	
	/**
	 * Print the values of the various variables.
	 */
	private void printDebugInfo() {
        System.out.println("CurrentZoomAmount: " + currentZoomAmount);
        System.out.println("PrevZoomAmount: " + prevZoomAount);
        System.out.println("Offset X: " + xOffset);
        System.out.println("Offset Y: " + yOffset);
        System.out.println("Translate X: " + translateX);
        System.out.println("Translate Y: " + translateY);		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent eventArgs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent eventArgs) {
		// Get the current point and determine how much the user has moved since clicking.
		Point currentPoint = eventArgs.getLocationOnScreen();
		
		translateX = currentPoint.x - mouseDragStart.x;
		translateY = currentPoint.y - mouseDragStart.y;
		
		shouldTranslate = true;
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent eventArgs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent eventArgs) {
		Point clicked = eventArgs.getPoint();
		
		if (imageBounds.contains(clicked)) {
			Node clickedNode = nodes[clicked.x][clicked.y];
			if (clickedNode.getValid()) {
				System.out.println("Click VALID node at " + clicked + ". (Image clicked!)");
			}			
			else {
				System.out.println("Click INVALID node at " + clicked + ". (Image clicked!)");
			}
		} else {
			System.out.println("Click at " + clicked + ". (Image NOT clicked!)");
		}
		// System.out.println("Current Image Bounds: " + imageBounds);
	}

	@Override
	public void mouseEntered(MouseEvent eventArgs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent eventArgs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent eventArgs) {
		// Pressed just means the button was pressed down, not necessarily released.
		// Clicked means the user pressed and released the button.
		
		updateOffsetsOnTranslate = false; // User clicked so this should be false.
		// getPoint() is relative to the source component.
		mouseDragStart = MouseInfo.getPointerInfo().getLocation();
	}

	@Override
	public void mouseReleased(MouseEvent eventArgs) {
		updateOffsetsOnTranslate = true;	// That also means this should now be set to true.
		
		repaint(); // Drag ended so repaint.
	}
}