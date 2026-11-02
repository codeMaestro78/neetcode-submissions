class LRUCache {
    private class Node{
        int key;
        int value;
        Node next;
        Node prev;


        Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer,Node> map;

    private final Node head;
    private final Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();


        head = new Node (0,0);
        tail = new Node (0,0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node){
        node.prev.next= node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void moveAtHead(Node node){
        remove(node);
        insertAtHead(node);
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        moveAtHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveAtHead(node);
            return;
        }

        // create new non-sealed
        Node node = new Node(key , value);
        map.put(key,node);
        insertAtHead(node);


        if(map.size() > capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
