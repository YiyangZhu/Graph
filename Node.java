import java.util.List;
import java.util.ArrayList;

class Node{
    String key;
    Node next;
    Node previous;
    String color;
    int d;
    Node pi;
    List<Node> outgoings = new ArrayList<>();
    
    Node(String k){
        key = k;
    }
    
    void displayOutgoings(){
        for(Node n: outgoings){
            System.out.print(n.key+" -> ");
        }
    }
}