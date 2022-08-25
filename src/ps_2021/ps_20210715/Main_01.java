package ps_2021.ps_20210715;

import java.util.ArrayList;
public class Main_01 {
	private static boolean[] visited;
	private static ArrayList<Integer> list;
	private static int[] BalanceWeightarr;
	public static void dfs(int sum) {
		if(!list.contains(sum))
			list.add(sum);
		for(int i=0;i<BalanceWeightarr.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(sum+BalanceWeightarr[i]);
				visited[i]=false;
			}
		}
	}
	public static int function(int n, int[] arr) {
		list=new ArrayList<Integer>();
		visited=new boolean[arr.length];
		BalanceWeightarr=arr;
		dfs(0);
		int i=1;
		while(true) {
			if(!list.contains(i)) {
				return i;
			}
			i++;
		}
	}
	public static void main(String[]args) {
		int n=7;
		int[] arr= {3,1,6,2,7,30,1};
		System.out.println(function(n,arr));
	}
}
