/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node dup_node = new Node(head.val);
        Node dup_head = dup_node;
        HashMap<Node, Node> hmp = new HashMap<>();
        hmp.put(head, dup_node);
        Node temp = head.next;
        while(temp!=null){
            Node node = new Node(temp.val);
            dup_node.next = node;
            hmp.put(temp, node);
            dup_node = node;
            temp = temp.next;
        }
        dup_node = dup_head;
        while(head!=null){
            Node curr_dup_node = hmp.get((head));
            Node random_dup_node = hmp.get((head.random));
            curr_dup_node.random = random_dup_node;
            head = head.next;
        }
        return dup_head;
    }
}
