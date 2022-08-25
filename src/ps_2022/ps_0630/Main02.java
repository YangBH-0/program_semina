package ps_2022.ps_0630;

import java.util.*;

public class Main02 {
    public static int[] solution(String[] gems) {
        int[] answer = {1,gems.length};
        LinkedHashSet<String> temp_set=new LinkedHashSet<>();
        temp_set.addAll(List.of(gems));
        LinkedList<String> kinds= new LinkedList<>(temp_set);
        HashMap<String,Integer> map= new HashMap<>();
        boolean[] checked=new boolean[kinds.size()];
        int min,max;
        int count=0;
        int len=checked.length;
        int val;
        int i;
        for(i=0;i<gems.length;i++){
            val=kinds.indexOf(gems[i]);
            map.put(gems[i],i);
            if(!checked[val]){
                count++;
                checked[val]=true;
            }
            if(count==len){
                break;
            }
        }
        min=Collections.min(map.values());
        max=Collections.max(map.values());
        answer[0]=min+1;
        answer[1]=max+1;
        int idx;
        int maxLen=max-min+1;
        int tempLen;
        i++;
        while(i< gems.length){
            map.put(gems[i],i);
            min=Collections.min(map.values());
            max=Collections.max(map.values());
            tempLen=max-min+1;
            if(tempLen<maxLen){
                maxLen=tempLen;
                answer[0]=min+1;
                answer[1]=max+1;
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[][] gems = {
                {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"},
                {"AA", "AB", "AC", "AA", "AC"},
                {"XYZ", "XYZ", "XYZ"},
                {"ZZZ", "YYY", "NNNN", "YYY", "BBB"}
        };
        for(String[] gem:gems){
            for(int i:solution(gem)){
                System.out.println(i);
            }
            System.out.println("-0-");

        }

    }
}
