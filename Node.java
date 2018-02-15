import java.util.List;
import java.util.ArrayList;

class Node{
    String key;
    String color;
    int d;
    Node pi;
    List<Node> outgoings = new ArrayList<>();
    List<Node> newOutgoings = new ArrayList<>();
    int dt;
    int ft;
    
    Node(){
    }
    
    Node(String k){
        key = k;
    }
    
    void displayOutgoings(){
        for(Node n: outgoings){
            System.out.print(n.key+" -> ");
        }
    }
    
    void displayNewOutgoings(){
        for(Node n: newOutgoings){
            System.out.print(n.key+" -> ");
        }
    }
}