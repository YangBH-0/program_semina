package ps_2021.ps_20210708;

public class Main_01 {
	static int bigsum(int arr[],int k) {
		int result=-200;
		for(int i=0;i<arr.length-k+1;i++) {
			int sum=0;
			for(int j=0;j<k;j++) {
				sum+=arr[i+j];
			}
			if(sum>result)
				result=sum;
		}
		return result;
	}
	static int function2(int arr[],int k) {
		int i=0;
		int result;
		int sum=0;
		for(int j=0;j<k;j++) {
			sum+=arr[j];
		}
		result=sum;
		while(i<arr.length-k) {
			sum-=arr[i];
			sum+=arr[i+k];
			if(sum>result)
				result=sum;
			i++;
		}
		return result;
	}
	public static void main(String[]args) {
		
		int[] arr1= {3,-2,-4,-9,0,3,7,-3,13,8};
		int k1=2;
		System.out.println(bigsum(arr1,k1));
		int[] arr2= {3,-2,-4,-9,0,3,7,13,8,-3};
		int k2=5;
		System.out.println(bigsum(arr2,k2));
		System.out.println(function2(arr1,k1));
		System.out.println(function2(arr2,k2));
	}

}
