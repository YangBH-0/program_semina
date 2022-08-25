package ps_2021.ps_20210624;

public class Main02 {
	public static int checkFloodSafeArea(int n, int arr[][], int h) { // n�� �迭�� ���� arr�� ���� ���� ���� h�� ħ���Ǵ� ����
		boolean check[][] = new boolean[n][n]; // ħ���� ���� ǥ��
		// ħ���� ���� üũ
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] <= h) {
					check[i][j] = true;
				}
			}
		}
		int count = 0;
		// ������ �� �� �ִ��� ī����
		for (int i = 0; i < n * n; i++) {
			if (!check[i / n][i % n]) {
				visit(check, i);
				count++;
			}
		}
		return count;
	}

	public static void visit(boolean visited[][], int n) {
		int len = visited.length;
		java.util.Queue<Integer> queue = new java.util.LinkedList<>();
		queue.add(n);
		while (!queue.isEmpty()) {
			int index = queue.poll();
			visited[index / len][index % len] = true;
			// ��
			if ((index % len) + 1 < len && !visited[index / len][index % len + 1]) {
				queue.add(index + 1);
			}
			// ��
			if ((index / len) + 1 < len && !visited[index / len + 1][index % len]) {
				queue.add(index + len);
			}
			// ��
			if ((index % len) > 0 && !visited[index / len][index % len - 1]) {
				queue.add(index - 1);
			}
			// ��
			if ((index / len) > 0 && !visited[index / len - 1][index % len]) {
				queue.add(index - len);
			}
		}
	}

	public static void printArr(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int arr[][] = { { 6, 8, 2, 6, 2 }, { 3, 2, 3, 4, 6 }, { 6, 7, 3, 3, 2 }, { 7, 2, 5, 3, 6 }, { 8, 9, 5, 2, 7 } };
		int big = 0;
		for (int i = 0; i < 100; i++) {
			int temp = checkFloodSafeArea(n, arr, i);
			if (temp == 0)
				break;
			if (big < temp)
				big = temp;
		}
		System.out.println(big);
		n = 7;
		int arr2[][] = { { 9, 9, 9, 9, 9, 9, 9 }, { 9, 2, 1, 2, 1, 2, 9 }, { 9, 1, 8, 7, 8, 1, 9 },
				{ 9, 2, 7, 9, 7, 2, 9 }, { 9, 1, 8, 7, 8, 1, 9 }, { 9, 2, 1, 2, 1, 2, 9 }, { 9, 9, 9, 9, 9, 9, 9 } };
		for (int i = 0; i < 100; i++) {
			int temp = checkFloodSafeArea(n, arr2, i);
			if (temp == 0)
				break;
			if (big < temp)
				big = temp;
		}
		System.out.println(big);
	}
}
