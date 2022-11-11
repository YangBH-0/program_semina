package ps_2022.ps_1110;

public class Main_02 {
    private static boolean[][] b_edges;
    private static int max;
    public static int solution(int[] info, int[][] edges) {
        int answer = 0;
        b_edges = new boolean[info.length][info.length];
        for(int i=0;i< edges.length;i++){
            b_edges[edges[i][0]][edges[i][1]]=true;
            //b_edges[edges[i][1]][edges[i][0]]=true;
        }
        max=0;
        dfs(info,0,0,0,new boolean[info.length]);
        return max;
    }
    public static void dfs(int[] info, int node, int sheep, int wolf, boolean[] check){
        if(info[node] == 0){
            //System.out.println("node num:"+node);
            sheep++;
        }
        if(info[node] == 1){
            wolf++;
        }
        if(sheep>wolf){
            if(max<sheep){
                System.out.println(node+": "+sheep+","+wolf);
                max=sheep;
            }
            for (int i = 0; i < info.length; i++) {
                if (b_edges[node][i]) {
                    check[i] = true;
                }
            }
            for(int i=0;i<info.length;i++) {
                if(check[i]){
                    boolean[] temp = new boolean[check.length];
                    copyArr(check,temp);
                    temp[i]=false;
                    dfs(info,i,sheep,wolf,temp);
                }
            }
        }

    }
    private static void copyArr(boolean[] a, boolean[] b){
        for (int i=0;i<a.length;i++){
            b[i]=a[i];
        }
    }

    public static void main(String[] args) {
        int[][] infos ={
                {0,0,1,1,1,0,1,0,1,0,1,1},
                {0,1,0,1,1,0,1,0,0,1,0}
        };
        int[][][] arr_edges={
                {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}},
                {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}
        };
        for(int i=0;i< infos.length;i++){
            System.out.println(solution(infos[i],arr_edges[i]));
        }

    }
}
