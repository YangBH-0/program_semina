package ps_2021.ps_20210506;

public class Ex01 {
	static int[][][] score;
	static int[][] score2;
	static boolean[] check;
	
	public static boolean checkArray(int arr[][], int arr2[][]) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				if (arr[i][j] != arr2[i][j] ) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean dfs(int arr[][], int p, int q) {
		if (p == 5) {
			// �˻�
			if (checkArray(arr,score2)) return true;
		} else if (q == 6) {
			return dfs(arr, p + 1, p + 2);
		} else {
			// �̱�� ���
			arr[p][0]++;
			arr[q][2]++;
			if (dfs(arr, p, q + 1)) return true;
			arr[p][0]--;
			arr[q][2]--;
			// ���� ���
			arr[p][1]++;
			arr[q][1]++;
			if (dfs(arr, p, q + 1)) return true;
			arr[p][1]--;
			arr[q][1]--;
			// ���� ���
			arr[p][2]++;
			arr[q][0]++;
			if (dfs(arr, p, q + 1)) return true;
			arr[p][2]--;
			arr[q][0]--;			
		}
		
		return false;
	}

	public static void main(String[] args) {

		int[][][] temp = { { { 5, 0, 0 }, { 3, 0, 2 }, { 2, 0, 3 }, { 0, 0, 5 }, { 4, 0, 1 }, { 1, 0, 4 } },
				{ { 4, 1, 0 }, { 3, 0, 2 }, { 4, 1, 0 }, { 1, 1, 3 }, { 0, 0, 5 }, { 1, 1, 3 } },
				{ { 5, 0, 0 }, { 4, 0, 1 }, { 2, 2, 1 }, { 2, 0, 3 }, { 1, 0, 4 }, { 0, 0, 5 } },
				{ {5,0,0} , {5,0,0}, {2,1,2} , {2,1,2} , {0,0,5} , {0,0,5} }}; 
//				{ { 5, 0, 0 }, { 3, 1, 1 }, { 2, 1, 2 }, { 2, 0, 3 }, { 0, 0, 5 }, { 1, 0, 4 } } };

		score = temp;
		System.out.println(score.length + " " + score[0].length + " " + score[0][0].length);
		check = new boolean[4];
		
		for (int i=0; i<4; i++) {
			int[][] arr2 = new int[temp[0].length][temp[0][0].length];
			score2 = temp[i];
			check[i] = dfs(arr2, 0, 1);
		}
		

		String s = "";
		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				s += "1 ";
			} else {
				s += "0 ";
			}
		}
		System.out.print(s);
	}
	public static int[][] arrayDeepcopy(int [][]arr) {
		int temp[][] = new int[arr.length][];
		for(int i=0;i<arr.length;i++) {
			temp[i]=arr[i].clone();
		}
		return temp;
	}
}
