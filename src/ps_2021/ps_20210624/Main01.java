package ps_2021.ps_20210624;

public class Main01 {
	public static int[] checkGapZero(int[]a) {
		int result[]=new int[2];
		int gap=2000000001;
		for (int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(gap>=Math.abs(a[i]+a[j])) {
					gap=Math.abs(a[i]+a[j]);
					result[0]=a[i];
					result[1]=a[j];
				}
			}
		}
		return result;
	}
	public static void printArr(int[]arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[]args) {
		int[]arr={-99,-2,-1,4,98};
		printArr(checkGapZero(arr));
		int[]arr2= {-100,-2,-1,103};
		printArr(checkGapZero(arr2));
	}
}
