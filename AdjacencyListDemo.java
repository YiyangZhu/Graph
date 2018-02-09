class AdjacencyListDemo{
    public static void main(String[] args){
        String[] s1 = {"A","B","C","D","E","F","G"};
        String[] s2 = {"AB","BD","AC","BE","CF","CG",};
        DirectedGraph dG = new DirectedGraph(s1,s2);
        int n = dG.vertices.size();
        AdjacencyList a = new AdjacencyList(n);
        for(int i = 0; i < n; i++){
            a.l[i].addFirst(new Node(s1[i]));
            for(int j = 0; j < s2.length; j++){
                if(s1[i].equals(s2[j].substring(0,1))){
                    a.l[i].insert(new Node(s2[j].substring(1,2)));
                }
            }
        }
        a.display();
        System.out.println("After transpose: ");
        for(LinkedList each: a.transpose(a.l)){
            each.display();
        }
    }
}