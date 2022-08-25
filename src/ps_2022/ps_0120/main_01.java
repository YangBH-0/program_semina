package ps_2022.ps_0120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class main_01 {

    public static int solution(int[]arr){
        int answer=0;
        int len=arr.length;
        int right=0;
        int left=len-1;
        List<Integer> sequence = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int temp;
        System.out.println(sequence);
        while(right<left){
            System.out.println(right);
            if(sequence.get(right)!=right+1){
                temp=sequence.remove(sequence.indexOf(right+1));
                sequence.add(right,temp);
                System.out.println(sequence);
                answer++;
            }
            if(sequence.get(left)!=left+1){
                temp=sequence.remove(sequence.indexOf(left+1));
                sequence.add(left,temp);
                System.out.println(sequence);
                answer++;
            }
            right+=1;
            left-=1;
        }
        return answer;
    }
    public static int solution2(int[] arr){
        int answer=0;
        int len=arr.length;
        List<Integer> sequence = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int temp;
        int mid = (len+1)/2;
        // right priority
        insert(sequence,mid,sequence.indexOf(mid-1)+1);
        answer++;
        int right=mid-1;
        int next=right;
        while(next>0){
            next=right-1;
            if(sequence.indexOf(right)<sequence.indexOf(next)){
                insert(sequence,next,sequence.indexOf(right));
                answer++;
            }
            right--;
        }
        
        int[] count= new int[2];
        int left = mid+1;

        System.out.println("left start mid");
        List<Integer> leftSide = new ArrayList<>(sequence);
        System.out.println("origin"+leftSide);
        // mid+1부터
        while(next<len){
            next=left+1;
            if(leftSide.indexOf(left)>leftSide.indexOf(next)){
                insert(leftSide,next,leftSide.indexOf(left));
                count[0]++;
            }

            left++;
        }
        left = len;
        // 끝부분부터
        leftSide=new ArrayList<>(sequence);
        System.out.println("left start end");
        System.out.println("origin"+leftSide);
        while(next>mid){
            next=left-1;
            if(leftSide.indexOf(left)<leftSide.indexOf(next)){
                insert(leftSide,next,leftSide.indexOf(left));
                count[1]++;
            }
            left--;
        }
        answer+=Math.min(count[0], count[1]);
        return answer;
    }
    public static void insert(List<Integer> sequence, int val,int index){
        int temp=sequence.remove(sequence.indexOf(val));
        sequence.add(index,temp);
        System.out.println(sequence);
    }

    public static void main(String[] args) {
        int n=7;
        int[] children={3,7,5,2,6,1,4};
        System.out.println(solution2(children));
    }
}
