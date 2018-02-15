class Solution22_4_1{
    public static void main(String[] args){
        String[] s1 = {"m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] s2 = {"m q","m r","m x","q t","u t","n q","n u","r u","r y","o r",
        "o s","y v","v w","s r","p s","p z","v w","w z"};
        GraphT g = new GraphT(s1, s2);
        g.topologicalSort();
        g.displayTopologicalSort();
    }
}