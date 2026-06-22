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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int carry = 0;
        while(l1!=null || l2!=null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int val = num1 + num2 + carry;
            int remainder = val%10;
            carry = val/10;
            ListNode newNode = new ListNode(remainder);
            result.next = newNode;
            result = result.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
            
        }
        return temp.next;
    }
}
