class TopologicalSortDemo{
    public static void main(String[] args){
        String[] s1 = {"shirt","tie","jacket","belt","watch","undershorts","pants",
            "shoes","socks"};
        String[] s2 = {"shirt tie","tie jacket","shirt belt","belt jacket","undershorts pants",
            "pants belt","undershorts shoes","pants shoes","socks shoes"};
        GraphT g = new GraphT(s1, s2);
        g.topologicalSort();
        g.displayTopologicalSort();
    }
}
    