package Hashing;
// Java implementation of the above approach
import java.util.*;

class BottomViewOfBT {

	// Tree node class
	static class Node {

		// data of the node
		int data;

		// horizontal distance of the node
		int hd;

		// left and right references
		Node left, right;

		// Constructor of tree node
		Node(int key) {
			data = key;
			hd = Integer.MAX_VALUE;
			left = right = null;
		}
	}

	static class pair {
		Node first;
		int second;

		pair(Node f, int s) {
			first = f;
			second = s;
		}
	}

	static void printBottomView(Node root) {
		if (root == null)
			return; // if root is NULL
		HashMap<Integer, Integer> hash = new HashMap<>(); // <vertical_index ,
		// root->data>
		int leftmost = 0; // to store the leftmost index so
		// that we move from left to right
		Queue<pair> q = new ArrayDeque<>(); // pair<Node*,vertical
		// Index> for level order
		// traversal.

		q.add(new pair(
				root, 0)); // push the root and 0 vertial index
		while (!q.isEmpty()) {
			pair top = q.peek(); // store q.front() in top
			// variable
			q.remove();
			Node temp = top.first; // store the Node in temp for
			// left and right nodes
			int ind = top.second; // store the vertical
			// index of current node
			hash.put(ind,
					temp.data); // store the latest
			// vertical_index(key) ->
			// root->data(value)
			leftmost = Math.min(
					ind, leftmost); // have the leftmost
			// vertical index
			if (temp.left != null) {
				q.add(new pair(temp.left, ind - 1));
			} // check if any node of left then go in
				// negative direction
			if (temp.right != null) {
				q.add(new pair(temp.right, ind + 1));
			} // check if any node of left then go in
				// positive direction
		}
		// Traverse each value in hash from leftmost to
		// positive side till key is available
		while (hash.containsKey(leftmost)) {
			System.out.print(
					hash.getOrDefault(leftmost++, 0) + " ");
		}
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		System.out.println(
				"Bottom view of the given binary tree :");
		printBottomView(root);
	}
}
