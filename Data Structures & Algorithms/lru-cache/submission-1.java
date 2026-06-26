class LRUCache {

    class Node{
        Node prev;
        Node next;
        int val;
        Node(int val){
            this.val = val;
        }  
    }
    HashMap<Integer, Node> nodeMap;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        int val = node.val;
        remove(node);
        Node newNode = new Node(val);
        nodeMap.put(key, newNode);
        add(newNode);
        return val;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node = null;
    }
    
    public void add(Node node){
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        tail.prev = node;
        node.next = tail;
    }

    public void put(int key, int value) {
        if(nodeMap.containsKey(key))
            nodeMap.remove(key);
        
        Node newNode = new Node(value);
        nodeMap.put(key, newNode);
        add(newNode);
        return;
    }
}
