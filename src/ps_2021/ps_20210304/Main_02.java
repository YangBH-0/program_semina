package ps_2021.ps_20210304;

public class Main_02 {
	public static void main(String[] args) {
		int row = 4;// ���� ������
		int col = 14;// ���� ������
		int wall[][] = new int[4][14]; // ���� ����
		int paper = 4; // �������� ��
		int count = 9; // ����� ��
		int container[][] = { { 1, 2 }, { 2, 1 }, { 2, 3 }, { 1, 6 }, { 3, 5 }, { 1, 10 }, { 3, 6 }, { 1, 12 }, 
				{ 2, 13 } }; // ����� ��ǥ
		// ��� ĥ�ϱ�
		for(int i=0;i<count;i++) {
			wall[container[i][0]][container[i][1]]=1;
		}
		// �����̸� ������ ��ġ�� ���� �����ؾ� �´°�?
		int max=row;
		if(max<col)
			max=col;
		// �������� ũ�⸦ ���� Ű��� ����
		for(int i=0;i<max;i++) {
			int copy[][]=wall.clone();
			// �����̸� �� �� �� ��ġ�ϴ� ����
			for(int j=0;j<paper;j++) {
				  
			}
		}
	}
}
