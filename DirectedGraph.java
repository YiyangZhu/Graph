import java.util.ArrayList;

class DirectedGraph{
    ArrayList<String> vertices = new ArrayList<String>();
    ArrayList<String> edges = new ArrayList<String>();
    
    DirectedGraph(String[] s, String[] t){
        for(String x: s){
            vertices.add(x);
        }
        for(String y: t){
            edges.add(y);
        }
    }
    
    void insertVertex(String s){
        vertices.add(s);
    }
    
    void insertEdge(String s, String t){
        String s1 = s+t;
        edges.add(s1);
    }
        
}