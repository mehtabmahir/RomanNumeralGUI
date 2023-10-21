/**
 * Node class for the tree
 */
public class Node {
	RomanNumeral roman;
	Node left, right;
	
	public Node() {
		roman = new RomanNumeral();
	} // no parameter constructor
	public Node(RomanNumeral input) {
		roman = input;
	} // constructor
}
