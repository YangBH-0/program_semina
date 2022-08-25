package ps_2021.ps_20211118;

import java.util.ArrayList;

public class Main_01 {
    public static int solution(int input[][]) {
        int answer = 0; // 결과
        int len = input[0][0]; // 총 건물(학교를 뺀) 수
        int bus = input[0][1]; // 버스 최대 수용양
        int school = input[0][2]; // 학교 위치
        int[][] students = new int[len][]; // 학생 위치
        ArrayList<int[]> right = new ArrayList<>(); // 학교보다 오른쪽에 있는 건물들
        ArrayList<int[]> left = new ArrayList<>(); // 학교보다 왼쪽에 있는 건물들

        System.arraycopy(input, 1, students, 0, len); // 학생들 넣기

        for (int[] student : students) { // 학교 중심으로 양쪽으로 구분
            int dist = student[0] - school;
            if (dist < 0) {// 학교보다 왼쪽
                left.add(new int[]{Math.abs(dist), student[1]});
            } else { // 학교보다 오른쪽
                right.add(new int[]{dist, student[1]});
            }
        }

        sort(right); // 내림차순 정렬, bubble sort
        sort(left); // 내림차순 정렬, bubble sort

        System.out.println("right");
        for (int[] i : right) {
            System.out.println(i[0] + ", " + i[1]);
        }
        System.out.println("left");
        for (int[] i : left) {
            System.out.println(i[0] + ", " + i[1]);
        }
        //오른편 계산
        answer += getAnswer(bus, right);
        //왼편 계산
        answer += getAnswer(bus, left);

        return answer;
    }

    private static int getAnswer(int bus, ArrayList<int[]> students) {
        int answer = 0;
        int i = 0; // 인덱스
        int result; // 편도 거리
        int capacity; // 탑승자 수
        do {
            result = 0;
            capacity = 0;
            while (i < students.size()) {
                if (students.get(i)[1] != 0) { // 사람이 없는지 확인
                    capacity += students.get(i)[1];
                    students.get(i)[1] = 0; // 일단 모두다 태우기
                    if (result == 0) { // 최초 인가?
                        result += students.get(i)[0]; // 최초로 도착한 지점 길이 저장
                    }
                    if (capacity - bus >= 0) { // 탑승자 수가 초과 했는가?
                        students.get(i)[1] = capacity % bus; // 초과된 인원 하차
                        break;
                    }
                }
                i++;
            }
            answer += result * 2; // 왕복 = 편도 거리 * 2
        } while (i < students.size()); // 학생들 위치 전부 다 돌앗는가?
        return answer;
    }

    public static void sort(ArrayList<int[]> a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i)[0] < a.get(j)[0]) {
                    int[] temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        int input[][][] = {
                {
                        {3, 4, 4},
                        {0, 1},
                        {2, 2},
                        {5, 1}
                },
                {
                        {4, 4, 0},
                        {7, 3},
                        {5, 3},
                        {20, 4},
                        {11, 5}
                }
        };
        for (int[][] tmp : input) {
            System.out.println("계산시작 ");
            System.out.println("결과: " + solution(tmp));
        }
    }
}
