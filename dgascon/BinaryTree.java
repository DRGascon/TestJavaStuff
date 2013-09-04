package dgascon;


 
public class BinaryTree {

	public class Node {
		Node (int value) {
			this.value = value;
		}
		Node left = null;
		Node right = null;
		
		int value;
	}
	
	Node root = null;
	
	public void insert(int value){
		if ( root == null ) {
			root = new Node(value);
		}
		insert(root, value);
	}
	
	private void insert(Node currentNode, int value) {
		if ( value < currentNode.value ) {
			if ( currentNode.left == null ){
				currentNode.left = new Node(value);
			}
			else {
				insert(currentNode.left, value);
			}
		}
		else if ( value > currentNode.value ) {
			if ( currentNode.right == null) {
				currentNode.right = new Node(value);
			}
			else {
				insert (currentNode.left, value);
			}
		}
	}
	
	public String toString() {
		String treeString = new String();
		treeString = traverseAndPrint(root, treeString);
		return treeString;
	}
	
	private String traverseAndPrint(Node node, String output) {
		if ( node == null ) {
			return output;
		}
		output = traverseAndPrint(node.left, output);
		output += "Value : " + node.value + " ";
		output = traverseAndPrint(node.right, output);
		return output;
		
	}

}
