package ps_2022.ps_0324;

import java.util.Arrays;

public class Main03 {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left=1;
        long right= (long) Arrays.stream(times).max().getAsInt() *n;
        long mid;

        while(left<=right){
            mid = (left+right) / 2;
            long people=0;
            for(int i : times) {
                people += mid / i;
                if (people >= n) {
                    answer = mid;
                    right = mid - 1;
                    break;
                }
            }
            if (people < n)
                left = mid+1;
        }
        return answer;
    }
    static int BSearch(int arr[], int target){
        int low =0;
        int high = arr.length-1;
        int mid;

        while(low <=high){
            mid = (low + high) / 2;
            System.out.println(mid);
            if(arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                high = mid -1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] tArr= {17,28,43,67,88,92,100};
        System.out.println(BSearch(tArr,28));
    }
}
