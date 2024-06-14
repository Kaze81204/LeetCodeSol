package Java;
/* 21. Merge Two Sorted Lists
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The 
list should be made by splicing together the nodes 
of the first two lists.

Return the head of the merged linked list.

Example: Input: list1 = [1,2,4], list2 = [1,3,4]
         Output: [1.1.2.3.4.4]

Approach:
    Just comparing the two values from list1 and list2, then
    take the small value and create a new list.
    Dummy pointer always point to the head node as a next node

    Time Complexity: O(m + n)
                    m is length of list1 and n is length of list2
    Space Complexity: O(1)
 
 */




import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LC21 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){ this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(list1 != null && list2 != null){
            if (list1.val > list2.val){
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        
        cur.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
    public static void main(String[] args){
        LC21 solution = new LC21();

        ListNode list1 = solution.new ListNode(1);
        list1.next = solution.new ListNode(2);
        list1.next.next = solution.new ListNode(4);

        ListNode list2 = solution.new ListNode(1);
        list2.next = solution.new ListNode(3);
        list2.next.next = solution.new ListNode(4);

        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
