package ps_2021.ps_20210225;

public class Main_01 {
	public static int cnt;
	public static char[] color = { 'B', 'Y', 'R', 'G' };
	public static String[] dice = { "YBRBRG", "GYBGBY", "RGBYYR", "YBGBYY" };
	public static boolean[] check = new boolean[4];

	public static void backtracking(int floor, int arr[]) {
		if (floor == 4) {

			print(arr);	
			System.out.println();
			if (isVaild(arr)) {			
				cnt++;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[floor] = i;
				backtracking(floor + 1, arr);
				arr[floor] = 0;
				check[i] = false;
			}
		}
		return;

	}

	public static boolean isVaild(int arr[]) {
		String column[] = new String[4];
		char top;
		top = dice[arr[3]].charAt(4);
		for (int i = 0; i < 4; i++) {
			column[i]="";
			for (int j = 0; j < 4; j++) {
				column[i] += dice[arr[j]].charAt(i);
			}
		}
		boolean color_check;
		for (int i = 0; i < 4; i++) {
			color_check = false;
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (column[i].charAt(j) == color[k]) {
						if (color_check) {
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

	public static void main(String[] args) {
		// " �� �� �� �� �� �� "
		cnt = 0;
		int[] num = new int[4];
		// �� �� �� �� ���� �� �Ʒ��� ��
		backtracking(0, num);
		System.out.println(cnt);
	}
	public static void print(int arr[]) {
		String column[] = new String[4];
		for (int i = 0; i < 4; i++) {
			column[i]="";
			for (int j = 0; j < 4; j++) {
				column[i] += dice[arr[j]].charAt(i);
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(column[j].charAt(i));
			}
			System.out.println();
		}
	}
}
