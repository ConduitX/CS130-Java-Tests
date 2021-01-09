package edu.csus.csc130.fall2020.assignment2;

/**
 * Modified by: Jahsuni Jones
 *
 */
public class MergeList {
	/**
	 * 
	 * Given the heads of two sorted list, the method returns the head of the merged list
	 * @param node1 head of the first sorted list
	 * @param node2 head of the second sorted list
	 * @return head of the merged list
	 * 
	 * Runtime requirement: O(n) in worst case
	 * Space requirement: O(1) in worst case
	 * 
	 * Refer to this link for Comparable interface, https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Comparable.html
	 * 
	 */
   public <T extends Comparable<T>> ListNode<T> merge(ListNode<T> node1, ListNode<T> node2) {
   	// to be implemented
      ListNode<T> n1 = node1;
      ListNode<T> n2 = node2;
      ListNode<T> temp = new  ListNode<T>(null);
      
      boolean stop = false;
     
      if (endCheck(n1, n2) != 0) {
    	  
      }

      while (stop == false)
      {   	  
          //check for the end of list and return
          if (endCheck(n1, n2) == 1)
          {
             temp.next = n2;
             stop = true;
          }
          
          else if (endCheck(n1, n2) == 2)
          {
             temp.next = n1;
             stop = true;
          }
       
          else if (endCheck(n1, n2) == 3)
          {
             stop = true;
          }
          else {
         	 stop = false;
          }    	  
      //comparing the lead values of n1 and n2
         if (n1.value.compareTo(n2.value) >= 0)
         {
            temp.next = n1;
            n1 = n1.next;
         }
         else
         {
            temp.next = n2;
            n2 = n2.next;
         }
      
      }
    
      return temp;
   }



   public int endCheck(ListNode node1, ListNode node2) {
	      //check for the end of list and return
       if (node1.next == null)
       {
          return 1;
       }
       
       else if (node2.next == null)
       {
          return 2;
       }
    
       else if (node1.next == null && node2.next == null)
       {
          return 3;
       }
       else {
    	   return 0;
       }
       
   }

}