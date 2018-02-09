class LinkedList{
    Node head;
    
    void addFirst(Node n){
        head = n;
    }
    
    void insert(Node n){
        if(head == null){
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = n;
        n.previous = current;
    }
    
    void display(){
        Node current = head;
        while(current != null){
            System.out.print(current.key);
            current = current.next;
            if(current != null){
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}