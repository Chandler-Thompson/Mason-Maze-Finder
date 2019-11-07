package Pathfinding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Map.Node;
import Map.QueueNode;

public class ShortestPathAlgorithm  {
	
	/**
	 * the path from starting to destination and a 2D array containing all nodes needed for the algorithm
	 */
	private LinkedList<Node> path = null;
	private Node[][] graph = null;
	
	

	//IMPLEMENTING BFS
	public ShortestPathAlgorithm(LinkedList<Node> path, Node[][] graph) 
	{
		this.path = path;
		this.graph = graph;
		//this.ShortestPath();
	}
		
	public int calculateShortestPath(HashMap<Node, Node> discovered)
	{
		if (discovered.size() > 0)
			throw new IllegalArgumentException("discovered must be empty.");		
		if(path.size() <= 1)
		{
			System.out.println("[ERROR] Two or more locations must be picked, please select another location and try again\n");
			return -1;
		}
		//int locationNum = 1;
		int distance = 0;
		while(path.size() > 1 & distance != -1)
		{
			distance = BFS(this.graph, discovered);
			if(distance != -1)
			{
				//System.out.printf("location #%d visited distance is %d nodes away\n",locationNum,distance);
				//locationNum++;	
			}
			else
			{
				path.clear();
				//System.out.println("Invalid path detected please only valid areas. Select path again\n");
			}
			
		}
		
		return distance;
	}
	
	public int BFS(Node [][] graph, HashMap<Node, Node> discovered)
	{
		if (discovered.size() > 0)
			throw new IllegalArgumentException("discovered must be empty.");
		int ROW = graph.length;
		int COL = graph[0].length;
		boolean [][] visitedNodes = new boolean [graph.length][graph[0].length];//refactor to use constants
		
		int [] rowNum = {-1,0,0,1};
		int [] colNum = {0,-1,1,0};
	  	Node source = path.poll();
	  	Node dest = path.element();
	  	if(graph[source.getXcord()][source.getYcord()].isValid() == false || graph[dest.getXcord()][dest.getYcord()].isValid() == false)
	  	{
	  		path.add(0, source);
	  		return -1;//error handling
	  	}
	  	
	  	Queue<QueueNode> queue = new LinkedList<QueueNode>();
	  	QueueNode src = new QueueNode(source,0, null);
	  	queue.add(src);
	  	visitedNodes[source.getXcord()][source.getYcord()] = true;
	  	int currX, currY = 0;
		while(queue.isEmpty() == false)//beginning of BFS
		{
			QueueNode currNode = queue.poll();
			currX = currNode.getNode().getXcord();
			currY = currNode.getNode().getYcord();
			if(currX == dest.getXcord() && currY == dest.getYcord())//we have reached the destination
			{
				return currNode.getDistance();
			}
			else//do a BFS
			{
				for(int i = 0; i < 4; i++)
				{
					int adjRow = currX + rowNum[i];
					int adjCol = currY + colNum[i];
					//checks to see if the integers go over the array size, if a node has not been visited, and if the node is valid
					if(adjRow >=0 && adjRow < ROW && adjCol >= 0 && adjCol< COL && visitedNodes[adjRow][adjCol] == false && graph[adjRow][adjCol].isValid())
					{
						visitedNodes[adjRow][adjCol] = true;
						QueueNode adjNode = new QueueNode(graph[adjRow][adjCol],currNode.getDistance()+1, currNode);
						discovered.put(adjNode.getNode(), currNode.getNode());
						queue.add(adjNode);//adds to the top of the queue so that it can find its next neighbors
					}
					
				}
			}
		}
		
		
		return -1;//fails if reached here (no valid path)
	}
	
	

	
	/**will find starting point of the graph
	 * 
	 * 
	 */
	public Node getHeadNode()
	{
		return path.element();//returns head of queue;
		
	}
	/**
	 * runs the algorithm till all nodes are visited
	 */
	public void calculateShortest()
	{
		/** Pseudo code:
		 * getHeadmNode();
		 *  while(nodes not visited)
		 *  {
		 *  	update weight of current node's neighbors
		 *  	getHeadmNode of minimum weight/deal with tie score
		 *  }
		 *  Update GUI
		 */
	}
	/**
	 * Will look at the current node's neighbors & update their weight
	 */
	public void updateNeighborsWeight()//majority of the work (find next)
	{
		
		//Node closestNode = startNode;//closest node to destination
		/*boolean topValid = true;//boolean values set true till unvalid nodes hit
		if(path.size() > 1)
		{
			Node startNode = path.poll();//remove start node while it is processes
			Node destNode = path.element();
			while(startNode.getXcord()!= destNode.getXcord() && startNode.getYcord()!= destNode.getYcord())
			{
				if(startNode.getYcord() < destNode.getYcord() && topValid == true)//Checking north or south first
				{
					int topLeftNum = 0;
					int topNum = 0;
					int topRightNum = 0;
					Node topLeft = null;
					Node top = null;
					Node topRight = null;
					
					if(startNode.getTopNode().getLeftNode().getValid())
					{
						topLeft = startNode.getTopNode().getLeftNode();
						topLeftNum = topLeft.getXcord() + topLeft.getYcord();
					}
					if(startNode.getTopNode().getValid())
					{
						top = startNode.getTopNode();
						topNum = top.getXcord() + top.getYcord();
					}
					if(startNode.getTopNode().getRightNode().getValid())
					{
						topRight = startNode.getTopNode().getRightNode();
						topRightNum = topRight.getXcord() + topRight.getYcord();
					}
				
					
					if(topLeftNum >= topNum && topLeftNum >= topRightNum)
					{
						startNode = topLeft;//set node to green/add weight if needed(UI)
					}
					else if(topRightNum >= topLeftNum && topRightNum >= topNum)
					{
						startNode = topRight;//set node to green/add weight if needed(UI)
					}
					else
					{
						startNode = top;//set node to green/add weight if needed(UI)
					}
					
					
					
				}
				else if(startNode.getYcord() > destNode.getYcord())
				{
					
				}*/
			//}
			
			//System.out.printf("startnode cords are x: %d and y: %d",startNode.getXcord(),startNode.getYcord());
			
			//check if North or South node is valid then update, do until E, W need update finish.
			
		}
		//switch statement that will add 1 to each weight to find the most optimal path to the node(as long as it is valid)
			
	}
	


