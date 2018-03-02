import java.util.ArrayList;

class DijkstraDemo{
    static Vertex[] verts;
    static Edge[] edges;
    final static int INFI = 65535;
    static ArrayList<Vertex> vertsSet = new ArrayList<Vertex>();
    static ArrayList<Vertex> Q = new ArrayList<Vertex>();
    

    static class Vertex{
        char data;
        ArrayList<Edge> connectedEdges = new ArrayList<Edge>();
        boolean inSet;
        int d;
        Vertex pi;
        Vertex(){}
        Vertex(char data){
            this.data = data;
        }
    }
   
    static class Edge{
        Vertex start;
        Vertex end;
        int weight;
        Edge(Vertex s, Vertex e, int w){
            this.start = s;
            this.end = e;
            this.weight =w;
        }
    }
    
    static void display(){
        for(Vertex v: verts){
            System.out.print(v.data+"\t");
            for(Edge e: v.connectedEdges){
                System.out.print(e.start.data+" "+e.end.data+" "+e.weight+"\t");
            }
            System.out.println();
        }
    }
    
    DijkstraDemo(Vertex[] verts, Edge[] edges){
        int vLen = verts.length;
        int eLen = edges.length;
        for(int i = 0; i < vLen; i++){
            Q.add(verts[i]);
            for(int j = 0; j < eLen; j++){
                if(verts[i] == edges[j].start){
                    verts[i].connectedEdges.add(edges[j]);
                }
            }
        }
    }
    
    static void displayQ(){
        System.out.print("\nQ contains:");
        for(Vertex v: Q){
            System.out.print(v.data+" ");
        }
    }
    
    static void displayVertsSet(){
        System.out.print("\nvertsSet contains:");
        for(Vertex v: vertsSet){
            System.out.print(v.data+" ");
        }
    }
    
    static void displayDistance(){
        System.out.print("\nDistances are as follows:");
        for(Vertex v: vertsSet){
            System.out.print(v.data+".d="+v.d+" ");
        }
    }
    
    static void dijkstra(Vertex s){
        for(Vertex v: verts){
            v.d = INFI;
            v.pi = null;
        }
        s.d = 0;
        vertsSet.add(s);
        s.inSet = true;
        Q.remove(s);
        int i = 0;
        while(!Q.isEmpty()){
            Vertex u = new Vertex();
            u.d = INFI;
            Vertex v = new Vertex();
            for(Vertex vertex: vertsSet){
                v = getMinVertex(vertex);
                if(u.d > v.d){
                    u = v;
                }
            }
            vertsSet.add(u);
            u.inSet = true;
            Q.remove(u);
            for(Vertex vertex: vertsSet){
                for(Edge e: v.connectedEdges){
                    if(e.start.inSet && e.end.inSet){
                        relax(v,vertex,e.weight);
                    }
                }
            }
        }
    }
    
    static Vertex getMinVertex(Vertex v){
        Vertex v1 = new Vertex();
        v1.d = INFI;
        for(Edge edge: v.connectedEdges){
            if(edge.end.inSet){
                continue;
            }
            relax(v,edge.end,edge.weight);
            if(edge.end.d < v1.d){
                v1 = edge.end;
            }
        }
        return v1;
    }
    
    static void relax(Vertex u, Vertex v, int w){
        if(v.d > u.d + w){
            v.d = u.d + w;
            v.pi = u;
        }
    }
    
    public static void main(String[] args){
        Vertex s = new Vertex('s');
        Vertex t = new Vertex('t');
        Vertex x = new Vertex('x');
        Vertex y = new Vertex('y');
        Vertex z = new Vertex('z');
        verts = new Vertex[]{s,t,x,y,z};
        edges = new Edge[]{new Edge(s, t, 10), new Edge(s, y, 5), 
            new Edge(t, x, 1), new Edge(t, y, 2), new Edge(x, z, 4), 
            new Edge(y, t, 3), new Edge(y, x, 9), new Edge(y, z, 2), 
            new Edge(z, s, 7), new Edge(z, x, 6)};
        DijkstraDemo d = new DijkstraDemo(verts, edges);
        display();
        dijkstra(s);
        displayQ();
        displayVertsSet();
        displayDistance();
    }   
}