package User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Map.Node;

public class Profile {

	private String username;
	private String filename;
	private ArrayList<ArrayList<Node>> savedPaths;
	
	public Profile(String username) {
		
		this.username = username;
		this.filename = "src\\Res\\"+username+".profile";
		
		this.savedPaths = new ArrayList<>();
		
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
	
	public void savePath(ArrayList<Node> path) {
		savedPaths.add(path);
	}
	
	public void saveProfile() {
		
		String output = "";//what to write into the file
		
		/**
		 * Add any additional desired output information here
		 */
		
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
			
			ArrayList<Node> currPath = new ArrayList<>();
		
			String line;
			while((line = reader.readLine()) != null) {
				
				/**
				 * Read any additional information here
				 */
				
				//read in saved paths
				if(line.equals("<")) {
					
					//eat it
					
				}else if(line.equals(">")){//save path
					
					profile.savePath(currPath);
					
				}else {//node to read in
					
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
