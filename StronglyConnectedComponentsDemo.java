class StronglyConnectedComponentsDemo{
    public static void main(String[] args){
        String[] s1 = {"c","g","f","h","d","b","e","a"};
        String[] s2 = {"a b","e a","b e","e f","b f","f g","g f","b c",
        "c d","d c","d h","h h","g h","c g"};
        GraphT g = new GraphT(s1, s2);
        g.stronglyConnectedComponents();
        g.displaySCC();
    }
}