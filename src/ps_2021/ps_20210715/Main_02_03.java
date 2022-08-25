package ps_2021.ps_20210715;

public class Main_02_03 {
	static final int max_n = 10;
	static int map[][] = new int[max_n][max_n];
	static int[] arr;

	static int dp(int left, int right) {
		if (left == right) {
			return 0;
		} else if (arr[left] == arr[left + 1]) {
			dp(left + 1, right);
		} else if (arr[right] == arr[right - 1]) {
			dp(left, right - 1);
		} else if (map[left][right] != 0)
			return map[left][right];
		
		map[left][right] = dp(left, right +1) + 1;
		
		for (int i = left + 1; i < right; i++) {
			if (arr[i] == arr[left]) {
				map[left][right] = Math.min(dp(left, i - 1) + dp(i, right), map[left][right]);
			}
		}
		return map[left][right];
	}

	public static void main(String[] args) {
		int n = 10;
		int k = 3;
		arr = new int[n];
		int[] temp = { 1, 1, 2, 3, 3, 3, 2, 2, 1, 1 };
		/* int[] temp = {1,1,1,1,4,4,1,2,4,2,1,1,1}; */
		for (int i = 0; i < n; i++) {
			arr[i] = temp[i];
		}
		System.out.println(dp(0, n - 1));
	}
}
