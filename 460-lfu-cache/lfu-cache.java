class LFUCache {
    HashMap<Integer,Node> keyNode=new HashMap<>();
    HashMap<Integer, List> freqListMap=new HashMap<>();
    int maxSizeCache;
    int minFreq;
    int curSize;

    class Node {
    int key, value, cnt;
    Node next;
    Node prev;
    
    Node(int _key, int _value) {
        key = _key;
        value = _value;
        cnt = 1;
        }
    }
    class List {
    int size; // Size 
    Node head; // Dummy head
    Node tail; // Dummy tail
    
    List() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
        size++;
    }
    
    void removeNode(Node delnode) {
        Node prevNode = delnode.prev;
        Node nextNode = delnode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
        }
    }
    
    public LFUCache(int capacity) {
        maxSizeCache = capacity;
        minFreq = 0;
        curSize = 0;
    }
    
    public int get(int key) {
        if(!keyNode.containsKey(key)) return -1;
        Node node = keyNode.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
       if (maxSizeCache == 0) return;

       if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreq(node);
        }

        else {

            if (curSize == maxSizeCache) {
                List minFreqList = freqListMap.get(minFreq);
                Node nodeToRemove = minFreqList.tail.prev;
                minFreqList.removeNode(nodeToRemove);
                keyNode.remove(nodeToRemove.key);
                curSize--;
            }

            curSize++;
            minFreq = 1;

            Node newNode = new Node(key, value);
            List list = freqListMap.getOrDefault(1, new List());
            list.addFront(newNode);
            freqListMap.put(1, list);
            keyNode.put(key, newNode);
        }
    }

    private void updateFreq(Node node) {
        int freq = node.cnt;
        List oldList = freqListMap.get(freq);
        oldList.removeNode(node);

        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.cnt++;

        List newList = freqListMap.getOrDefault(node.cnt, new List());
        newList.addFront(node);
        freqListMap.put(node.cnt, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */