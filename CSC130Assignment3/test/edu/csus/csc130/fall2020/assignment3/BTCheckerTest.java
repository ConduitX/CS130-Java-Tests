package edu.csus.csc130.fall2020.assignment3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BTCheckerTest {
	BTChecker uut = new BTChecker();

	@Test
	void testIsBalanced_1() {
		assertTrue(uut.isBalanced(null));
	}
	
	@Test
	void testIsBalanced_2() {
		char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'H'};
		BST<Character> bst = new BST<Character>();
		for (char c: a) {
			bst.put(c);
		}
		assertFalse(uut.isBalanced(bst.getRoot()));
	}
	
	@Test
	void testIsBalanced_3() {
		char[] a = {'D', 'B', 'H', 'A', 'C', 'E', 'I'};
		BST<Character> bst = new BST<Character>();
		for (char c: a) {
			bst.put(c);
		}
		assertTrue(uut.isBalanced(bst.getRoot()));
	}	
	
}
