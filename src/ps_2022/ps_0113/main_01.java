package ps_2022.ps_0113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class main_01 {
    static ArrayList<position> cheeseList; // 치즈가 있는 좌표
    static ArrayList<position> emptyList;

    private static class position {
        int x;
        int y;

        public position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static mapinfo[][] init(int[][] map, int n, int m) {
        mapinfo[][] temp = new mapinfo[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    temp[i][j] = mapinfo.empty;
                    if(i == 0 || j==0 || i==n-1 || j==m-1){
                        temp[i][j]= mapinfo.outside;
                    }
                } else {
                    temp[i][j] = mapinfo.cheese;
                }
            }
        }
        return temp;
    }

    private static int solution(mapinfo[][] map) {
        int answer = 0;
        cheeseList = new ArrayList<>();
        emptyList = new ArrayList<>();
        findCheese(map);
        findEmpty(map);
        while (!cheeseList.isEmpty()) {
            //Collections.sort(emptyList, (b1,b2)-> Integer.compare(b1.x,b2.x));
            step1(map); // 외부 공기 파악
            step1(map);
            step2(map); // 치즈 녹이기
            answer++;
        }
        return answer;
    }

    private static void findCheese(mapinfo[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == mapinfo.cheese)
                    cheeseList.add(new position(i, j));
            }
        }
    }

    private static void findEmpty(mapinfo[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == mapinfo.empty)
                    emptyList.add(new position(i, j));
            }
        }
    }

    private static void step1(mapinfo[][] map) { // 외부 공기
        Queue<position> queue = new LinkedList<>(); // 바깥 공기가 된 공기
        int n = map.length;
        int m = map[0].length;
        int i, j;
        for (position p : emptyList) {
            i = p.x;
            j = p.y;
            if (i - 1 >= 0 && map[i - 1][j] == mapinfo.outside) {//북
                map[i][j] = mapinfo.outside;
                queue.add(p);
            } else if (i + 1 < n && map[i + 1][j] == mapinfo.outside) {//남
                map[i][j] = mapinfo.outside;
                queue.add(p);
            } else if (j + 1 < m && map[i][j + 1] == mapinfo.outside) {//동
                map[i][j] = mapinfo.outside;
                queue.add(p);
            } else if (j - 1 >= 0 && map[i][j - 1] == mapinfo.outside) {//서
                map[i][j] = mapinfo.outside;
                queue.add(p);
            }
        }
        while (!queue.isEmpty()) {
            emptyList.remove(queue.poll());
        }
    }

    private static void step2(mapinfo[][] map) {
        Queue<position> queue = new LinkedList<position>(); // 녹을 치즈 좌표 넣을 큐
        int n = map.length;
        int m = map[0].length;
        int i, j, count;
        for (position p : cheeseList) {
            i = p.x;
            j = p.y;
            count = 0; // 바깥과의 접촉면
            if (i - 1 >= 0 && map[i - 1][j] == mapinfo.outside) {//북
                count++;
            }
            if (i + 1 < n && map[i + 1][j] == mapinfo.outside) {//남
                count++;
            }
            if (j + 1 < m && map[i][j + 1] == mapinfo.outside) {//동
                count++;
            }
            if (j - 1 >= 0 && map[i][j - 1] == mapinfo.outside) {//서
                count++;
            }
            if (count > 1) {
                queue.add(p); // 녹을 치즈 좌표
            }
        }
        while (!queue.isEmpty()) {
            position p = queue.poll();
            map[p.x][p.y]=mapinfo.outside; // 바깥 공기화
            cheeseList.remove(p); // 녹을 치즈 좌표 없애기
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 9;
        int[][] map1 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        int[][] map2 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 0, 1, 0, 0, 1, 0, 0, 1, 0 },
                { 0, 1, 0, 1, 1, 1, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        System.out.println(solution(init(map1, n, m)));
        System.out.println(solution(init(map2,map2.length,map2[0].length)));
    }
}
