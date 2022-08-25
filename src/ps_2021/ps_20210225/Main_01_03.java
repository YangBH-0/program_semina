package ps_2021.ps_20210225;

public class Main_01_03 {
	public static char[] color = { 'Y', 'R', 'G', 'B' };
	public static String[] dice = { "YBRBRG", "GYBGBY", "RGBYYR", "YBGBYY" };
	public static int cnt;

	public static void backtracking(int floor, int arr[]) {
		// 4������ �׾����� ���� �ܰ�
		if (floor == 4) {
			isTest(arr);
			return;
		}
		// �� ������ �ظ��� �Ǵ� ��츦 ��� �ױ�
		for (int i = 0; i < 3; i++) {
			arr[floor] = i;
			backtracking(floor + 1, arr);
		}

		return;

	}

	public static void isTest(int arr[]) {
		String[] str = new String[4];
		// ���� ����� �ظ� ���ϰ� ���� �� ����
		for (int i = 0; i < 4; i++) {
			str[i] = isChoose(arr[i], dice[i]);
		}
		// �����̶� ���鿡 ���� ���� ���� ���ϱ�
		func(0, str, new String[4]);
		return;
	}

	public static void func(int row, String[] str, String[] column) {
		// 4�������� ������ü�� �� ���� ������ü�� ȸ���ؼ� ���� ��� 
		if (row == 4) {
			if (isVaild(column)) {
				cnt++;
			}
			return;
		}
		// ������ ����� ���� �����ִ� �κ�
		for (int i = 0; i < 2; i++) {
			column[row] = "";
			column[row] += "" + str[row].charAt(i * 2) + str[row].charAt((i * 2 + 2) % 4);
			column[row] += "" + str[row].charAt(i * 2 + 1) + str[row].charAt((i * 2 + 3) % 4);
			func(row + 1, str, column);
		}
		return;
	}

	public static boolean isVaild(String[] column) {
		boolean color_check;
		// �� ����� ���� 4���� ���� ��Ÿ������ �˻� 
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				color_check = false;
				for (int k = 0; k < 4; k++) {
					if (column[i].charAt(k) == color[j]) {
						if (color_check) {
							System.out.println(i+1+"��° ����  "+column[i]+"�� Ż���մϴ�.");
							return false;
						} else {
							color_check = true;
						}
					}
				}
			}
		}
		return true;
	}
	// �ظ�� ������ �������� ������ ���� ¦�� ��� �����ϴ� ��
	public static String isChoose(int n, String s) {
		// n�� �ֻ����� �ظ� ���� ���ϴ� ����
		// n=0 0:2
		// n=1 1:3
		// n=2 4:5
		switch (n) {
		case (0): {
			return "" + s.charAt(1) + s.charAt(3) + s.charAt(4) + s.charAt(5);
		}
		case (1): {
			return "" + s.charAt(0) + s.charAt(2) + s.charAt(4) + s.charAt(5);
		}
		case (2): {
			return "" + s.charAt(0) + s.charAt(2) + s.charAt(1) + s.charAt(3);
		}
		default: {
			return "";
		}
		}
	}

	public static void main(String[] args) {
		cnt = 0;
		backtracking(0, new int[4]);
		System.out.println(cnt);
	}
}
