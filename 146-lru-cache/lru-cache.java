class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int _key, int _val) {
            key = _key;
            val = _val;
        }
    }
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node=map.get(key);
        deleteNode(node);
        addNode(node);
        return node.val;
    }

    void deleteNode(Node delNode) {
        Node delPrev = delNode.prev;
        Node delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }
    
    void addNode(Node newNode) {
        Node temp = head.next;
        newNode.next = temp;
        newNode.prev = head;
        head.next = newNode;
        temp.prev = newNode;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            deleteNode(node);
            addNode(node);
        }
        else{
            if(map.size()==cap){
                Node node=tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node=new Node(key,value);
            map.put(key,node);
            addNode(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */