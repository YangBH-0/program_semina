package ps_2022.ps_0609;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main01 {
    static final int max_n = 20001;

    public static int solution(int n, int[][] edge) {
        int len_n = n + 1;
        int answer = 0;
        boolean[][] edges = new boolean[len_n][len_n];
        boolean[] checker = new boolean[len_n];
        for (int[] e1 : edge) {
            int a = e1[0];
            int b = e1[1];
            edges[a][b] = true;
            edges[b][a] = true;
        }
        int start = 1;

        Queue<Integer> queue;
        Queue<Integer> next_queue = new LinkedList<>();
        next_queue.add(start);
        checker[start] = true;

        while (!next_queue.isEmpty()) {
            queue = next_queue;
            answer = queue.size();
            next_queue = new LinkedList<>();
            for (int index : queue) {
                boolean[] e = edges[index];
                for (int i = 1; i < edges.length; i++) {
                    if (e[i] && !checker[i]) { // 간선이 있고 아직 안 갔으면
                        next_queue.add(i);
                        checker[i] = true;
                    }

                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int vertex[][] = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };
        // result = 3
        System.out.println(solution(n, vertex));

    }
}
