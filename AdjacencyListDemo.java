class AdjacencyListDemo{
    public static void main(String[] args){
        String[] s1 = {"A","B","C","D","E","F","G"};
        String[] s2 = {"AB","BD","AC","BE","CF","CG",};
        DirectedGraph dG = new DirectedGraph(s1,s2);
        int n = dG.vertices.size();
        AdjacencyList a = new AdjacencyList(s1,s2);
        a.display();
        System.out.println("After transpose: ");
        for(LinkedList each: a.transpose(a.l)){
            each.display();
        }
    }
}