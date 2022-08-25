package ps_2021.ps_20210506;

public class Main_01 {
	public static void main(String[] args) {
		int n = 6;
		int m = 4;
		int[][] arr = { { 5, 0, 0, 3, 0, 2, 2, 0, 3, 0, 0, 5, 4, 0, 1, 1, 0, 4 },
				{ 4, 1, 0, 3, 0, 2, 4, 1, 0, 1, 1, 3, 0, 0, 5, 1, 1, 3 },
				{ 5, 0, 0, 4, 0, 1, 2, 2, 1, 2, 0, 3, 1, 0, 4, 0, 0, 5 },
				{ 5, 0, 0, 3, 1, 1, 2, 1, 2, 2, 0, 3, 0, 0, 5, 1, 0, 4 } };
		int[] result = new int[arr.length]; // �������� �����ϴ� ��
		int limit=6*5; // ���ü� �ִ� �� �¹���
		for (int i = 0; i < arr.length; i++) {
			int[] sum={0,0,0}; // {��, ��, ��} ��
			boolean[] check= new boolean[6]; // ���ºΰ� �ִ� ���� Ȯ���ϴ� ���
			int play=0; // �� ������ 5��� �̻� �ߴ��� Ȯ���ϴ� ����
			for (int j = 0; j < arr[i].length; j++) {
				if(j%3==0) // ���� ���� �Ͻ� �ʱ�ȭ
					play=0;
				play+=arr[i][j]; // ���� +=
				if(play>5) {
					break;
				}
				switch(j%3) {
				case(0):{
					sum[0]+=arr[i][j];
					break;
				}
				case(1):{
					if(arr[i][j]!=0)
						check[j/3]=true;
					sum[1]+=arr[i][j];
					break;
				}
				case(2):{
					sum[2]+=arr[i][j];
					break;
				}
				}
			}
			int stack=0;
			for(boolean c:check) {
				if(c)stack++;
			}
			int temp=sum[0]+sum[1]+sum[2];
			if(temp==limit && sum[1]%2==0 && sum[0]==sum[2]&& stack!=0){
				result[i] = 1;
			} else {
				result[i] = 0;
			}
		}

		for(int r: result) {
			System.out.print(r+" ");
		}
	}

}
