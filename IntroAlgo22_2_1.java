class IntroAlgo22_2_1{
    public static void main(String[] args){
        String[] s1 = {"1","2","3","4","5","6"};
        String[] s2 = {"12","14","25","35","36","42","54","66"};
        Graph g = new Graph(s1, s2);
        g.bfs("3");
        g.displayPredecessor();
        g.displayDistance();
    }
}
    