package programmers.codingtest;

import java.util.Collections;
import java.util.PriorityQueue;

public class heap {
    public static int ScovileSolution(int[] s, int k) {
        int answer = 0;
        PriorityQueue<Integer> scovile=new PriorityQueue<>();
        for(int i:s){
            scovile.add(i);
        }
        while(scovile.size()>3){
            if(scovile.peek()<k){
                int n1 = scovile.poll();
                int n2 = scovile.poll();
                int n3 = scovile.poll();
                if(n2<n3){
                    scovile.add(n1+(n2*2));
                    scovile.add(n3);
                }else{
                    scovile.add(n1+(n3*2));
                    scovile.add(n2);
                }
                answer++;
            }else{
                return answer;
            }
        }
        if(scovile.peek()<k){
            int n1 = scovile.poll();
            int n2 = scovile.poll();
            scovile.add(n1+(n2*2));
        }else{
            return answer;
        }
        if(scovile.peek()<k){
            return -1;
        }else {
            return answer+1;
        }
    }

    public static void main(String[] args) {
        int[] data={1,2,3,9,10,12};
        System.out.println(ScovileSolution(data,7));
    }
}
