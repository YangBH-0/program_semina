package ps_2021.ps_20211202;


import java.util.ArrayList;

public class Main_01 {
    final static int max_n = 20001;

    public static int solution(int n, int c, int m[][]) { // 시뮬레이션
        int answer = 0; // 정답
        int wight = 0; // 적재된 용량
        ArrayList<int[]> box = new ArrayList<>(); // 적재된 박스
        sort(m); // 출발 마을 -> 도착 마을 올림차순
        int town = 1; // 현재 마을
        int index = 0; // 고를 박스 위치
        while (town <= n) { // 마을 수 만큼
            if (!box.isEmpty()) { // 적재된 박스가 비었는가
                int i = 0; //
                while (!box.isEmpty() && i < box.size()) { //
                    if (box.get(i)[1] == town) {
                        int box_w = box.get(i)[2];
                        wight -= box_w;
                        answer += box_w;
                        box.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            for (int i = index; i < m.length; i++) {
                if (m[i][0] != town) {
                    index = i;
                    break;
                }
                if (wight < c) {
                    if (wight + m[i][2] <= c) {
                        box.add(m[i]);
                        wight += m[i][2];
                    } else {
                        int[] mbox = m[i];
                        mbox[2] = c - wight;
                        box.add(mbox);
                        wight += mbox[2];
                    }
                } else {
                    index = i;
                    while (m[index][0] <= town) {
                        index++;
                    }
                    break;
                }
            }
            town++;
        }
        return answer;
    }

    public static int solution2(int n, int c, int m[][]) { // 그리드 2
        int answer = 0;
        int[] truck_weight = new int[max_n]; // 각 마을 지점에서의 트럭 무게
        sort2(m); // 제일 짧은 루트순으로 정렬
        for (int i = 0; i < m.length; i++) { // 모든 상자에 대해 계산
            int max = m[i][2]; // load 할 수 있는 양
            for (int j = m[i][0]; j <m[i][1] && max > 0; j++) { // 박스 경로에서 트럭 적재량 여유 계산
                int temp = truck_weight[j] + max; // 짐을 load 하면
                if (temp > c) { // 초과 시
                    max -= (temp - c); // 초과분 뺴기
                }
            }
            for (int k = m[i][0]; max > 0 && k < m[i][1]; k++) { // 트럭 차있는 무게 갱신
                truck_weight[k] += max;
            }
            answer += max; // 정답에 추가
        }

        for (int j = 1 ; j <= n; j++) {
            System.out.print(truck_weight[j] + " ");
        }
        System.out.println();

        return answer;
    }

    public static int[][] sort(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i][0] > a[j][0]) {
                    int[] temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; i++) {
                if (a[i][0] != a[j][0]) {
                    i = j - 1;
                    break;
                }
                if (a[i][1] > a[j][1]) {
                    int[] temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static int[][] sort2(int a[][]) {
        int[] road = new int[a.length];
        for (int i = 0; i < road.length; i++) {
            road[i] = a[i][1] - a[i][0];
        }
        for (int i = 0; i < road.length; i++) {
            for (int j = i + 1; j < road.length; j++) {
                if (road[i] > road[j]) {
                    int tmp1 = road[i];
                    road[i] = road[j];
                    road[j] = tmp1;
                    int[] tmp2 = a[i];
                    a[i] = a[j];
                    a[j] = tmp2;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] n = {4, 6};
        int[] c = {40, 60};
        int[][][] m = {{
                {3, 4, 20},
                {1, 2, 10},
                {1, 3, 20},
                {1, 4, 30},
                {2, 3, 10},
                {2, 4, 20}
        }, {
                {1, 2, 30},
                {2, 5, 70},
                {5, 6, 60},
                {3, 4, 40},
                {1, 6, 40}
        }};
        for (int i = 0; i < 2; i++) {
            //System.out.println(solution(n[i], c[i], m[i]));
            System.out.println(solution2(n[i], c[i], m[i]));
        }
    }
}
