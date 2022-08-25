package ps_2021.ps_20210708;

public class Main_02 {
	static int[] function(int gcd, int lcm) {
		// n1 * n2 = LCM * GCD
		// n2 = LCM * GCD / n1
		int[] result = { 100000000, 100000000 };
		int n1 = gcd;
		int n2;
		while (n1 <= lcm) {
			n2=(lcm*gcd)/n1;
			// �� ���� �ּ� ����� ã�� �κ� 
			if(n1* n2==lcm*gcd && gcd(n1,n2)==gcd) {
				if(n1+n2<result[0]+result[1]) {
					result[0]=n1;
					result[1]=n2;
				}
			}
			n1+=gcd;
		}
		return result;
	}
	
	static int gcd(int a, int b){
	    int tmp, n;
	    if(a<b){
	        tmp = a;
	        a = b;
	        b = tmp;
	    }
	    while(b!=0){
	        n = a%b;
	        a = b;
	        b = n;
	    }
	    return a;
	}

	public static void main(String[] args) {
		int n1 = 6, n2 = 180;
		for (int i : function(n1, n2)) {
			System.out.println(i);
		}
		for (int i: function(2, 86486400)) {
			System.out.println(i);
		}
	}
}
