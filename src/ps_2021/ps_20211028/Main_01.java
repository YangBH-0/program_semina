package ps_2021.ps_20211028;

public class Main_01 {
	static boolean[] check;
	public static  int solution(int k, int[][] dungeons) {
	        int answer = -1;
	        int length=dungeons.length;
	        check=new boolean[length];
	        answer=func(k,dungeons,0);
	        return answer;
	    }
	public static int func(int k,int[][] dungeons,int deapth) {
		if(k<=0 || dungeons.length==deapth)
			return deapth;
		int big=0;
		int tmp;
		 for(int i=0;i<dungeons.length;i++) {
			 if(!check[i] && k>=dungeons[i][0]) {
				 check[i]=true;
				 tmp=func(k-dungeons[i][1],dungeons,deapth+1);
				 if(big<tmp) {
					 big=tmp;
				 }
				 check[i]=false;
			 }
		 }
		 return big==0?deapth:big;
	 }
	 public static void main(String[] args) {
		int[][] dungeons= {{80,20},{50,40},{30,10}};
		int k=80;
		System.out.println(solution(k,dungeons));
	}
}
