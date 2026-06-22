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

    public ListNode reverseList(ListNode head) {

        ListNode result = null;

        while(head!=null){
            ListNode nextNode = head.next;
            head.next = result;
            result = head;
            head = nextNode;
        }
    return result;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        int carry = 0;
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        while(l1!=null || l2!=null){
            if(l1 == null || l2 == null){
                ListNode tempNode = l1 == null ? l2 : l1;
                int value = tempNode.val + carry;
                if(value>9){
                    ListNode newNode = new ListNode(value/10);
                    result.next = newNode;
                    carry = value%10;
                }
                else{
                    carry = 0;
                    ListNode newNode = new ListNode(value);
                    result.next = newNode;
                }
                if(l1 == null)
                    l2 = l2.next;
                else
                    l1 = l1.next;

                result = result.next;
            }
            else{
                int value = l1.val + l2.val + carry;
                if(value>9){
                    ListNode newNode = new ListNode(value/10);
                    result.next = newNode;
                    carry = value%10;
                }
                else{
                    carry = 0;
                    ListNode newNode = new ListNode(value);
                    result.next = newNode;
                    
                }
                l1 = l1.next;
                l2 = l2.next;
                result = result.next;
            }
        }
        if(carry!=0)
            result.next = new ListNode(carry);
        return temp.next;
    }
}
