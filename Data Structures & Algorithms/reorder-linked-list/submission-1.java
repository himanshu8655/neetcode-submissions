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
        if(head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = slow.next;
        slow.next = null;
        ListNode list1 = head;
        ListNode list2 = reverseNode(rev);
        while(list1!=null && list2!=null){
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;

            list1.next = list2;
            list2.next = temp1;
            list1 = temp1;
            list2 = temp2;

        }
    }

    public ListNode reverseNode(ListNode node){
            ListNode res = null;
            while(node!=null){
                ListNode temp = node.next;
                node.next = res;
                res = node;
                node = temp;
            }

            return res;
        }
}
