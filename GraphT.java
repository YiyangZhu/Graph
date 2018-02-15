import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

class GraphT{
    List<Node> allNodes;
    Map<String, Node> m;
    int time;
    LinkedList<Node> l = new LinkedList<>();
    List<Node> roots = new ArrayList<>();
    
    GraphT(String[] s1, String[] s2){
        allNodes = new ArrayList<>();
        m = new HashMap<>();
        for(String s: s1){
            Node n = new Node(s);
            allNodes.add(n);
            m.put(s,n);
        }
        for(String s: s2){
            String[] edges = s.split(" ");
            m.get(edges[0]).outgoings.add(m.get(edges[1]));
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
        u.dt = time;
        u.color = "gray";
        for(Node v: u.outgoings){
            if(v.color == "white"){
                v.pi = u;
                dfsVisit(v);
            }
        }
        time++;
        u.ft = time;
        l.addFirst(u);
        u.color = "black";
    }
    
    void displayTime(){
        for(Node n: allNodes){
            System.out.println(n.key+" discover time is: "+n.dt+", finish time is: "+n.ft);
        }
    }
    
    LinkedList topologicalSort(){
        dfs();
        return l;
    }
    
    void displayTopologicalSort(){
        for(Node n: l){
            System.out.print(n.key+" -> ");
            n.displayOutgoings();
            System.out.println("\t\tdiscover time:"+n.dt+"\tfinish time:"+n.ft);
            
        }
    }
    
    void stronglyConnectedComponents(){
        dfs();
        transpose2();
        
        for(Node n: l){
            n.color = "white";
            n.pi = null;
        }
        time = 0;
        for(Node n: l){
            if(n.color == "white"){
                roots.add(n);
                dfsVisit2(n);
            }
        }
    }
    
    void dfsVisit2(Node u){
        time++;
        u.dt = time;
        u.color = "gray";
        for(Node v: u.newOutgoings){
            if(v.color == "white"){
                v.pi = u;
                dfsVisit2(v);
            }
        }
        time++;
        u.ft = time;
        u.color = "black";
    }
    
    void transpose2(){
        for(Node n: l){
            for(Node j: n.outgoings){
                j.newOutgoings.add(n);
            }
        }
    }
    
    void displaySCC(){
        for(Node n: roots){
            for(Node n2: l){
                if(n2.dt > n.dt && n2.ft < n.ft){
                    n.stronglyCC.add(n2);
                }
            }
        }
        for(Node n: roots){
            System.out.print("Tree root is: \""+n.key+"\" discover time: "+n.dt+" finish time:"+n.ft);
            for(Node n2: n.stronglyCC){
                System.out.print("     \""+n2.key+"\" discover time: "+n2.dt+" finish time:"+n2.ft);
            }
            System.out.println();
        }
    }
}