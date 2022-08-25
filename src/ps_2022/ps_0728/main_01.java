package ps_2022.ps_0728;

import java.util.ArrayList;

public class main_01 {
    static int limit;
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        char[][] id = new char[user_id.length][];
        char[][] ban= new char[banned_id.length][];
        ArrayList<Integer>[] target = new ArrayList[banned_id.length];
        limit= user_id.length;
        // string to char
        for(int i=0;i<id.length;i++){
            id[i]=user_id[i].toCharArray();
        }
        for(int i=0;i<banned_id.length;i++){
            ban[i]=banned_id[i].toCharArray();
        }
        // pick candidate
        for(int i=0;i< ban.length;i++){
            ArrayList<Integer> candidate = new ArrayList<>(); // 후보
            ArrayList<Integer> dropout; // 탈락 명단
            // same length
            for(int user_index=0;user_index<id.length;user_index++){
                if(id[user_index].length==ban[i].length){
                    candidate.add(user_index);
                }
            }
            // 조건 탐색
            for(int index=0;index<ban[i].length ;index++){
                //System.out.println("i:"+i+", index:"+index+"");

                dropout = new ArrayList<>();
                char ban_id_char= ban[i][index];
                // 탈락 검수
                for(int user_index:candidate){
                    // 문자 비교
                    if(!compare(ban_id_char,id[user_index][index])){
                        dropout.add(user_index);
                    }
                }
                //System.out.println(candidate.toString());
                //System.out.println(dropout.toString());
                // 탈락
                for(int dropout_index:dropout){
                    candidate.remove(candidate.indexOf(dropout_index));
                }
            }

            ArrayList<Integer> temp = new ArrayList<>();
            for(int user_index:candidate){
                temp.add(user_index);
            }
            target[i]= temp;
        }
        // 재귀
        answer=check(target,new ArrayList<>(),0,new ArrayList<>());
        return answer;
    }

    public static boolean compare(char val1,char val2){
        if(val1 =='*'){
            return true;
        }
        else if(val1==val2){
            return true;
        }else{
            return false;
        }
    }

    public static int check(ArrayList<Integer>[] target, ArrayList<Integer> list, int depth,ArrayList<boolean[]> checker){
        int answer=0;
        if(depth == target.length){
            // 똑같은 id 시 배제
            for(int i=0;i<list.size()-1;i++){
                for(int j=i+1;j<list.size();j++){
                    if(list.get(i).equals(list.get(j))){
                        return 0;
                    }}
            }
            // 같은 조합인 경우 배제
            boolean[] temp = new boolean[limit];
            for(int index:list){
                temp[index]=true;

            }
            for(boolean[] past: checker){
                int count=0;
                for(int i=0;i<temp.length;i++){
                    if(past[i] && temp[i]){
                        count++;
                    }
                }
                if(count==list.size()){
                    return 0;
                }
            }
            checker.add(temp);
            return 1;
        }
        // 재귀
        for(int i=0;i<target[depth].size();i++){
            list.add(target[depth].get(i));
            answer+=check(target,list,depth+1,checker);
            list.remove(list.size()-1);
        }
        return answer;
    }
    public static void main(String[] args) {
        String[][] user_ids={
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"},
                {"frodo", "fradi", "crodo", "abc123", "frodoc"}
        };
        String[][] banned_ids={
                {"fr*d*", "abc1**"},
                {"*rodo", "*rodo", "******"},
                {"fr*d*", "*rodo", "******", "******"}
        };

        for(int i=0;i<3;i++){
            System.out.println(i+1+"번쨰 : "+solution(user_ids[i],banned_ids[i]));
        }

    }
}
