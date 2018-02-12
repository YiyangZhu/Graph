class Solution22_3_2{
    public static void main(String[] args){
        String[] s1 = {"q","r","s","t","u","v","w","x","y","z"};
        String[] s2 = {"qs","qt","qw","ru","ry","sv","tx","ty","uy","vw","ws","xz","yq","zx"};
        System.out.println(s2.length);
        Graph g = new Graph(s1, s2);
        g.dfs();
        System.out.println();
        g.displayTime();
    }
}