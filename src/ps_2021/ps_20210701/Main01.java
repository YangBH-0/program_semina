package ps_2021.ps_20210701;

public class Main01 {
	static char[] initPartici(int n) {
		char[] result=new char[n];
		//65~90
		for (int i = 0; i < n; i++) {
			result[i] = (char) (65 + i);
		}
		return result;
	}
	static char[] initCharArr(char c,int n) {
		char[] result= new char[n];
		for(int i=0;i<n;i++) {
			result[i]=c;
		}
		return result;
	}
	static char[] ghost_leg(char[][] ladder,char[] participant) {
		char[]result=new char[participant.length];
		for(int i=0;i<participant.length;i++) {
			int index=i;
			for(int j=0;j<ladder.length;j++) {
				//��ٸ� ������ Ȯ��
				if(index<ladder[0].length && ladder[j][index]=='-') {
					index++;
				}
				//��ٸ� ���� Ȯ��
				else if(index>0 && ladder[j][index-1]=='-'){
					index--;
				}
			}
			result[index]=participant[i];
		}
		return result;
	}
	static char[] whatisanswer(int k,int n, char[] result,char[][] ladder) {

		char[] hidden= new char[k-1]; // ������ �κ� 
		char[] participant = initPartici(k); // ������ �����ϴ� ��
		char[] answer=initCharArr('x',k-1); // ����
		// ������ �κ� ������ ��ٸ� Ÿ��
		char[][] temp = new char[n/2][ladder[0].length];
		for(int i=0;i<n/2;i++) {
			temp[i]=ladder[i];
		}
		char[] forward=ghost_leg(temp,participant);
		// ������ �κ� �������������� ��ٸ� Ÿ��
		for(int i=n-1;i>n/2;i--) {
			temp[n-i-1]=ladder[i];
		}
		char[] backward=ghost_leg(temp,result);
		// �� ���� ����� ���Ͽ� ��ٸ� ����
		for(int i=0;i<k-1;i++) {
			if(forward[i]==backward[i]) {
				hidden[i]='*';
			}else {
				hidden[i]='-';
				i++;
				if(i!=k-1)
					hidden[i]='*';
			}
		}
		// ���� ��ٸ��� ������ ���� 
		temp= new char[1][];
		temp[0]=hidden;
		if(String.valueOf(ghost_leg(temp,forward)).equals(String.copyValueOf(backward))) {
			// ���ٸ� ����� �� ��ٸ������� �������� ����
			answer=hidden;
		}
		// ���� ���
		return answer;
	}
	public static void main(String[] args) {
		char[] result1 = "ACGBEDJFIH".toCharArray();
		char[][] ladder1 = {
				"*-***-***".toCharArray(),
				"-*-******".toCharArray(),
				"?????????".toCharArray(),
				"-**-***-*".toCharArray(),
				"**-*-*-*-".toCharArray() 
				};
		char[] result2="CGBEDJFKIHA".toCharArray(); // ���� ���
		char[][] ladder2={  // ��ٸ�
		"*-***-****".toCharArray(), 
		"-*-******-".toCharArray(),  
		"??????????".toCharArray(),  
		"-**-***-*-".toCharArray(),  
		"**-*-*-*-*".toCharArray()};
		
		System.out.println(whatisanswer(10,5,result1,ladder1));
		System.out.println(whatisanswer(11,5,result2,ladder2));
	}
}
