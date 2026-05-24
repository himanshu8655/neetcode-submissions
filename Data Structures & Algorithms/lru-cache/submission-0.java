class LRUCache {

    class Node{
        int val;
        int key;
        Node next;
        Node prev;
        public Node(int val, int key){
            this.val = val;
            this.key = key;
        }
    }

    Node head;
    Node tail;
    int capacity;
    int size;
    HashMap<Integer, Node> hmp;
    public LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        hmp = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hmp.containsKey(key)){
            return -1;
        }
        //remove from linkedlist
        Node node = hmp.get(key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        //Add at tail
        Node tail_prev = tail.prev;
        tail_prev.next = node;
        node.prev = tail_prev;
        node.next = tail;
        tail.prev = node;
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hmp.containsKey(key)){
            get(key);
            tail.prev.val = value;
        }
        else{
            Node node = new Node(value, key);
            Node tail_prev = tail.prev;
            tail_prev.next = node;
            node.prev = tail_prev;
            node.next = tail;
            tail.prev = node;
            hmp.put(key, node);
            size++;
        if(size > capacity){
            node = head.next;
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            hmp.remove(node.key);
            }
        }
    }
}
