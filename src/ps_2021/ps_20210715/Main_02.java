package ps_2021.ps_20210715;

public class Main_02 {
	public static int min;
	public static int color;
	public static int[] switchColor(int[] arr,int index,int color) {
		// ������ �����ʵ� �ٲٱ�
		for(int i=index+1;i<arr.length;i++) {
			if(arr[index]!=arr[i]) {
				break;
			}
			arr[i]=color;
		}
		// ������ ���ʵ� �ٲٱ�
		for(int i=index-1;i>=0;i--) {
			if(arr[index]!=arr[i]) {
				break;
			}
			arr[i]=color;
		}
		// �ڽ� �ٲٱ�
		arr[index]=color;
		return arr;
	}
	public static void dfs(int[] arr,int deapth) {
		if(deapth>min) { // �ּ�Ƚ������ ������ ����
			return;
		}
		for(int i=1;i<=color;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i]!=color) {
					dfs(switchColor(arr.clone(),j,i),deapth+1);
				}
			}
		}
		if(checkColor (arr)) { // ������ �����ߴµ� Ƚ���� �ּ� Ƚ������ ������ �ּ� Ƚ�� ����
			if(min>deapth)
				min=deapth;
		}
	}
	public static int function(int n, int k, int[] arr) {
		min=k;
		color=k;
		dfs(arr,0);
		return min;
	}

	public static boolean checkColor(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[0] != arr[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int k = 3;
		int n = 10;
		int[] arr = { 1, 1, 2, 3, 1, 3, 2, 2, 1, 1 };
		System.out.println(function(n, k, arr));
	}
}
