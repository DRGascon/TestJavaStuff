package dgascon;


import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {

	public class Node {
		public Node(Integer id) {
			i_id = id;
			i_active = true;
			i_connectedNodes = new LinkedList<Integer>();
		}
		List<Integer> i_connectedNodes;
		Boolean i_active;
		Integer i_id;
		
	}
	public void setupGrid(int dimension) {
		i_nodes = new LinkedList<Node>();
		i_gridDimension = dimension;
		
		// Handle two easy cases specifically
		if ( dimension == 0 ) {
			return; // That was easy
		}
		if ( dimension == 1 ) {
			i_nodes.set(0, new Node(0));
		}
		// Now it's time to get serious
		else {
			for ( int row = 0; row < dimension; row++) {
				for ( int col = 0; col < dimension; col++) {
					Boolean nodeAbove = (row > 0);
					Boolean nodeBelow = ( (row + 1) *dimension < dimension * dimension);
					Boolean nodeRight = (col < dimension);
					Boolean nodeLeft = (col > 0);
					int nodeID = row * i_gridDimension + col;
					
					Node newNode = new Node(nodeID);
					if ( nodeAbove) {
						newNode.i_connectedNodes.add(nodeID - dimension);
					}
					if ( nodeBelow) {
						newNode.i_connectedNodes.add(nodeID + dimension);
					}
					if ( nodeRight ) {
						newNode.i_connectedNodes.add(nodeID + 1);
					}
					if ( nodeLeft) {
						newNode.i_connectedNodes.add(nodeID - 1);
					}
					i_nodes.add(nodeID, newNode);
				}
			}
		}
	}
	
	public Boolean areNodesConnected(int firstNodeId, int secondNodeId) {
		Boolean connected = false;
		List<Integer> visitedNodes = new LinkedList<Integer>();

		// Make sure these nodes exist
		if ( firstNodeId < i_gridDimension*i_gridDimension && secondNodeId < i_gridDimension*i_gridDimension ) {
			Node firstNode = i_nodes.get(firstNodeId);
			Node secondNode = i_nodes.get(secondNodeId);
			if ( secondNode.i_active ) {
				connected = findConnection(visitedNodes, firstNode, secondNodeId);
			}
			else {
				// The target node isn't active, we can't form a path to it
				connected = false;
			}
		}
		return connected;
	}
	
	private Boolean findConnection (List<Integer> visitedNodes, Node currentNode, int targetNodeId) {
		List <Integer> connectedActiveNodes = new LinkedList<Integer>();
		for ( int connectedNode : currentNode.i_connectedNodes ) {
			if (i_nodes.get(connectedNode).i_active && !visitedNodes.contains(connectedNode)) {
				connectedActiveNodes.add(connectedNode);
			}
		}
		visitedNodes.add(currentNode.i_id);
		
		// Hey look, we're connected to our second node! Hurrah!
		if (connectedActiveNodes.contains(targetNodeId)) {
			return true;
		}
		else if ( connectedActiveNodes.size() > 0) {
			for ( Integer activeNode : connectedActiveNodes) {
				return findConnection(visitedNodes, i_nodes.get(activeNode), targetNodeId);
			}
		}
		return false;
	}
	
	public String toString() {
		String outString = new String("");
		for (int row = 0; row < i_gridDimension; row++) {
			for (int col = 0; col < i_gridDimension; col++) {
				int nodeID = row * i_gridDimension + col;
				outString += i_nodes.get(nodeID).i_active ? "T " : "F ";
			}
			outString += "\n";
		}
		return outString;
	}
	
	public void toggleValue(int row, int col) {
		if ( row < i_gridDimension && col < i_gridDimension ) {
			int nodeID = row * i_gridDimension + col;
			Node foundNode = i_nodes.get(nodeID);
			foundNode.i_active = !foundNode.i_active;
			for ( int currentId : foundNode.i_connectedNodes) {
				Node currentNode = i_nodes.get(currentId);
				currentNode.i_active = !(currentNode.i_active);
			}
		}
	}
	
	public void setRowActive(int row, Boolean active) {
		for ( int col = 0; col < i_gridDimension; col++ ) {
			int nodeId = row * i_gridDimension + col;
			i_nodes.get(nodeId).i_active = active;
		}
	}
	
	public void setColActive(int col, Boolean active) {
		for ( int row = 0; row < i_gridDimension; row++ ) {
			int nodeId = row * i_gridDimension + col;
			i_nodes.get(nodeId).i_active = active;
		}
	}
	List<Node> i_nodes;
	int i_gridDimension;
}


