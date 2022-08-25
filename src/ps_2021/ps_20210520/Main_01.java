package ps_2021.ps_20210520;

public class Main_01 {
	public static void main(String[]args) {
		int n=11; // Ÿ���� ��
		int []arr= {1,2,6,7,11,12,13,15,17,20,23}; // Ÿ�Ͽ� ���� ����
		// ���� �� 
		int big=0; // ���� ū �� 
		int gap=1; // Ÿ���� ������ �� (��Ģ)
		int sum; // ���� ��
		int pre; // ��� �ִ� Ÿ���� ����
		int count; // ��Ģ�� ���� �� �־��� Ÿ���� ��
		while(gap<arr[n-1]/2+1) { // ���� ū ���� n/2+1 ���� ũ�鼭 3���� ��� ��Ģ�� ����
			for(int i=0;i<n-2;i++) { // Ÿ���� 
				count=1; // ó�� ��� ����
				pre=arr[i]; // ó�� ���� Ÿ���� ���� ����
				sum=pre; // ���ϱ�
				for(int j=i+1;j<n;j++) {
					if(gap==(arr[j]-pre)) { // ��� �ִ� Ÿ�ϰ� ���� Ÿ���� ������ ���� ��Ģ��ŭ ���̳���  
						pre=arr[j]; // ���ο� Ÿ�� ���
						sum+=arr[j]; // ���ϱ�
						count++; // ���� Ÿ���� �� ++
					}
					else if(gap<(arr[j]-pre))
						break;
				}
				if(sum>big && count>2) { // ��Ҵ� Ÿ���� ������ ���� ������ ���� ū �պ��� ũ�� ���� Ÿ���� ���� 3�� �̻� 
					big=sum; // �ٽ� ����
				}
			}
			gap++; // �� ++
		}
		System.out.println(big); // ���� ū ���� ���
	}
}
