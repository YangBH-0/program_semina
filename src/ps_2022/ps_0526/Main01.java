package ps_2022.ps_0526;

import java.util.HashMap;
import java.util.Map;

public class Main01 {


    public static String solution(int m, int n, String[] board) {
        String answer = "";
        boolean[] checker = new boolean[26]; // A~ Z
        char[][] map = new char[m][n];
        Map<Integer, position> hash = new HashMap<>();
        Map<Integer, position> hash2 = new HashMap<>();
        int len = m * n;
        int i = 0;
        int x, y; // row, col
        int temp;
        char target;
        // mapping to map & hash
        while (i < len) {
            x = i / n;
            y = i % n;
            target = board[x].charAt(y);
            if (65 <= target) {
                temp = target - 65;
                if (checker[temp]) {
                    hash2.put(temp, new position(x, y));
                } else {
                    checker[temp] = true;
                    hash.put(temp, new position(x, y));
                }
            }
            map[x][y] = target;
            i++;
        }
        // check the condition
        i = 0;
        int gapX, gapY;
        while (i < checker.length) {
            if (checker[i]) {
                position point1 = hash.get(i);
                position point2 = hash2.get(i);
                gapX = point2.x - point1.x;
                gapY = point2.y - point1.y;
                if (checkRoute(map, point1, gapX, gapY, (char) (i + 65))) {
                    checker[i] = false;
                    answer += (char) (i + 65);
                    map[point1.x][point1.y] = '.';
                    map[point2.x][point2.y] = '.';
                    i = 0;
                    continue;
                }
            }
            i++;
        }
        for (boolean b : checker) {
            if (b) {
                return "IMPOSSIBLE";
            }
        }

        return answer;
    }

    public static boolean checkRoute(char[][] map, position point, int gapX, int gapY, char targetChar) {
        boolean[] c = new boolean[2]; // two Route checker
        int x = point.x;
        int y = point.y;
        char[] line; // sliced line
        // first row
        if (gapX == 0) {
            line = new char[0];
        } else {
            //south
            if (gapX > 0) {
                line = new char[gapX];
                for (int i = 1; i < gapX + 1; i++) {
                    line[i - 1] = map[x + i][y];
                }
            }
            // north
            else {
                line = new char[Math.abs(gapX)];
                for (int i = 1; i < Math.abs(gapX) + 1; i++) {
                    line[i - 1] = map[x - i][y];
                }
            }
        }
        // move col
        if (!checkLine(line, targetChar)) {
        } else {
            //east
            if (gapY > 0) {
                line = new char[gapY];
                for (int i = 1; i < gapY + 1; i++) {
                    line[i - 1] = map[x + gapX][y + i];
                }
            }
            //west
            else {
                line = new char[Math.abs(gapY)];
                for (int i = 1; i < Math.abs(gapY); i++) {
                    line[i - 1] = map[x + gapX][y - i];
                }
            }

            if (checkLine(line, targetChar)) {
                c[0] = true;
            } else {
                c[0] = false;
            }
        }
        //first row
        // move col
        if (gapY == 0) {
            line = new char[0];
        } else {
            // east
            if (gapY > 0) {
                line = new char[gapY];
                for (int i = 1; i < gapY + 1; i++) {
                    line[i - 1] = map[x][y + i];
                }
            }
            //west
            else {
                line = new char[Math.abs(gapY)];
                for (int i = 1; i < Math.abs(gapY) + 1; i++) {
                    line[i - 1] = map[x][y - i];
                }
            }
        }
        // move row
        if (!checkLine(line, targetChar)) {
        } else {
            //south
            if (gapX > 0) {
                line = new char[gapX];
                for (int i = 1; i < gapX + 1; i++) {
                    line[i - 1] = map[x + i][y + gapY];
                }
            }
            // north
            else {
                line = new char[Math.abs(gapX)];
                for (int i = 1; i < Math.abs(gapX) + 1; i++) {
                    line[i - 1] = map[x - i][y + gapY];
                }
            }
            if (checkLine(line, targetChar)) {
                c[1] = true;
            } else {
                c[1] = false;
            }
        }
        if (c[0] || c[1]) {
            return true;
        }
        return false;
    }

    public static boolean checkLine(char[] line, char targetChar) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] != '.' && line[i] != targetChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] m = {3, 2, 4, 2};
        int[] n = {3, 4, 4, 2};
        String[][] board = {
                {"DBA", "C*A", "CDB"},
                {"NRYN", "ARYA"},
                {".ZI.", "M.**", "MZU.", ".IU."},
                {"AB", "BA"},
        };

        for (int i = 0; i < m.length; i++) {

            System.out.println(solution(m[i], n[i], board[i]));
        }

        //solution(m[2],n[2],board[2]);

    }
}

class position {
    int x;
    int y;

    public position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
