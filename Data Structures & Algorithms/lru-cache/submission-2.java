class LRUCache {
    private final Map<Integer, Node> map = new HashMap<>();
    private final int capacity;
    private final Node head = new Node(0, 0);   // dummy, head.next is the LRU node
    private final Node tail = new Node(0, 0);   // dummy, tail.prev is the most recent

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToEnd(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        unlink(node);
        addToEnd(node);          // now the most recently used
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            unlink(node);
            addToEnd(node);
            return;
        }
        if (map.size() == capacity) {
            Node lru = head.next;    // least recently used
            unlink(lru);
            map.remove(lru.key);     // this is why Node stores its key
        }
        Node fresh = new Node(value, key);
        map.put(key, fresh);
        addToEnd(fresh);
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node prev;

    Node(int val, int key) { this.val = val; this.key = key; }
}