class AdjacencyList{
    LinkedList[] l;
    
    AdjacencyList(String[] s1, String[] s2){
        int n = s1.length;
        l = new LinkedList[n];
        for(int i = 0; i < n; i++){
            l[i] = new LinkedList();
        }
        for(int i = 0; i < n; i++){
            l[i].addFirst(new Node(s1[i]));
            for(int j = 0; j < s2.length; j++){
                if(s1[i].equals(s2[j].substring(0,1))){
                    l[i].insert(new Node(s2[j].substring(1,2)));
                }
            }
        }
    }
    
    void display(){
        for(LinkedList each: l){
            each.display();
        }
    }
    
    void BFS(){
        
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