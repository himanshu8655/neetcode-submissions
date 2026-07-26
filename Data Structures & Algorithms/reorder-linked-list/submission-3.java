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

        ListNode node1 = head;
        ListNode node2 = reverse(slow.next);
        System.out.println(node2.val);
        ListNode res = node1;
        slow.next = null;
        while(node1!=null && node2!=null){
            ListNode next1 = node1.next;
            ListNode next2 = node2.next;
            node1.next = node2;
            node2.next = next1;
            node1 = next1;
            node2 = next2;
        }
    }

    public ListNode reverse(ListNode head){
        ListNode node = null;
        while(head!=null){
            ListNode nextNode = head.next;
            head.next = node;
            node = head;
            head = nextNode;
        }
        return node;
    }
}
