class Solution24_1_1{
    static Vertex[] verts;
    static Edge[] edges;
    final static int INFI = 65535;

    static class Vertex{
        char data;
        int d;
        Vertex pi;
        Vertex(char c){
            this.data = c;
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
            System.out.print(v.data+" ");
        }
        System.out.println();
        for(Edge e: edges){
            System.out.println(e.start.data+" "+e.end.data+" "+e.weight);
        }
    }
    
    static boolean bellman_Ford(Vertex s){
        for(Vertex v: verts){
            v.d = INFI;
            v.pi = null;
        }
        s.d = 0;
        for(int i = 0; i < verts.length - 1; i++){
            for(Edge e: edges){
                //System.out.println("before relax: "+e.start.data+".d="+e.start.d+" "+e.end.data+".d="+e.end.d+" weight:"+e.weight+"\t");
                relax(e.start, e.end, e.weight);
                System.out.println("after relax: "+e.start.data+".d="+e.start.d+" "+e.end.data+".d="+e.end.d);
                displayPi(e.end);
            }
        }
        for(Edge e: edges){
            if(e.end.d > (e.start.d + e.weight)){    
                return false;
            }
        }
        return true;
    }
    
    static void displayPi(Vertex v){
        if(v.pi == null){
            System.out.println(v.data+" does not have pi");
        } else {
            System.out.println(v.data+".pi="+v.pi.data);
        }
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
        //edges = new Edge[]{new Edge(s, t, 6), new Edge(s, y, 7), 
            //new Edge(t, x, 5), new Edge(t, z, -4), new Edge(t, y, 7), 
            //new Edge(x, t, -2),  new Edge(y, x, -3), new Edge(y, z, 9), 
            //new Edge(z, s, 2), new Edge(z, x, 7)};
        edges = new Edge[]{new Edge(s, t, 6), new Edge(s, y, 7), 
            new Edge(t, x, 5), new Edge(t, z, -4), new Edge(t, y, 7), 
            new Edge(x, t, -2),  new Edge(y, x, -3), new Edge(y, z, 9), 
            new Edge(z, s, 2), new Edge(z, x, 4)};
        display();
        System.out.println(bellman_Ford(s));

    }                         
}