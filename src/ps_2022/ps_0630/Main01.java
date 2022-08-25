package ps_2022.ps_0630;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Main01 {
    public static int[] solution(String[] gems) {
        int[] answer = {1,gems.length};
        LinkedHashSet<String> temp_set=new LinkedHashSet<>();
        temp_set.addAll(List.of(gems));
        LinkedList<String> kinds= new LinkedList<>(temp_set);
        boolean[] checked;
        int startIdx=0;
        int lastIdx=gems.length-kinds.size()+1;
        int endIdx= gems.length;
        int maxLen= gems.length;
        int idx;
        int gemIdx;
        int gemCount;
        int lenCount;

        while(startIdx<lastIdx){
            idx=startIdx;
            checked=new boolean[kinds.size()];
            gemCount=0;
            lenCount=0;

            while(idx<endIdx & gemCount< kinds.size()){

                gemIdx=kinds.indexOf(gems[idx]);
                lenCount++;
                if(lenCount>maxLen){
                    break;
                }
                if(!checked[gemIdx]){
                    gemCount++;
                    checked[gemIdx]=true;
                }
                idx++;
            }
            if(lenCount<maxLen & gemCount== kinds.size()){
                maxLen=lenCount;
                answer[0]=startIdx+1;
                answer[1]=idx;
            }
            startIdx++;
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
