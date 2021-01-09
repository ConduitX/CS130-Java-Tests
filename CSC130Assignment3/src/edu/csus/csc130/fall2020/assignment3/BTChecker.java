package edu.csus.csc130.fall2020.assignment3;

public class BTChecker {
	/**
	 * This method checks whether the given binary tree is balanced.  
	 * A binary tree is balanced if and only if for each node
	 * 1) its left subtree is balanced
	 * 2) its right subtree is balanced
	 * 3) the height difference between left and right subtree is at most lg(n)
	 * 
	 * @param root the root of a binary tree
	 * @return true is the tree is balanced otherwise false
	 */

// Modified by Jahsuni Jones

	public boolean isBalanced(BST.Node root) {
		// delete the following statement and add your implementation
		
		//check if root is null and if it has two children nodes
		if (root == null) {
			return true;
		}
		else if ((root.left == null && root.right != null) 
				|| (root.left != null && root.right == null)) {
			return false;
		}
		
		
		//findHeight method for both sides
		int leftHeight = 0;
		leftHeight = findHeight(root.left, leftHeight);
		//System.out.println(leftHeight);
		
		int rightHeight = 0;
		rightHeight = findHeight(root.right, rightHeight);
		//System.out.println(rightHeight);

		//compare the two heights
		if (leftHeight == rightHeight) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public int findHeight(BST.Node node, int count) {
		//traverse list until the end and return height
		if (node == null) {
			return count;
		}
		else {
		count++;
		return findHeight(node.left, count);
		}
	}

}
