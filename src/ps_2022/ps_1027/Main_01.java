package ps_2022.ps_1027;

public class Main_01 {
    public static int solution(int[] info, int[][] edges) {
        int answer = 0;
        boolean[][] b_edges= new boolean[info.length][info.length];
        for(int[] edge:edges){
            b_edges[edge[0]][edge[1]]=true;
        }
        int[] data = new int[3]; // {sheep,wolf,answer}
        data[0]=1;
        data[2]=0;

        return  dfs(info,b_edges,new boolean[info.length],0,data)[2];
    }
    public static int[] dfs(int[] info, boolean[][] edges,boolean[] check,int node,int[] data){
        check[node]=true;
        if(data[0]>data[1]){
            data[2]=data[0];
        }else{
            check[node]=false;
            return new int[3];
        }
        System.out.println(node);
        System.out.printf("data %d,%d,%d\n" ,data[0],data[1],data[2]);

        for(int i=0;i<info.length;i++){
            if(edges[node][i]){
                int[] temp = new int[3];
                copyArr(data,temp);
                if(!check[i]) {
                    if (info[i] == 0) {
                        temp[0]++;
                    } else {
                        temp[1]++;
                    }
                }
                int[] result=new int[3];
                copyArr(dfs(info,edges,check,i,temp),result);
                if(data[2]<result[2]){
                   copyArr(result,data);
                }

            }
        }
        System.out.println("phaze2");
        for(int i=0;i<info.length;i++){
            if(edges[node][i]){
                int[] temp = new int[3];
                copyArr(data,temp);
                if(!check[i]) {
                    if (info[i] == 0) {
                        temp[0]++;
                    } else {
                        temp[1]++;
                    }
                }
                int[] result=new int[3];
                copyArr(dfs(info,edges,check,i,temp),result);
                if(data[2]<result[2]){
                    copyArr(result,data);
                }

            }
        }
        return data;
    }
    public static void copyArr(int[] a, int[] b){
        for(int j=0;j<3;j++){
            b[j]=a[j];
        }
    }

    public static void main(String[] args) {
        int[][] infos={
                {0,0,1,1,1,0,1,0,1,0,1,1},
                {0,1,0,1,1,0,1,0,0,1,0}
        };
        int[][][] edges={
                {
                    {0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}
                },
                {
                    {0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}
                }
        };
        int n=2;
        for(int i=0;i<n;i++){
            System.out.println("ddd"+i);
            System.out.println(solution(infos[i],edges[i]));
        }
    }

}
