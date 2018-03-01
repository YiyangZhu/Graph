import java.util.ArrayList;
import java.util.LinkedList;

class DAGShortestPathDemo{
    static int time;
    static Vertex[] verts;
    static Edge[] edges;
    static LinkedList<Vertex> l = new LinkedList<Vertex>();
    final static int INFI = 65535;
    
    static class Vertex{
        String color;
        Vertex pi;
        char data;
        int d;
        int f;
        int distance;
        ArrayList<Edge> connectedEdges = new ArrayList<>();
        Vertex(char c){
            this.data = c;
        }
    }
    
    static class Edge{
        Vertex start;
        Vertex end;
        int weight;
        Edge(Vertex s, Vertex e){
            this.start = s;
            this.end = e;
        }
        Edge(Vertex s, Vertex e,int w){
            this.start = s;
            this.end = e;
            this.weight = w;
        }
    }
    
    DAGShortestPathDemo(){
        for(Vertex v: verts){
            for(Edge e: edges){
                if(e.start == v){
                    v.connectedEdges.add(e);
                }
            }
        }
    }
    
    static void display(){
        for(Vertex v: verts){
            System.out.print(v.data+"\t");
        }
        System.out.println();
        for(Edge e: edges){
            System.out.print(e.start.data+" "+e.end.data+"\t");
        }
        System.out.println();
    }
    
    static void displayConnectedEdges(){
        for(Vertex v: verts){
            System.out.print(v.data+"\t");
            for(Edge e: v.connectedEdges){
                System.out.print(e.start.data+" "+e.end.data+" "+e.weight+"\t");
            }
            System.out.println();
        }
    }
    
    static void dFS(){
        for(Vertex u: verts){
            u.color = "white";
            u.pi = null;
        }
        time = 0;
        for(Vertex u: verts){
            if(u.color.equals("white")){
                dFS_Visit(u);
            }
        }
    }
    
    static void dFS_Visit(Vertex u){
        time++;
        u.d = time;
        u.color = "gray";
        for(Edge e: u.connectedEdges){
            Vertex v;
            if(e.start == u){
                v = e.end;
            } else {
                v = e.start;
            }
            if(v.color.equals("white")){
                v.pi = u;
                dFS_Visit(v);
            }
        }
        u.color = "black";
        time++;
        u.f = time;
        l.addFirst(u);
    }
    
    static void displayTime(){
        for(Vertex v: verts){
            System.out.println(v.data+": start:"+v.d+" end:"+v.f);
        }
    }
    
    static LinkedList<Vertex> topologicalSort(){
        dFS();
        return l;
        
    }
    
    static void displayTopoSort(){
        for(Vertex v: l){
            System.out.println(v.data+" finish time:"+v.f);
        }
    }
    
    static void dAGShortestPath(Vertex s){
        topologicalSort();
        for(Vertex v: l){
            v.distance = INFI;
            v.pi = null;
        }
        s.distance = 0;
        for(Vertex u: l){
            for(Edge e: u.connectedEdges){
                Vertex v;
                if(e.start == u){
                    v = e.end;
                    System.out.println(u.data+" "+v.data+" Before relax:"+v.data+" "+v.distance);
                    relax(u,v,e.weight);
                    System.out.println(u.data+" "+v.data+" After relax:"+v.data+" "+v.distance);
                }
                
            }
        }
    }
    
    static void relax(Vertex u, Vertex v, int w){
        if(v.distance > u.distance + w){
            v.distance = u.distance + w;
            v.pi = u;
            System.out.println(u.data+" "+v.data+"During relax:"+v.data+" "+v.distance);
        }
    }
    
    static void displayDistance(){
        for(Vertex v: l){
            System.out.println(v.data+".d="+v.distance);
        }
    }
    
    public static void main(String[] args){
//        Vertex u = new Vertex('u');
//        Vertex v = new Vertex('v');
//        Vertex w = new Vertex('w');
//        Vertex x = new Vertex('x');
//        Vertex y = new Vertex('y');
//        Vertex z = new Vertex('z');
//        verts = new Vertex[]{u,v,w,x,y,z};
//        edges = new Edge[]{new Edge(u, v), new Edge(u,x), 
//            new Edge(v,y), new Edge(w,y), new Edge(w,z), 
//            new Edge(x,v),  new Edge(y,x), new Edge(z,z)};
        Vertex r = new Vertex('r');
        Vertex s = new Vertex('s');
        Vertex t = new Vertex('t');
        Vertex x = new Vertex('x');
        Vertex y = new Vertex('y');
        Vertex z = new Vertex('z');
        verts = new Vertex[]{r,s,t,x,y,z};
        edges = new Edge[]{new Edge(r,s,5), new Edge(r,t,3), 
            new Edge(s,t,2), new Edge(s,x,6), new Edge(t,x,7), 
            new Edge(t,y,4),  new Edge(t,z,2), new Edge(x,y,-1),
            new Edge(x,z,1),  new Edge(y,z,-2)};
        DAGShortestPathDemo d = new DAGShortestPathDemo();
        display();
        displayConnectedEdges();
        dAGShortestPath(s);
        displayDistance();
    }     
}