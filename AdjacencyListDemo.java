class AdjacencyListDemo{
    public static void main(String[] args){
        String[] s1 = {"A","B","C","D","E","F","G"};
        String[] s2 = {"AB","BD","AC","BE","CF","CG"};
        Graph g = new Graph(s1, s2);
        g.display();
        g.transpose();
        g.display();
    }
}