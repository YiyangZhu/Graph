class AdjacencyMatrix{
    int[][] m;
    
    AdjacencyMatrix(String[] s1, String[] s2){
        int n = s1.length;
        m = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < s2.length; j++){
                if(s2[j].substring(0,1).equals(s1[i])){
                    for(int k = 0; k < n; k++){
                        if(s1[k].equals(s2[j].substring(1,2)))
                        m[i][k] = 1;
                    }
                }
            }
        }
    }
    
    void display(){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
    
    int[][] transpose(int[][] x){
        int n = x.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = x[j][i];
            }
        }
        return result;
    }
}