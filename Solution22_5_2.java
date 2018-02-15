class Solution22_5_2{
    public static void main(String[] args){
        String[] s1 = {"q","r","s","t","u","v","w","x","y","z"};
        String[] s2 = {"q s","q t","q w","r u","r y","s v","t x",
            "t y","u y","v w","w s","x z","y q","z x"};
        GraphT g = new GraphT(s1, s2);
        g.stronglyConnectedComponents();
        g.displaySCC();
    }
}