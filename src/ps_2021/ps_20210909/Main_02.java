package ps_2021.ps_20210909;

public class Main_02 {
	
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        int[] checkAlpha=new int[26];// �� ���ĺ� ����
        
        for(String str:orders) {
        	for(char ch:str.toCharArray()) {
        		checkAlpha[ch-65]++;
        	}
        }
        // �ڽ� ���� ���� ���ĺ� ���� �ؾ���.
        // �� �ڽ��� �մ��� �ֹ��� �Ϳ� �ִ��� Ȯ���Ͽ� ��� ��� ������ ī��Ʈ
        // ī��Ʈ ���ں��� ũ�� ������ ��� tmp�� ����
        // ������ answer�� �߰�
        for(int i=0;i<course.length;i++) {
        	String[] tmp= {};
        	
        }
        // sort�ؼ� ��ȯ
        return answer;
    }
	public static void main(String[]args) {
		// course A~Z 
		String[][] testcase_orders= {
				{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
				{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
				{"XYZ", "XWY", "WXA"}
				};
		int[][] testcase_course={
				{2,3,4},
				{2,3,5},
				{2,3,4}
				};
		for(int i=0;i<3;i++) {
			for(String result:solution(testcase_orders[i],testcase_course[i])) {
				System.out.print(result);
			}
			System.out.println();
		}
	}
}
