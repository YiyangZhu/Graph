import java.util.LinkedList;

class K_MST{
    static Vertex[] verts;
    static Edge[] edges;
    static LinkedList<Edge> mST;
    static int minTotalWeight;
    
    static class Edge{
        Vertex start;
        Vertex end;
        int weight;
        Edge(Vertex start, Vertex end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    
    static class Vertex{
        char data;
        LinkedList<Edge> connectedEdges;
        Vertex root;
        
        Vertex(char data){
            this.data = data;
            connectedEdges = new LinkedList<Edge>();
        }
    }
    
    K_MST(Vertex[] verts, Edge[] edges){
        int vLen = verts.length;
        int eLen = edges.length;
        for(int i = 0; i < vLen; i++){
            for(int j = 0; j < eLen; j++){
                if(verts[i]== edges[j].start){
                    verts[i].connectedEdges.add(edges[j]);
                }
            }
        }
    }
    
    static void sortEdges(){
        for(int i = 0; i < edges.length-1; i++){
            for(int j = 0; j < edges.length-1-i; j++){
                if(edges[j].weight > edges[j+1].weight){
                    Edge temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }
  
    static void kruskal(){
        mST = new LinkedList<Edge>();
        for(int i = 0; i < edges.length; i++){
            if(edges[i].end.root != null && edges[i].start.root != null && (getRoot(edges[i].start) == getRoot(edges[i].end))){
                continue;  //start and end are not empty and have same root, continue
            }
            mST.add(edges[i]); //if start and end do not have same root, add this edge to MST
            minTotalWeight += edges[i].weight;
            if(edges[i].end.root == null && edges[i].start.root == null){ //start and end do not have roots
                char up = Character.toUpperCase(edges[i].start.data);
                edges[i].start.root = new Vertex(up);
                edges[i].end.root = getRoot(edges[i].start);
            } else if(edges[i].end.root == null) {
                edges[i].end.root = getRoot(edges[i].start);
            } else if(edges[i].start.root == null){
                edges[i].start.root = getRoot(edges[i].end);
            } else {
                getRoot(edges[i].start).root = getRoot(edges[i].end); //connected two separate trees
            }
        }
    }
    
    static void displayRoot(){
        for(Vertex e: verts){
            if(e.root == null){
                System.out.println("vert "+e.data+" no root");
            }else{
                System.out.println("vert "+e.data+" root:"+e.root.data);
            }
        }
    }
    
    static Vertex getRoot(Vertex start){
        Vertex r = start;
        while(r.root != null){
            r = r. root;
        }
        return r;
    }
    
    static void displayMST(){
        for(Edge e:mST){
            System.out.println(e.start.data+" "+e.end.data+" weight:"+e.weight);
        }
        System.out.println("The minimum total weight is: "+minTotalWeight);
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
        K_MST k = new K_MST(verts, edges);
        sortEdges();
        kruskal();
        displayMST();
    }
}