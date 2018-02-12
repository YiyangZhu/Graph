import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Graph{
    List<Node> allNodes;
    Map<String, Node> m;
    
    Graph(String[] s1, String[] s2){
        allNodes = new ArrayList<>();
        m = new HashMap<>();
        for(String s: s1){
            Node n = new Node(s);
            allNodes.add(n);
            m.put(s,n);
        }
        for(String s: s2){
            m.get(s.substring(0,1)).outgoings.add(m.get(s.substring(1,2)));
        }
    }
    
    void display(){
        for(Node n: allNodes){
            System.out.print(n.key+" -> ");
            n.displayOutgoings();
            System.out.println();
        }
    }
    
    void transpose(){
        for(Node n: allNodes){
            for(Node j: n.outgoings){
                j.outgoings.add(n);
            }  
            n.outgoings.clear();
        }
    }
}