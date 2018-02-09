class AdjacencyMatrixDemo{
    public static void main(String[] args){
        String[] s1 = {"A","B","C","D","E","F","G"};
        String[] s2 = {"AB","BD","AC","BE","CF","CG"};
        DirectedGraph dG = new DirectedGraph(s1,s2);
        int n = dG.vertices.size();
        AdjacencyMatrix a = new AdjacencyMatrix(s1, s2);
        a.display();
        int[][] r = a.transpose(a.m);
        for(int i = 0; i < r.length; i++){
            for(int j = 0; j < r.length; j++){
                System.out.print(r[i][j]);
            }
            System.out.println();
        }
    }
}