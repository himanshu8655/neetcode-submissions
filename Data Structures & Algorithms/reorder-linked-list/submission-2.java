/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode node1 = head; //2  4 6
        ListNode node2 = reverse(slow.next);//10 8
        slow.next = null;
        while(node1!=null && node2!=null){
            ListNode temp1 = node1.next;
            ListNode temp2 = node2.next;
            node1.next = node2;
            node2.next = temp1;
            node1 = temp1;
            node2 = temp2;
        }
    }

    ListNode reverse(ListNode head){
        ListNode result = null;

        while(head!=null){
            ListNode temp = head.next;
            head.next = result;
            result = head;
            head = temp;
        }
        return result;
    }
}
