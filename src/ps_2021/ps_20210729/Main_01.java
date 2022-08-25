package ps_2021.ps_20210729;

public class Main_01 {
	static int[] Count; // 0: �Ͼ�� �簢��, 1: �Ķ��� �簢��
	static int[][] map;

	// Point[] -> 0: ������ 1:����
	public static void dp(Point[] p, int n) {
		if (!check(p)) {
			n = n / 2;
			dp(create(p, 0, 0, -n, -n), n); // �� 2 ��и�
			dp(create(p, n, 0, 0, -n), n); // �� 1 ��и�
			dp(create(p, 0, n, -n, 0), n); // �� 3 ��и�
			dp(create(p, n, n, 0, 0), n); // �� 4 ��и�
		}
	}

	public static boolean check(Point[] p) {
		int color = map[p[0].y][p[0].x];
		for (int i = p[0].y; i < p[1].y; i++) {
			for (int j = p[0].x; j < p[1].x; j++) {
				if (color != map[i][j])
					return false;
			}
		}
		Count[color]++;
		return true;
	}

	public static Point[] create(Point[] a, int x1, int y1, int x2, int y2) {
		Point[] temp = new Point[2];
		temp[0] = new Point(a[0].x + x1, a[0].y + y1);
		temp[1] = new Point(a[1].x + x2, a[1].y + y2);
		return temp;
	}

	public static void main(String[] args) {
		Count = new int[2];
		int[][] temp = { { 1, 1, 0, 0, 0, 0, 1, 1, }, { 1, 1, 0, 0, 0, 0, 1, 1, }, { 0, 0, 0, 0, 1, 1, 0, 0, },
				{ 0, 0, 0, 0, 1, 1, 0, 0, }, { 1, 0, 0, 0, 1, 1, 1, 1, }, { 0, 1, 0, 0, 1, 1, 1, 1, },
				{ 0, 0, 1, 1, 1, 1, 1, 1, }, { 0, 0, 1, 1, 1, 1, 1, 1, } };
		map = temp;
		int n = 8;
		Point[] p = new Point[2];
		p[0] = new Point(0, 0);
		p[1] = new Point(8, 8);
		dp(p, n);
		for (int count : Count) {
			System.out.println(count);
		}
	}
}

class Point {
	int x;
	int y;

	public Point() {
		x = 0;
		y = 0;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
