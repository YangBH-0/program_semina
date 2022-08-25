package ps_2021.ps_20211104;
import java.util.Arrays;
import java.util.Collections;

public class Main_01 {
    public static int solution(int n, int request[], int m) {
		int result=0;
		int sum = 0;
		for (int i : request) {
			sum += i;
		}
		// 모든 요청이 배정 될 수 있는 경우 그대로 배정.
		if(sum<=m){
			for(int i : request){
				if(result<i){
					result=i;
				}
			}
		}else{ // 모든 요청이 배정 안 될경우
			// 역순으로 정렬
			Integer[] temp = Arrays.stream(request).boxed().toArray(Integer[]::new);
			Arrays.sort(temp, Collections.reverseOrder());
			request= Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
			result=request[0]; // 가장 높은 예산

			int i;
			// 모든 요청의 합이 예산보다 작거나 같아 질 때까지
			while(sum>=m){
				result--;
				i=0;
				while(i>=4 || result<=request[i]){
					request[i]--;
					sum--;
					i++;
				}
			}
		}
        return result;
    }

    public static void main(String[] args) {
        int n[] = {4, 5};
        int[][] request =
                {
                        {120, 110, 140, 150},
                        {70, 80, 30, 40, 100}
                };
        int m[] = {485, 450};
		for (int i=0;i<2;i++){
			System.out.println(
					solution(n[i],request[i],m[i]));
		}

    }
}
