import java.util.ArrayList;
/**
 *  RomanNumeral tree
 */
public class RomanTree {
	private Node root;
	private int length;
	ArrayList<RomanNumeral> list;
	
	public RomanTree() {
		root = null;
	} // no parameter constructor
	/**
	 * returns int length
	 */
	public int length() {
		return length;
	}
	/**
	 * inserts a RomanNumeral into the tree from a String
	 */
	public void insert(String input) {
		try {
			root = insert (new RomanNumeral(input), root);
		}catch(RomanNumeralException e) { // checks for invalid RomanNumeral 
			System.out.println(e.getMessage());
			return;
		}
		length++;
	}
	/**
	 * recursive function to insert a RomanNumeral into the appropriate space in the tree
	 */
	private Node insert(RomanNumeral input, Node curr) {
		if (curr == null) // if tree is empty
			curr = new Node(input);
		else if (input.compareTo(curr.roman) < 0) // checks if input < root
			curr.left = insert(input, curr.left);
		else if (input.compareTo(curr.roman) > 0) // checks if input > root
			curr.right = insert(input, curr.right);
		return curr;
	}
	/**
	 * checks if tree contains input
	 */
	public boolean contains(String input) {
		return contains(input, root);
	}
	/**
	 * recursive function to check whether tree contains input roman numeral
	 */
	private boolean contains(String input, Node curr) {
		if (curr == null)
			return false;
		if (input == curr.roman.getRoman())
			return true;
		return contains(input, curr.left) || contains(input, curr.right);
	}
	/**
	 * returns the Node containing the minimum RomanNumeral
	 */
	public Node getMin() {
		if (root == null)
			return null;
		return getMin(root);
	}
	/**
	 * recursive function that gets the leftmost Node
	 */
	private Node getMin(Node curr) {
		if (curr.left == null) 
			return curr;
		return getMin(curr.left);
	}
	/**
	 *  returns a sorted ArrayList of RomanNumerals from the tree
	 */
	public ArrayList<RomanNumeral> inOrder() {
		list = new ArrayList<RomanNumeral>(); // instantiates the ArrayList
		return inOrder(root);
	}
	/**
	 * recursive function that returns an array list of sorted RomanNumerals
	 */
	private ArrayList<RomanNumeral> inOrder(Node curr) {
		if (curr == null) {
			return null;
		}
		inOrder(curr.left);
		list.add(curr.roman);
		inOrder(curr.right);
		return list;
	}
	/**
	 * standard preorderTransversal
	 */
	public void preoderTraversal() {
		preoderTraversal(root);
	}
	/**
	 * prints out the tree in the order it was inserted
	 */
    private void preoderTraversal(Node curr){
        if (curr != null){
            System.out.println(curr.roman);
            preoderTraversal(curr.left);
            preoderTraversal(curr.right);
        }
    }
}

