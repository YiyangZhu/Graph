class IntroAlgo22_2_2{
    public static void main(String[] args){
        String[] s1 = {"r","s","t","u","v","w","x","y"};
        String[] s2 = {"rv","rs","vr","sr","sw","ws","wt","tw",
        "wx","xw","tx","xt","tu","ut","ux","xu","xy","yx","uy","yu"};
        Graph g = new Graph(s1, s2);
        g.bfs("u");
        g.displayPredecessor();
        g.displayDistance();
    }
}
    