package ps_2021.ps_20210909;


public class Main_01 {
	
	public static String solution(String new_id) {
		String answer="";
		String tmp;
		tmp=new_id.toLowerCase();
		for(char ch:tmp.toCharArray()) {
			// 48~57(0~9) 77(-) (_) (.) 
			if(Character.isLetterOrDigit(ch) || ch=='-'|| ch=='_'|| ch=='.') {
				answer+=ch;
			}
		}
		while(answer.contains("..")) {
			answer=answer.replace("..",".");
		};
		if(answer.startsWith(".")) {
			answer=answer.substring(1);
		}
		if(answer.endsWith(".")) {
			answer=answer.substring(0,answer.length()-1);
		}
		if(answer.isEmpty()) {
			answer+="a";
		}
		if(answer.length()>=16) {
			answer=answer.substring(0,15);
			if(answer.endsWith(".")) {
				answer=answer.substring(0,answer.length()-1);
			}
		}
		while(answer.length()<3) {
			answer+=answer.charAt(answer.length()-1);
		}
		return answer;
	}
	public static void main(String []args) {
		String[] testcases={"...!@BaT#*..y.abcdefghijklm", 
				"z-+.^.", 
				"=.=",
				"123_.def",  
				"abcdefghijklmn.p"
				};
		for(String testcase:testcases) {
			System.out.println(solution(testcase));
		}
	}

}
