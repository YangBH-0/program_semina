package ps_2021.ps_20210902;

public class Main_01 {
	public static void main(String args[]) {
		int arr[][][]= {
						{{4, 5, 6, 7, 0, 1, 2, 3, 9, 8},
							{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}},
						{{9, 1, 7, 2, 6, 3, 0, 4, 8, 5},
								{6, 3, 9, 2 ,1 ,0 ,7, 4, 8, 5}},
						{{7, 1, 6, 2, 3, 0, 5, 9 ,4 ,8},
									{7, 1, 6, 2, 3, 0, 5, 9, 4, 8}}
				};
		for(int i=0;i<arr.length;i++) {
			int points[]=new int[2];
			for(int j=0;j<arr[0][0].length;j++) {
				if(arr[i][0][j]>arr[i][1][j]) {
					points[0]+=3;
				}else if(arr[i][0][j]<arr[i][1][j]) {
					points[1]+=3;
				}else {
					points[0]++;
					points[1]++;
				}
			}
			for(int point:points) {
				System.out.print(point+" ");
			}
			System.out.println();
			if(points[0]>points[1]) {
				System.out.println("A");
			}else if(points[0]<points[1]) {
				System.out.println("B");
			}else {
				boolean flag=true;
				for(int j=arr[0][0].length-1;j>=0;j--) {
					if(arr[i][0][j]==arr[i][1][j]) {
					}
					else {
						if(arr[i][0][j]>arr[i][1][j]) {
							System.out.println("A");
						}else {
							System.out.println("B");
						}
						flag=false;
						break;
					}
				}
				if(flag) {
					System.out.println("D");
				}
			}
		}
	}
}
