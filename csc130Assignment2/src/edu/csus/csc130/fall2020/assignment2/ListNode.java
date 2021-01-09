package edu.csus.csc130.fall2020.assignment2;

public class ListNode<T extends Comparable<T>> {
   T value;
   ListNode<T> next;
	
   public ListNode(T value) {
      this.value = value;
      this.next = null;
   }
}