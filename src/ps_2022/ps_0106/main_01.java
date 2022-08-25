package ps_2022.ps_0106;

public class main_01 {
    static class mystack {
        private int[] arr;
        private int index;

        public mystack(int n) {
            this.arr = new int[n];
            index = 0;
        }

        public boolean push(int n) {
            if (isFull()) {
                return false;
            }
            arr[index++] = n;
            return true;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return arr[--index];
        }

        public boolean isEmpty() {
            return index <= 0;
        }

        public boolean isFull() {
            return index == arr.length;
        }
    }

    public static int[] solution(int[] n1, int[][] n2) {
        int[] answer = new int[n1[0]];
        mystack stack = new mystack(n1[0]); // stack
        boolean[] check = new boolean[n1[0] + 1]; // 0 ~ N
        int index = 1; //
        boolean flag = true; // while
        while (flag) {
            flag = false;
            for (int i = 0; i < n1[1]; i++) {
                if (index <= n2[i][0]) { // 해당 줄의 가수 번호의 총 수보다 작다면
                    flag = true; // 하나라도 존재 시
                    int temp = n2[i][n2[i].length - index]; // pd가 담당할 가수의 번호
                    if (!check[temp]) { // 마킹이 안 되어 있다면
                        stack.push(temp); // 추가
                        check[temp] = true; // 해당 가수 번호 마킹
                    }
                }
            }
            index++; // 인덱스 증가
        }
        if (!stack.isFull()) {
            answer = new int[]{0};
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.pop();
        }
        for (int i = 0; i < n1[1]; i++) {

            int back = 0;
            int front;

            for (int value : answer) {
                for (int j = 1; j < n2[i].length; j++) {
                    if (value == n2[i][j]) {
                        front = j;
                        if (back > front) {
                            return new int[]{0};
                        }
                        back = front;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] input = {6, 3};
        int[][] pd = {
                {3, 1, 4, 3},
                {4, 6, 3, 5, 4},
                {2, 2,3}
        };
        for (int i : solution(input, pd)) {
            System.out.println(i);
        }
    }
}
