import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

class Graph{
    List<Node> allNodes;
    Map<String, Node> m;
    int time;
    
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
                j.newOutgoings.add(n);
            }
        }
    }
    
    void displayTranspose(){
        for(Node n: allNodes){
            System.out.print(n.key+" -> ");
            n.displayNewOutgoings();
            System.out.println();
        }
    }
    
    void bfs(String str){
        Node s = m.get(str);
        for(Node n: allNodes){
            n.color = "white";
            n.d = 10000;
            n.pi = null;
        }
        s.color = "gray";
        s.d = 0;
        Queue q = new Queue();
        q.enqueue(s);
        while(!q.isEmpty()){
            Node u = q.dequeue();
            for(Node v: u.outgoings){
                if(v.color == "white"){
                    v.color = "gray";
                    v.d = u.d + 1;
                    v.pi = u;
                    q.enqueue(v);
                }
            }
            u.color = "black";
            //q.display();
        }
    }
    
    void displayPredecessor(){
        for(Node n: allNodes){
            if(n.pi == null){
                System.out.println(n.key+" does not have predecessor!");
            } else {
                System.out.println(n.key+"'s predecessor is: "+n.pi.key);
            }
        }
    }
    
    void displayDistance(){
        for(Node n: allNodes){    
            System.out.println(n.key+"'s distance is: "+n.d);
        }
    }
    
    void printPath(String str, String ver){
        Node s = m.get(str);
        Node v = m.get(ver);
        if(v == s){
            System.out.print(s.key+" - ");
        } else if(v.pi == null){
            System.out.print("No path from "+str+" to "+ver+" exists.");
            return;
        } else {
            printPath(str,v.pi.key);
            System.out.print(v.key+" - ");
        }
    }
    
    void dfs(){
        for(Node n: allNodes){
            n.color = "white";
            n.pi = null;
        }
        time = 0;
        for(Node n: allNodes){
            if(n.color == "white"){
                dfsVisit(n);
            }
        }
    }
    
    void dfsVisit(Node u){
        time++;
        u.color = "gray";
        u.dt = time;
        for(Node v: u.outgoings){
            if(v.color == "white"){
                v.pi = u;
                dfsVisit(v);
            }
        }
        time++;
        u.color = "black";
        u.ft = time;
    }
    
    void displayTime(){
        for(Node n: allNodes){
            System.out.println(n.key+" discover time is: "+n.dt+", finish time is: "+n.ft);
        }
    }
}