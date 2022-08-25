package ps_2021.ps_20210715;

import java.util.Arrays;

public class Main_01_01 {
	public static void main(String[]args) {
		int n=7;
		int[] arr= {1,1,6,7,7,30,2};
		Arrays.sort(arr);
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(sum+1<arr[i])
				break;
			sum+=arr[i];
		}
		System.out.println(sum+1);
	}
}
