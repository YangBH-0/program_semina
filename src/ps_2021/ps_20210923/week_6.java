package ps_2021.ps_20210923;

public class week_6 {
	
	public static int[] solution(int[] weights, String[] head2head) {
		int len = weights.length;
		int[] answer = new int[len];
		boxer[] bArr = new boxer[len];
		for (int i = 0; i < len; i++) {
			bArr[i]=new boxer();
			bArr[i].index = i + 1;
			bArr[i].weight = weights[i];
		}
		for (int i = 0; i < len; i++) {
			char[] temp = head2head[i].toCharArray();
			for (int j = 0; j < len; j++) {
				if (temp[j] != 'N') {
					bArr[i].matchcount++;
					if (temp[j] == 'W') {
						bArr[i].wincount++;
						if (weights[i] < weights[j]) {
							bArr[i].heavywin++;
						}
					}
				}
			}
		}
		for (boxer b : bArr) {
			if(b.matchcount==0) {
				b.winrate=0;
			}else {
			b.winrate = (float) b.wincount / b.matchcount;}
		}
		for (int i = 0; i < len-1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (bArr[i].winrate < bArr[j].winrate) {
					swap(bArr,i,j);
				} else if (bArr[i].winrate == bArr[j].winrate) {
					if (bArr[i].heavywin < bArr[j].heavywin) {
						swap(bArr,i,j);
					} else if (bArr[i].heavywin == bArr[j].heavywin) {
						if (bArr[i].weight < bArr[j].weight) {
							swap(bArr,i,j);
						} else if (bArr[i].weight == bArr[j].weight) {
							if (bArr[i].index > bArr[j].index) {
								swap(bArr,i,j);
							}
						}
					}
				}
			}
		}
		for(int i=0;i<len;i++) {
			answer[i]=bArr[i].index;
		}
		return answer;
	}
	public static void check() {
		System.out.println("check");
	}
	public static void swap(boxer[] arr, int n1,int n2) {
		boxer temp = arr[n1];
		arr[n1] = arr[n2];
		arr[n2] = temp;
	}

	public static void main(String[] args) {
		int[] weights = { 50, 80, 75, 120 };
		String[] head2head = { "NLWL", "WNLL", "LWNW", "WWLN" };
		for (int n : solution(weights, head2head)) {
			System.out.print(n + " ");
		}
		System.out.println();
		int[] weights2= {145,92,86};
		String[] head2head2=	{"NLW","WNL","LWN"};
		for (int n : solution(weights2, head2head2)) {
			System.out.print(n + " ");
		}
		System.out.println();
		int[] weights3= {60,70,60};
		String[] head2head3=	{"NNN","NNN","NNN"};
		for (int n : solution(weights3, head2head3)) {
			System.out.print(n + " ");
		}
	}
}
class boxer {
	int index;
	int weight;
	int wincount;
	int matchcount;
	int heavywin;
	float winrate;
}
