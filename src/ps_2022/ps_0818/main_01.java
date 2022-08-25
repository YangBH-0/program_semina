package ps_2022.ps_0818;

import java.util.PriorityQueue;

public class main_01 {
    public static int solution(int[] s, int k) {
        int answer = 0;
        PriorityQueue<Integer> scovile = new PriorityQueue<>();// 오름차순
        for (int i : s) {
            scovile.add(i);
        }
        while(scovile.peek()<k){
            if(scovile.size()<=1) return -1;
            int n1 = scovile.poll();
            int n2 = scovile.poll();
            scovile.add(n1 + (n2 * 2));
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] scoville = {1,12,10,3,9,2,12};
        int k =7;
        System.out.println(solution(scoville,k));

    }
}
