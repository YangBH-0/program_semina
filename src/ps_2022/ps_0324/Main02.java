package ps_2022.ps_0324;

import java.util.ArrayList;
import java.util.Arrays;

public class Main02 {
    public static int solution(int distance, int[] rocks, int n) {
        int answer=0;
        Arrays.sort(rocks);

        int left=0; // minimum
        int right=distance; // max distance
        int mid; // target gap

        while(left<=right){
            int last_offset=0; // current rock, init = 0(Starting point)
            int rocks_count=0; // remove rock numbers
            mid = (left+right)/2;
            for(int rock: rocks){
                if(mid > rock - last_offset){ // mid > gap
                    rocks_count++;
                }
                else{ // mid<= gap
                    last_offset=rock;
                }
            }
            // final rock
            if(mid > distance-last_offset){ // mid > gap
                rocks_count++;
            }
            // how to cut half <- core
            if(rocks_count<=n){ // target
                left = mid+1;
                answer = Integer.max(answer,mid);
            }else{ // over target
                right =mid-1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 4
        int dist=25;
        int[] rocks={2,14,11,21,17};
        int n=2;
        // 5
        int[] rocks2 = {3,5,7};
        // 9
        int dist2=19;
        int[] rocks3 = {2,8,9,10,11,12,13};
        int n2=6;
        //System.out.println(solution(10,rocks2,n2));
        System.out.println(solution(dist,rocks,2));
    }
}
