import java.util.LinkedList;

class Prim_MST{
    static Vertex[] verts;
    static Edge[] edges;
    static LinkedList<Edge> mST;
    static LinkedList<Vertex> vertsMST = new LinkedList<Vertex>();
    static int minTotalWeight;
    
    static class Edge{
        Vertex start;
        Vertex end;
        int weight;
        Edge(){}
        Edge(Vertex start, Vertex end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    
    static class Vertex{
        char data;
        LinkedList<Edge> connectedEdges;
        boolean inMST;
        Vertex(){
            connectedEdges = new LinkedList<Edge>();
        }
        Vertex(char data){
            this.data = data;
            connectedEdges = new LinkedList<Edge>();
        }
    }
    
    Prim_MST(Vertex[] verts, Edge[] edges){
        int vLen = verts.length;
        int eLen = edges.length;
        for(int i = 0; i < vLen; i++){
            for(int j = 0; j < eLen; j++){
                if(verts[i] == edges[j].start){
                    verts[i].connectedEdges.add(edges[j]);
                }
                if(verts[i] == edges[j].end){
                    verts[i].connectedEdges.add(edges[j]);
                }
            }
        }
    }
    
    static void prim(){
        mST = new LinkedList<>();
        vertsMST.add(verts[0]);
        verts[0].inMST = true;
        for(int i = 0; i < verts.length-1; i++){
            Edge minEdgePrim = new Edge(new Vertex('X'),new Vertex('Y'),88888);
            for(Vertex v: vertsMST){
                Edge edge = getMinEdge(v);
                if(minEdgePrim.weight > edge.weight){
                    minEdgePrim = edge;
                }
            }
            mST.add(minEdgePrim);
            minTotalWeight += minEdgePrim.weight;
            if(vertsMST.contains(minEdgePrim.end)){                           
                vertsMST.add(minEdgePrim.start);  // MST contains start
                minEdgePrim.start.inMST = true;
            } else {
                vertsMST.add(minEdgePrim.end);  //MST contains end
                minEdgePrim.end.inMST= true;
            }
        }
    }
    
    static Edge getMinEdge(Vertex v){
        Edge minEdge = new Edge(new Vertex('x'),new Vertex('y'),65535);
        for(Edge edge: v.connectedEdges){
            if(edge.start.inMST && edge.end.inMST){
                continue;
            }
            if(minEdge.weight > edge.weight){
                minEdge = edge;
            }
        }
        return minEdge;
    }
    
    static void displayMST(){
        System.out.print("\nThe MST is: ");
        for(Edge e:mST){
            System.out.print("\n"+e.start.data+" "+e.end.data+" weight:"+e.weight);
        }
        System.out.println("\nThe minimum total weight is: "+minTotalWeight);
    }
    
    public static void main(String[] args) {
        Vertex a = new Vertex('a');
        Vertex b = new Vertex('b');
        Vertex c = new Vertex('c');
        Vertex d = new Vertex('d');
        Vertex e = new Vertex('e');
        Vertex f = new Vertex('f');
        Vertex g = new Vertex('g');
        Vertex h = new Vertex('h');
        Vertex i = new Vertex('i');
        verts = new Vertex[]{a,b,c,d,e,f,g,h,i};
        edges = new Edge[]{new Edge(a, b, 4), new Edge(a, h, 8), 
            new Edge(b, c, 8), new Edge(b, h, 11), new Edge(c, d, 7), 
            new Edge(c, f, 4),  new Edge(c, i, 2), new Edge(d, e, 9), 
            new Edge(d, f, 14), new Edge(e, f, 10), new Edge(f, g, 2), 
            new Edge(g, h, 1), new Edge(g, i, 6), new Edge(h, i, 7)};
        Prim_MST k = new Prim_MST(verts, edges);
        prim();
        displayMST();
    }
}