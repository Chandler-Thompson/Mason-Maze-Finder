import java.util.Collection;

import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

public class GraphStorage<V,E> implements Graph<V,E>, DirectedGraph<V,E> {


	@Override
	 /**
     * Adds vertex to this graph.
     * Fails if vertex is null or already in the graph.
     * @param vertex    the vertex to add
     * @return true if the add is successful, and false otherwise
     * @throws IllegalArgumentException if vertex is null
     */
	public boolean addVertex(V arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
     * Removes edge from this graph.
     * Fails if edge is null, or is otherwise not an element of this graph.
     * 
     * @param edge the edge to remove
     * @return true if the removal is successful, false otherwise
     */
	public boolean containsEdge(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
     * Returns true if this graph's vertex collection contains vertex.
     * Equivalent to getVertices().contains(vertex).
     * @param vertex the vertex whose presence is being queried
     * @return true iff this graph contains a vertex vertex
     */
	public boolean containsVertex(V arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
     * Returns the number of edges incident to vertex.  
     * Special cases of interest:
     * <ul>
     * <li/> Incident self-loops are counted once.
     * <li> If there is only one edge that connects this vertex to
     * each of its neighbors (and vice versa), then the value returned 
     * will also be equal to the number of neighbors that this vertex has
     * (that is, the output of getNeighborCount).
     * <li> If the graph is directed, then the value returned will be 
     * the sum of this vertex's indegree (the number of edges whose 
     * destination is this vertex) and its outdegree (the number
     * of edges whose source is this vertex), minus the number of
     * incident self-loops (to avoid double-counting).
     * </ul>
     * <p>Equivalent to getIncidentEdges(vertex).size().
     * 
     * @param vertex the vertex whose degree is to be returned
     * @return the degree of this node
     * @see Hypergraph#getNeighborCount(Object)
     */
	public int degree(V arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
     * Returns an edge that connects v1 to v2.
     * If this edge is not uniquely
     * defined (that is, if the graph contains more than one edge connecting 
     * v1 to v2), any of these edges 
     * may be returned.  findEdgeSet(v1, v2) may be 
     * used to return all such edges.
     * Returns null if either of the following is true:
     * <ul>
     * <li/>v1 is not connected to v2
     * <li/>either v1 or v2 are not present in this graph
     * </ul> 
     * <p><b>Note</b>: for purposes of this method, v1 is only considered to be connected to
     * v2 via a given <i>directed</i> edge e if
     * v1 == e.getSource() && v2 == e.getDest() evaluates to true.
     * (v1 and v2 are connected by an undirected edge u if 
     * u is incident to both v1 and v2.)
     * 
     * @return  an edge that connects v1 to v2, 
     * or null if no such edge exists (or either vertex is not present)
     * @see Hypergraph#findEdgeSet(Object, Object) 
     */
	public E findEdge(V arg0, V arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	  /**
     * Returns all edges that connects v1 to v2.
     * If this edge is not uniquely
     * defined (that is, if the graph contains more than one edge connecting 
     * v1 to v2), any of these edges 
     * may be returned.  findEdgeSet(v1, v2) may be 
     * used to return all such edges.
     * Returns null if v1 is not connected to v2.
     * <br/>Returns an empty collection if either v1 or v2 are not present in this graph.
     *  
     * <p><b>Note</b>: for purposes of this method, v1 is only considered to be connected to
     * v2 via a given <i>directed</i> edge d if
     * v1 == d.getSource() && v2 == d.getDest() evaluates to true.
     * (v1 and v2 are connected by an undirected edge u if 
     * u is incident to both v1 and v2.)
     * 
     * @return  a collection containing all edges that connect v1 to v2, 
     * or null if either vertex is not present
     * @see Hypergraph#findEdge(Object, Object) 
     */
	public Collection<E> findEdgeSet(V arg0, V arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 /**
     * Returns the default edge type for this graph.
     * 
     * @return the default edge type for this graph
     */
	public EdgeType getDefaultEdgeType() {//our graph is directed
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
     * Returns the number of edges in this graph.
     * @return the number of edges in this graph
     */
	public int getEdgeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
     * Returns the number of edges of type edge_type in this graph.
     * @param edge_type the type of edge for which the count is to be returned
     * @return the number of edges of type edge_type in this graph
     */
    public int getEdgeCount(EdgeType edge_type) {
		if(edge_type == EdgeType.DIRECTED) {
			return getEdgeCount();
		}
		return 0;
	}

	@Override
	 /**
     * Returns the edge type of edge in this graph.
     * @param edge
     * @return the EdgeType of edge, or null if edge has no defined type
     */
    public EdgeType getEdgeType(E edge) {
		return EdgeType.DIRECTED;
	}

	@Override
	/**
	 * Gets and returns a collection of all edges in the graph
	 * @return a collection of all edges in the graph
	 */
	public Collection<E> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 /**
     * Returns the collection of edges in this graph which are of type edge_type.
     * @param edge_type the type of edges to be returned
     * @return the collection of edges which are of type edge_type, or
     * null if the graph does not accept edges of this type
     * @see EdgeType
     */
	public Collection<E> getEdges(EdgeType arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
     * Returns the number of vertices that are incident to edge.
     * For hyperedges, this can be any nonnegative integer; for edges this
     * must be 2 (or 1 if self-loops are permitted). 
     * 
     * <p>Equivalent to getIncidentVertices(edge).size().
     * @param edge the edge whose incident vertex count is to be returned
     * @return the number of vertices that are incident to edge.
     */
	public int getIncidentCount(E arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
     * Returns the collection of edges in this graph which are connected to vertex.
     * 
     * @param vertex the vertex whose incident edges are to be returned
     * @return  the collection of edges which are connected to vertex, 
     * or null if vertex is not present
     */
	public Collection<E> getIncidentEdges(V arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	  /**
     * Returns the collection of vertices in this graph which are connected to edge.
     * Note that for some graph types there are guarantees about the size of this collection
     * (i.e., some graphs contain edges that have exactly two endpoints, which may or may 
     * not be distinct).  Implementations for those graph types may provide alternate methods 
     * that provide more convenient access to the vertices.
     * 
     * @param edge the edge whose incident vertices are to be returned
     * @return  the collection of vertices which are connected to edge, 
     * or null if edge is not present
     */
	public Collection<V> getIncidentVertices(E arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
     * Returns the number of vertices that are adjacent to vertex
     * (that is, the number of vertices that are incident to edges in vertex's
     * incident edge set).
     * 
     * <p>Equivalent to getNeighbors(vertex).size().
     * @param vertex the vertex whose neighbor count is to be returned
     * @return the number of neighboring vertices
     */
	public int getNeighborCount(V arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
     * Returns the collection of vertices which are connected to vertex
     * via any edges in this graph.
     * If vertex is connected to itself with a self-loop, then 
     * it will be included in the collection returned.
     * 
     * @param vertex the vertex whose neighbors are to be returned
     * @return  the collection of vertices which are connected to vertex, 
     * or null if vertex is not present
     */
	public Collection<V> getNeighbors(V arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 /**
     * Returns the number of vertices in this graph.
     * @return the number of vertices in this graFph
     */
	public int getVertexCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
     * Returns a view of all vertices in this graph. In general, this
     * obeys the Collection contract, and therefore makes no guarantees 
     * about the ordering of the vertices within the set.
     * @return a Collection view of all vertices in this graph
     */
	public Collection<V> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
     * Returns true if vertex and edge 
     * are incident to each other.
     * Equivalent to getIncidentEdges(vertex).contains(edge) and to
     * getIncidentVertices(edge).contains(vertex).
     * @param vertex
     * @param edge
     * @return true if vertex and edge 
     * are incident to each other
     */
	public boolean isIncident(V arg0, E arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	 /**
     * Returns true if v1 and v2 share an incident edge.
     * Equivalent to getNeighbors(v1).contains(v2).
     * 
     * @param v1 the first vertex to test
     * @param v2 the second vertex to test
     * @return true if v1 and v2 share an incident edge
     */
	public boolean isNeighbor(V arg0, V arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
     * Removes edge from this graph.
     * Fails if edge is null, or is otherwise not an element of this graph.
     * 
     * @param edge the edge to remove
     * @return true if the removal is successful, false otherwise
     */
	public boolean removeEdge(E arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
     * Removes vertex from this graph.
     * As a side effect, removes any edges e incident to vertex if the 
     * removal of vertex would cause e to be incident to an illegal
     * number of vertices.  (Thus, for example, incident hyperedges are not removed, but 
     * incident edges--which must be connected to a vertex at both endpoints--are removed.) 
     * 
     * <p>Fails under the following circumstances:
     * <ul>
     * <li/>vertex is not an element of this graph
     * <li/>vertex is null
     * </ul>
     * 
     * @param vertex the vertex to remove
     * @return true if the removal is successful, false otherwise
     */
	public boolean removeVertex(V arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
     * Adds edge e to this graph such that it connects 
     * vertex v1 to v2.
     * Equivalent to addEdge(e, new Pair<V>(v1, v2)).
     * If this graph does not contain v1, v2, 
     * or both, implementations may choose to either silently add 
     * the vertices to the graph or throw an IllegalArgumentException.
     * If this graph assigns edge types to its edges, the edge type of
     * e will be the default for this graph.
     * See Hypergraph.addEdge() for a listing of possible reasons
     * for failure.
     * @param e the edge to be added
     * @param v1 the first vertex to be connected
     * @param v2 the second vertex to be connected
     * @return true if the add is successful, false otherwise\
     * @see Hypergraph#addEdge(Object, Collection)
     * @see #addEdge(Object, Object, Object, EdgeType)
     */
	public boolean addEdge(E arg0, V arg1, V arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	 /**
     * Adds edge e to this graph such that it connects 
     * vertex v1 to v2.
     * Equivalent to addEdge(e, new Pair<V>(v1, v2)).
     * If this graph does not contain v1, v2, 
     * or both, implementations may choose to either silently add 
     * the vertices to the graph or throw an IllegalArgumentException.
     * If edgeType is not legal for this graph, this method will
     * throw IllegalArgumentException.
     * See Hypergraph.addEdge() for a listing of possible reasons
     * for failure.
     * @param e the edge to be added
     * @param v1 the first vertex to be connected
     * @param v2 the second vertex to be connected
     * @param edgeType the type to be assigned to the edge
     * @return true if the add is successful, false otherwise
     * @see Hypergraph#addEdge(Object, Collection)
     * @see #addEdge(Object, Object, Object)
     */
	public boolean addEdge(E arg0, V arg1, V arg2, EdgeType arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
     * If directed_edge is a directed edge in this graph, returns the destination; 
     * otherwise returns null. 
     * The destination of a directed edge d is defined to be the vertex 
     * incident to d for which  
     * d is an incoming edge.
     * directed_edge is guaranteed to be a directed edge if 
     * its EdgeType is DIRECTED. 
     * @param directed_edge
     * @return  the destination of directed_edge if it is a directed edge in this graph, or null otherwise
     */
	public V getDest(E arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
     * Returns the endpoints of edge as a Pair<V>.
     * @param edge the edge whose endpoints are to be returned
     * @return the endpoints (incident vertices) of edge
     */
	public Pair<V> getEndpoints(E arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
     * Returns a Collection view of the incoming edges incident to vertex
     * in this graph.
     * @param vertex    the vertex whose incoming edges are to be returned
     * @return  a Collection view of the incoming edges incident 
     * to vertex in this graph
     */
	public Collection<E> getInEdges(V arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 /**
     * Returns the vertex at the other end of edge from vertex.
     * (That is, returns the vertex incident to edge which is not vertex.)
     * @param vertex the vertex to be queried
     * @param edge the edge to be queried
     * @return the vertex at the other end of edge from vertex
     */
	public V getOpposite(V arg0, E arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
     * Returns a Collection view of the outgoing edges incident to vertex
     * in this graph.
     * @param vertex    the vertex whose outgoing edges are to be returned
     * @return  a Collection view of the outgoing edges incident 
     * to vertex in this graph
     */
	public Collection<E> getOutEdges(V arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 /**
     * Returns the number of predecessors that vertex has in this graph.
     * Equivalent to vertex.getPredecessors().size().
     * @param vertex the vertex whose predecessor count is to be returned
     * @return  the number of predecessors that vertex has in this graph
     */
	public int getPredecessorCount(V arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	 /**
     * Returns a Collection view of the predecessors of vertex 
     * in this graph.  A predecessor of vertex is defined as a vertex v 
     * which is connected to 
     * vertex by an edge e, where e is an outgoing edge of 
     * v and an incoming edge of vertex.
     * @param vertex    the vertex whose predecessors are to be returned
     * @return  a Collection view of the predecessors of 
     * vertex in this graph
     */
	public Collection<V> getPredecessors(V arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 /**
     * If directed_edge is a directed edge in this graph, returns the source; 
     * otherwise returns null. 
     * The source of a directed edge d is defined to be the vertex for which  
     * d is an outgoing edge.
     * directed_edge is guaranteed to be a directed edge if 
     * its EdgeType is DIRECTED. 
     * @param directed_edge
     * @return  the source of directed_edge if it is a directed edge in this graph, or null otherwise
     */
	public V getSource(E arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 /**
     * Returns the number of successors that vertex has in this graph.
     * Equivalent to vertex.getSuccessors().size().
     * @param vertex the vertex whose successor count is to be returned
     * @return  the number of successors that vertex has in this graph
     */
	public int getSuccessorCount(V arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
     * Returns a Collection view of the successors of vertex 
     * in this graph.  A successor of vertex is defined as a vertex v 
     * which is connected to 
     * vertex by an edge e, where e is an incoming edge of 
     * v and an outgoing edge of vertex.
     * @param vertex    the vertex whose successors are to be returned
     * @return  a Collection view of the successors of 
     * vertex in this graph
     */
	public Collection<V> getSuccessors(V arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	 /**
     * Returns the number of incoming edges incident to vertex.
     * Equivalent to getInEdges(vertex).size().
     * @param vertex    the vertex whose indegree is to be calculated
     * @return  the number of incoming edges incident to vertex
     */
    public int inDegree(V vertex) {
		return getInEdges(vertex).size();
	}

	@Override
	  /**
     * Returns true if vertex is the destination of edge.
     * Equivalent to getDest(edge).equals(vertex).
     * @param vertex the vertex to be queried
     * @param edge the edge to be queried
     * @return true iff vertex is the destination of edge
     */
	public boolean isDest(V arg0, E arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
     * Returns true if v1 is a predecessor of v2 in this graph.
     * Equivalent to v1.getPredecessors().contains(v2).
     * @param v1 the first vertex to be queried
     * @param v2 the second vertex to be queried
     * @return true if v1 is a predecessor of v2, and false otherwise.
     */
	 public boolean isPredecessor(V v1, V v2) {
		return this.getPredecessors(v1).contains(v2);
	}

	 /**
     * Returns true if vertex is the source of edge.
     * Equivalent to getSource(edge).equals(vertex).
     * @param vertex the vertex to be queried
     * @param edge the edge to be queried
     * @return true iff vertex is the source of edge
     */
    public boolean isSource(V vertex, E edge) {
		return getSource(edge).equals(vertex);
	}

	@Override
	  /**
     * Returns true if v1 is a successor of v2 in this graph.
     * Equivalent to v1.getSuccessors().contains(v2).
     * @param v1 the first vertex to be queried
     * @param v2 the second vertex to be queried
     * @return true if v1 is a successor of v2, and false otherwise.
     */
    public boolean isSuccessor(V v1, V v2) {
		return this.getSuccessors(v1).contains(v2);
	}

	@Override
	/**
     * Returns the number of outgoing edges incident to vertex.
     * Equivalent to getOutEdges(vertex).size().
     * @param vertex    the vertex whose outdegree is to be calculated
     * @return  the number of outgoing edges incident to vertex
     */
    public int outDegree(V vertex) {
		return getOutEdges(vertex).size();
	}

	@Override
	  /**
     * Adds edge to this graph.
     * Fails under the following circumstances:
     * <ul>
     * <li/>edge is already an element of the graph 
     * <li/>either edge or vertices is null
     * <li/>vertices has the wrong number of vertices for the graph type
     * <li/>vertices are already connected by another edge in this graph,
     * and this graph does not accept parallel edges
     * </ul>
     * 
     * @param edge
     * @param vertices
     * @return true if the add is successful, and false otherwise
     * @throws IllegalArgumentException if edge or vertices is null, 
     * or if a different vertex set in this graph is already connected by edge, 
     * or if vertices are not a legal vertex set for edge 
     */
	public boolean addEdge(E arg0, Collection<? extends V> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	  /**
     * Adds edge to this graph with type edge_type.
     * Fails under the following circumstances:
     * <ul>
     * <li/>edge is already an element of the graph 
     * <li/>either edge or vertices is null
     * <li/>vertices has the wrong number of vertices for the graph type
     * <li/>vertices are already connected by another edge in this graph,
     * and this graph does not accept parallel edges
     * <li/>edge_type is not legal for this graph
     * </ul>
     * 
     * @param edge
     * @param vertices
     * @return true if the add is successful, and false otherwise
     * @throws IllegalArgumentException if edge or vertices is null, 
     * or if a different vertex set in this graph is already connected by edge, 
     * or if vertices are not a legal vertex set for edge 
     */
	public boolean addEdge(E arg0, Collection<? extends V> arg1, EdgeType arg2) {
		// TODO Auto-generated method stub
		return false;
	}

}
