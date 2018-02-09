class AdjacencyList{
    LinkedList[] l;
    
    AdjacencyList(int n){
        l = new LinkedList[n];
        for(int i = 0; i < n; i++){
            l[i] = new LinkedList();
        }
    }
    
    void display(){
        for(LinkedList each: l){
            each.display();
        }
    }
    
    LinkedList[] transpose(LinkedList[] list){
        int n = list.length;
        LinkedList[] result = new LinkedList[n];
        for(int i = 0; i < n; i++){
            result[i] = new LinkedList();
        }
        for(int i = 0; i < n; i++){
            result[i].addFirst(new Node(list[i].head.key));
        }
        for(int i = 0; i < n; i++){
            Node current = list[i].head;
            while(current.next != null){
                for(int k = 0; k < n; k++){
                    if(result[k].head.key.equals(current.next.key)){
                        result[k].insert(new Node(list[i].head.key));
                        break;
                    }
                }
                current = current.next;
            }
        }
        return result;
    }
}