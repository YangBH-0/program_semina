package ps_2021.ps_20210304;

public class Main_01 {
	public static void main(String[]args) {
		int n=3;
		int prame[]=new int[n];
		int picture_num[]=new int[n];
		int old[]=new int[n];
		int student=9;
		int rec[]= {2,1,4,3,5,6,2,7,2};
		int m;
		for(int i=0;i<student;i++) {
			m=rec[i];
			for(int j=0;j<n;j++) {
				if(picture_num[j]==0 || picture_num[j]==m) {
					prame[j]++;
					picture_num[j]=m;
					break;
				}else if(j==n-1) {
					int min=prame[0];
					int index=0;
					for(int k=0;k<n;k++) {
						if(min>prame[k]) {
							min=prame[k];
							index=k;
						}else if(min==prame[k] && old[k]>old[index]) {
							index=k;
						}
					}
					prame[index]=1;
					picture_num[index]=m;
					old[index]=0;
				}
			}
			for(int j=0;j<n;j++) {
				old[j]++;
			}
		}
		for(int result:picture_num) {
			System.out.print(result+" ");
		}
		System.out.println();
		for(int ss:prame) {
			System.out.print(ss+" ");
		}
	}
}
