package ps_2022.ps_0825;

public class main_01 {
    public static long factorial(int n){
        if(n<=1) {
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int calculate(int val1, int val2){
        int temp_1 = val1+val2;
        int temp_2 = val1;
        int temp_3 = val2;
        return (int) (factorial(temp_1)/(factorial(temp_2)*factorial(temp_3)));
    }
    public static int solution(int n,int m, int k){
        if(k == 0){
            n-=1;
            m-=1;
            return calculate(n,m);
        }

        k-=1;
        int midpoint_col = k%m;
        int midpoint_row = k/m;

        int destination_col = m-1;
        int destination_row = n-1;

        int temp_col=destination_col-midpoint_col;
        int temp_row=destination_row-midpoint_row;
        return calculate(midpoint_col,midpoint_row)* calculate(temp_row,temp_col);
    }
    public static void main(String[] args) {
        int[][] input ={
                {3,5,8},
                {7,11,0},
                {7,11,76}
        };
        for(int[] arr: input){
            int val1=arr[0];
            int val2=arr[1];
            int val3=arr[2];
            System.out.println(solution(val1,val2,val3));
        }

    }
}
