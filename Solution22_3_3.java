class Solution22_3_3{
    public static void main(String[] args){
        String[] s1 = {"u","v","w","x","y","z"};
        String[] s2 = {"uv","ux","vy","yx","xv","wy","wz","zz"};
        Graph g = new Graph(s1, s2);
        g.dfs();
    }
}