package ps_2021.ps_20210506;

public class Main_01_01 {
	static int[][][] score;
	static boolean[] check;

	public static void brutalForce(int arr[][], int n, int deapth, int WinCount, int DrawCount, int LoseCount) {
		if (WinCount > 15 || LoseCount > 15)
			return;
		if (n == 0) {
			if (WinCount == LoseCount && DrawCount % 2 == 0) {

			}

			return;
		}
		if (n % 5 == 0 && n != 30) {
			deapth++;
		}
		arr[deapth][0]++;
		WinCount += 1;
		brutalForce(arr, n - 1, deapth, WinCount, DrawCount, LoseCount);
		WinCount -= 1;
		arr[deapth][0]--;
		arr[deapth][1]++;
		DrawCount += 1;
		brutalForce(arr, n - 1, deapth, WinCount, DrawCount, LoseCount);
		DrawCount -= 1;
		arr[deapth][1]--;
		arr[deapth][2]++;
		LoseCount += 1;
		brutalForce(arr, n - 1, deapth, WinCount, DrawCount, LoseCount);
		LoseCount -= 1;
		arr[deapth][2]--;
		return;
	}

	public static void dfs(int arr[][], int play, int p, int q) {
		if (play == 0) {
			// �˻�
			boolean flag;
			for (int i = 0; i < score.length; i++) {
				if (check[i]) {
					continue;
				}
				flag = true;
				for(int j=0;j<18;j++) {
					if(arr[j/3][j%3]!= score[i][j/3][j%3]) {
						//System.out.println(j+""+i+"|"+arr[j/3][j%3]+", "+score[i][j/3][j%3]);
						break;
					}
					else if(j==17) {
						check[i] = true;
						//System.out.println("check");
					}
				}
				
			}
			return;
		}
		else if (q == 6) {
			dfs(arr, play, p + 1, p + 2);
		} else {
			// �̱�� ���
			arr[p][0]++;
			arr[q][2]++;
			dfs(arrayDeepcopy(arr), play - 1, p, q + 1);
			arr[p][0]--;
			arr[q][2]--;
			// ���� ���
			arr[p][1]++;
			arr[q][1]++;
			dfs(arrayDeepcopy(arr), play - 1, p, q + 1);
			arr[p][1]--;
			arr[q][1]--;
			// ���� ���
			arr[p][2]++;
			arr[q][0]++;
			dfs(arrayDeepcopy(arr), play - 1, p, q + 1);
		}
		return;
	}

	public static void main(String[] args) {

		int[][][] temp = { { { 5, 0, 0 }, { 3, 0, 2 }, { 2, 0, 3 }, { 0, 0, 5 }, { 4, 0, 1 }, { 1, 0, 4 } },
				{ { 4, 1, 0 }, { 3, 0, 2 }, { 4, 1, 0 }, { 1, 1, 3 }, { 0, 0, 5 }, { 1, 1, 3 } },
				{ { 5, 0, 0 }, { 4, 0, 1 }, { 2, 2, 1 }, { 2, 0, 3 }, { 1, 0, 4 }, { 0, 0, 5 } },
				{ { 5, 0, 0 }, { 3, 1, 1 }, { 2, 1, 2 }, { 2, 0, 3 }, { 0, 0, 5 }, { 1, 0, 4 } } };

		score = temp;
		System.out.println(score.length + " " + score[0].length + " " + score[0][0].length);
		check = new boolean[4];
		dfs(new int[6][3], 15, 0, 1);

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
