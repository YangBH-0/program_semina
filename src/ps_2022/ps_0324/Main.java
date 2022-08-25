package ps_2022.ps_0324;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        ArrayList<Integer> dist= new ArrayList<>();
        int temp=0;
        for(int x:rocks){
            dist.add(x-temp);
            temp=x;
        }
        dist.add(distance-temp);

        return dp(dist,n);
    }
    public static int dp(ArrayList<Integer> arr, int n){
        if(n==0){
            return Collections.min(arr);
        }
        ArrayList<Integer> index= new ArrayList<>();
        int min = Collections.min(arr);
        for(int i=0;i<arr.size();i++){
            if(min==arr.get(i))
                index.add(i);
        }
        int t=0; // 최적 인덱스 위치
        int t2=0; // 합칠 인덱스 위치
        int min_sum=Integer.MAX_VALUE; // 최소 값
        for(int x:index){
            int left=Integer.MAX_VALUE;
            int right=Integer.MAX_VALUE;
            //System.out.println(arr);
            //System.out.println(index);
            if(x>1){
                left=arr.get(x-1)+arr.get(x);
            }
            if(x<arr.size()-1){
                right=arr.get(x)+arr.get(x+1);
            }
            if(left < right){
                if(min_sum>left){
                    min_sum=left;
                    t=x;
                    t2=x-1;
                }
            }else{
                if(min_sum>right){
                    min_sum=right;
                    t=x;
                    t2=x+1;
                }
            }
            //System.out.println(left+", "+right);
        }
        // 합치기
        int temp= arr.get(t);
        arr.remove(t);
        if(t>t2){
            arr.set(t2,arr.get(t2)+temp);
        }else{
            arr.set(t,arr.get(t)+temp);
        }
        //System.out.println(arr);
        int answer=dp(arr,n-1);
        return answer;
    }

    public static void main(String[] args) {
        // 4
        int dist=25;
        int[] rocks={2,14,11,21,17};
        int n=2;
        // 3
        int[] rocks2 = {3,6,9,10,14,17};
        // 9
        int dist2=18;
        int[] rocks3 = {2,8,9,10,11,12,13};
        int n2=6;
        System.out.println(solution(dist2,rocks3,n2));
    }
}
