package ps_2021.ps_20210225;

public class Main_01_2 {
	public static char[] color = { 'B', 'Y', 'R', 'G' };
	public static String[] dice = { "YBRBRG", "GYBGBY", "RGBYYR", "YBGBYY" };

	public static void main(String[] args) {
		// 0:2 1:3 4:5
		char top;
		String column[][] = new String[4][4];
		// ù��° �ֻ��� � ���� �ظ����� �������� ���� ù���� for��
		for (int i = 0; i < 6; i++) {
			// �ι��� �ֻ��� � ���� �ظ����� ������ �� ���� �ι�° for��
			for (int j = 0; j < 6; j++) {
				// ���� ����
				for (int k = 0; k < 6; k++) {
					// ���� ����
					for (int l = 0; l < 6; l++) {
						switch (l) {
						case (0): {
							top = dice[3].charAt(2);
							break;
						}
						case (1): {
							top = dice[3].charAt(3);
							break;
						}
						case (2): {

							top = dice[3].charAt(0);
							break;
						}
						case (3): {
							top = dice[3].charAt(1);
							break;
						}
						case (4): {
							top = dice[3].charAt(5);
							break;
						}
						case (5): {
							top = dice[3].charAt(4);
							break;
						}
						}
					}
				}
			}
		}
	}
}
