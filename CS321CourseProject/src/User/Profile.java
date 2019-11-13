package User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import Map.Node;
import Map.Terrain;

public class Profile {

	private String username;
	private String filename;
	private ArrayList<ArrayList<Node>> savedPaths;
	private ArrayList<HashSet<Node>> savedSelections;
	
	public Profile(String username) {
		
		this.username = username;
		this.filename = "src\\Res\\"+username+".profile";
		
		this.savedPaths = new ArrayList<>();
		this.savedSelections = new ArrayList<>();
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public ArrayList<ArrayList<Node>> getSavedPaths(){
		return savedPaths;
	}
	
	public ArrayList<HashSet<Node>> getSavedSelections(){
		return savedSelections;
	}
	
	public void storePath(ArrayList<Node> path) {
		savedPaths.add(path);
		System.out.println("Path Stored");
	}
	
	public void storeSelection(HashSet<Node> selection) {
		savedSelections.add(selection);
		System.out.println("Selection Stored");
	}
	
	public void saveProfile() {
		
		String output = "";//what to write into the file
		
		/**
		 * Add any additional desired output information here
		 */
		
		//add all of the user modified selections to the file output
		for(HashSet<Node> selectionSet : savedSelections) {
			output += "{\n";
			for(Node node : selectionSet) {
				
				int terrainInt = (node.getTerrain() == Terrain.BLOCKED) ? 2 : 1;
				
				output += "("+node.getX()+","+node.getY()+","+terrainInt+")\n";
				
			}
			output += "}\n";
		}
		
		//add all of the saved paths to the file output
		for(ArrayList<Node> path : savedPaths) {
			output += "<\n";
			for(Node node : path) {
				
				output += "("+node.getX()+","+node.getY()+")\n";
				
			}
			output += ">\n";
		}
		
		//write output to file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
						
			writer.write(output);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(username+"'s profile was successfully saved.");
		
	}
	
	//used to create a Profile object from a saved file
	public static Profile loadProfile(String username) {		
		
		Profile profile = new Profile(username);
		
		try (BufferedReader reader = new BufferedReader(new FileReader(profile.getFilename()))) {
			
			boolean inSet = false;
			boolean inPath = false;
			
			HashSet<Node> currSet = new HashSet<>();
			ArrayList<Node> currPath = new ArrayList<>();
			
			String line;
			while((line = reader.readLine()) != null) {
				
				/**
				 * Read any additional information here
				 */
				
				//read in modified selections
				if(line.equals("{")) {
					
					inSet = true;
					
				}else if(line.equals("}")) {
					System.out.println("Loaded Selection");
					profile.storeSelection(currSet);
					System.out.println("Selection: " + profile.getSavedSelections());
					inSet = false;
					
				}else if(inSet){
					
					String nodeXStr = line.substring(1, line.indexOf(','));//start at 1 to rid of '('
					String nodeYStr = line.substring(line.indexOf(',')+1, line.lastIndexOf(','));//+1 to rid of ','
					line = line.substring(line.indexOf(',')+1);//rid of first ','
					String nodeTerrainStr = line.substring(line.indexOf(',')+1, line.length()-1);//+1 to rid of second ','
					
					int nodeX = Integer.parseInt(nodeXStr);
					int nodeY = Integer.parseInt(nodeYStr);
					Terrain nodeTerrain = Terrain.getTerrain(Integer.parseInt(nodeTerrainStr));
					
					Node dummyNode = new Node(nodeX, nodeY);
					dummyNode.setTerrain(nodeTerrain);
					
					currSet.add(dummyNode);
					
				}
				
				//read in saved paths
				if(line.equals("<")) {
					
					inPath = true;
					
				}else if(line.equals(">")){//save path
					
					System.out.println("Loaded Path");
					profile.storePath(currPath);
					System.out.println("Path: " + profile.getSavedPaths());
					inPath = false;
					
				}else if(inPath){//node to read in
					
					String nodeXStr = line.substring(1, line.indexOf(','));//start at 1 to rid of '('
					String nodeYStr = line.substring(line.indexOf(',')+1, line.length()-1);//+1 to rid of ','
					
					int nodeX = Integer.parseInt(nodeXStr);
					int nodeY = Integer.parseInt(nodeYStr);
					
					Node dummyNode = new Node(nodeX, nodeY);
					
					currPath.add(dummyNode);
				}
				
			}
			
		} catch (IOException e) {
			System.err.println("ERROR! Profile { loadProfile() } : Unable to load profile for " + username + ". Creating a new one.");
		}
		
		return profile;
		
	}
	
}
