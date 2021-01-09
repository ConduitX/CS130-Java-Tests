package edu.csus.csc130.fall2020.assignment3;

public class BST <Key extends Comparable<Key>> {
	private Node root;
	
	public class Node {
		Key key; // key
		Node left, right; // links to subtrees
		int n; // # nodes in subtree rooted here

		public Node(Key key, int n) {
			this.key = key;
			this.n = n;
		}
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void put(Key key) {
		root = put(root, key);
	}
	
	private Node put(Node node, Key key) {
		if (node == null)
			return new Node(key, 1);

		int cmp = key.compareTo(node.key);
		if (cmp < 0)
			node.left = put(node.left, key);
		else if (cmp > 0)
			node.right = put(node.right, key);

		node.n = size(node.left) + size(node.right) + 1;

		return node;
	}
	
	private int size(Node node) {
		if (node==null) {
			return 0;
		} else {
			return node.n;
		}
	}
}
