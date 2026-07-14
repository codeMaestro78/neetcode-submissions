class LinkedList {
    int val;
    LinkedList next;

    LinkedList head;
    public LinkedList(int val) {
        this.val = val;
        this.next = null;
    }

    public LinkedList() {
        this.head =null;
    }

    public int get(int index) {
     if (index < 0) return -1;

     LinkedList curr =head;
     int i =0;
        while(curr!=null){
            if(i==index) return curr.val;
            curr=curr.next;
            i++;
        }
        return -1;

    }

    public void insertHead(int val) {
        LinkedList newNode = new LinkedList(val);
        newNode.next = head;
        head = newNode;

    }

    public void insertTail(int val) {
        LinkedList newNode = new LinkedList(val);
        if(head ==null){
            head = newNode;
            return;

        }
        LinkedList curr = head;
        while(curr.next!=null){
            curr=curr.next;

        }
        curr.next=newNode;

    }

    public boolean remove(int index) {
        if(index < 0 || head ==null) return false;

        if(index ==0){
            head = head.next;
            return true;
        }
        LinkedList curr = head;
        for(int i=0;i<index-1;i++){
            if(curr.next==null) return false;
            curr= curr.next;

        }
        if (curr.next == null) return false;

        curr.next = curr.next.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
ArrayList<Integer> list = new ArrayList<>();
        LinkedList curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }
}
