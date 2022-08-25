package ps_2021.ps_20210715;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main_02_02 {
	public static int dp(int[] arr, int deapth) {
		if(arr.length<=1) {
			return deapth;
		}
		int[] num;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <arr.length; i++) {
			int[] temp;
			num=new int[2];
			int count=0;
			if(i>0 && arr[i-1]!=arr[i]) { // ���� �˻�
				num[count++]=arr[i-1];
			}
			if(i+1<arr.length && arr[i]!=arr[i+1]){ // ������ �˻�
				num[count++]=arr[i+1];
			}
			if(num[0]==num[1])
				count--;
			for(int j=0;j<count;j++) {
				temp=arr.clone();
				temp[i]=num[j];
				list.add(dp(chopArr(temp),deapth+1));
			}
		}
		return Collections.min(list); 
	}

	public static void main(String[] args) {
		int n = 10;
		int k = 3;
		 int[] temp = { 1, 1, 2, 3, 3, 3, 2, 2, 1, 1 }; 
		/* int[] temp = {1,1,1,1,4,4,1,2,4,2,1,1,1}; */
		System.out.println(dp(chopArr(temp), 0));
	}

	public static int[] chopArr(int[] arr) { // �ߺ� ��� ���� 

		ArrayList<Integer> list = new ArrayList<Integer>();
		int tmp=0;
		for (int i = 0; i < arr.length; i++) {
			if(tmp!=arr[i]) {
				tmp=arr[i];
				list.add(tmp);
			}
		}
		int[] temp=Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(i->i).toArray();
		return temp;
	}

}
