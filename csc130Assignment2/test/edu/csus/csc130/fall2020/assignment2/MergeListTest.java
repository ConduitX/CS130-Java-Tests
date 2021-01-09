package edu.csus.csc130.fall2020.assignment2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeListTest {
   private MergeList uut = new MergeList();

   @Test
   void testMerge_1() {
      Integer[] a1 = {1, 3};
      Integer[] a2 = {2, 4, 6};
      Integer[] expected = {1, 2, 3, 4, 6};
      ListNode<Integer> node1 = getList(a1);
      ListNode<Integer> node2 = getList(a2);
      ListNode<Integer> result = uut.merge(node1, node2);
   	
      int i = 0;
      ListNode<Integer> node = result;
      while (node!=null) {
         assertEquals(expected[i], node.value);
         node = node.next;
         i++;
      }
      assertEquals(expected.length, i);
   }
	
   @Test
   void testMerge_2() {
      Integer[] a1 = {1, 3, 5};
      Integer[] a2 = {12, 14};
      Integer[] expected = {1, 3, 5, 12, 14};
      ListNode<Integer> node1 = getList(a1);
      ListNode<Integer> node2 = getList(a2);
      ListNode<Integer> result = uut.merge(node1, node2);
   	
      int i = 0;
      ListNode<Integer> node = result;
      while (node!=null) {
         assertEquals(expected[i], node.value);
         node = node.next;
         i++;
      }
      assertEquals(expected.length, i);
   }	
	
   @Test
   void testMerge_3() {
      String[] a1 = {"edit", "file", "source"};
      String[] a2 = {"apple", "banana", "orange"};
      String[] expected = {"apple", "banana", "edit", "file", "orange", "source"};
      ListNode<String> node1 = getList(a1);
      ListNode<String> node2 = getList(a2);
      ListNode<String> result = uut.merge(node1, node2);
   	
      int i = 0;
      ListNode<String> node = result;
      while (node!=null) {
         assertEquals(expected[i], node.value);
         node = node.next;
         i++;
      }
      assertEquals(expected.length, i);
   }
	
   @Test
   void testMerge_4() {
      Character[] a1 = {'x'};
      Character[] a2 = {'z'};
      Character[] expected = {'x', 'z'};
      ListNode<Character> node1 = getList(a1);
      ListNode<Character> node2 = getList(a2);
      ListNode<Character> result = uut.merge(node1, node2);
   	
      int i = 0;
      ListNode<Character> node = result;
      while (node!=null) {
         assertEquals(expected[i], node.value);
         node = node.next;
         i++;
      }
      assertEquals(expected.length, i);
   }	
	
   private <T extends Comparable<T>> ListNode<T> getList(T[] a) {
      ListNode<T> dummyHead = new ListNode<T>(null);
      ListNode<T> tail = dummyHead;
      for (T e: a) {
         tail.next = new ListNode<T>(e);
         tail = tail.next;
      }
   	
      return dummyHead.next;
   }

}
