package ps_2022.ps_0721;

public class Main_01 {
    public static void fill_map(int[][] map, int pos1,int pos2, int width, int height,int color){
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                map[pos1+i][pos2+j]=color;
            }
        }
    }
    public static void print_map(int[][] map){
        StringBuilder sb= new StringBuilder();
        int width_max=20;
        int height_max=20;
        for(int i=0;i<width_max;i++){
            sb.append("[");
            for(int j=0;j<height_max;j++){
                sb.append(map[i][j]+",");
            }
            sb.delete(sb.length()-1,sb.length());
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        int number=3;
        int square_max=100;
        int width_max=1001;
        int height_max=1001;
        int[][][] map=new int[number][width_max][height_max];
        int[][] count=new int[number][square_max];
        int[] n={
                2,
                3,
                4
        };
        int[][][] squares ={// {[왼쪽아래 좌표],(너비),(높이)}
                {
                        {0,0,10,10},
                        {2,2,6,6}
                },
                {
                        {0,2,10,10},
                        {7,9,8,4},
                        {8,4,10,6}
                },
                {
                        {0,2,10,10},
                        {7,9,8,4},
                        {8,4,10,6},
                        {6,0,12,10}
                },
        };
        int max=3;
        for(int i=0;i<max;i++){
            System.out.println((i+1)+"번째 문제");
            for(int j=0;j<squares[i].length;j++){
                fill_map(map[i],squares[i][j][0],squares[i][j][1],squares[i][j][2],squares[i][j][3],j+1);
            }
            for(int x=0;x<map[0].length;x++){
                for(int y=0;y<map[0][0].length;y++){
                    count[i][map[i][x][y]]++;
                }
            }
            for(int j=0;j<squares[i].length;j++){
                System.out.println(count[i][j+1]);
            }
            print_map(map[i]);
        }
    }
}
