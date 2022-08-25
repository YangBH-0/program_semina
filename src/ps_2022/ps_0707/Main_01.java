package ps_2022.ps_0707;

public class Main_01 {
    static int[] solution(int input){
        int[] answer=new int[3];
        int a = 300; // 5 min
        int b = 60; // 1 min
        int c = 10; // 10 sec
        int[] time= new int[3];
        time[0]=a;
        time[1] = b;
        time[2] = c;
        for(int i=0;i<3;i++){
            answer[i]=input/time[i];
            input%=time[i];
        }
        if(input!=0){
            answer[0]=-1;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] inputs={100,189};
        for(int input:inputs) {
            int[] answer = solution(input);
            if (answer[0] == -1) {
                System.out.println("-1");
            } else {
                for (int i : answer) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}
