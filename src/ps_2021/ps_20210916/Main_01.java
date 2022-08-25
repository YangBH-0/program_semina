package ps_2021.ps_20210916;

import java.util.ArrayList;
public class Main_01 {
	 public static int[] solution(int[] enter, int[] leave) {
	        int len=enter.length;
	        boolean[][] map=new boolean[len+1][len+1];
	        int[] answer =new int[len];
	        ArrayList<Integer> room=new ArrayList<Integer>();
	        int i=0;// enter
	        int j=0;// leave
	        while(j<len) {
	        	if(room.isEmpty()) {
	        		room.add(enter[i++]);
	        	}else if(room.contains(leave[j])) {
	        		for(int n1:room) {
	        			for(int n2:room) {
	        				map[n1][n2]=true;
	        			}
	        		}
	        		room.remove(room.indexOf(leave[j++]));
	        	}else {
	        		room.add(enter[i++]);
	        	}
	        }
	        for(int k=1;k<map.length;k++) {
	        	for(int l=1;l<map[0].length;l++) {
	        		if(k!=l) {
	        			if(map[k][l]) {
	        				answer[k-1]++;
	        			}
	        		}
	        	}
	        }
	        return answer;
	    }
	 public static void main(String[] args) {
		 int[] enter= {1,4,2,3};
		 int[] leave= {2,1,3,4};
		for(int tmp:solution(enter,leave)) {
			System.out.print(tmp+" ");
		}
	}
}
