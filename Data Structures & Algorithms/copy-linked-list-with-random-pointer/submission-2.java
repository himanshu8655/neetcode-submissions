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
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }

        for(Map.Entry<Node, Node> entry : map.entrySet()){
            Node og = entry.getKey();
            Node val = entry.getValue();
            val.next = map.get(og.next);
            val.random = map.get(og.random);
        }
        return map.get(head);
    }
}
