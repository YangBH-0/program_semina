package programmers.codingtest;
import java.util.LinkedList;
public class stackQueue {

    public static int printerSolution(int[] p, int l) {
        int len=p.length;
        LinkedList<Integer> queue = new LinkedList<>();
        int result[]=new int[len];
        for(int i=0;i<len;i++){
            queue.add(i);
        }
        for(int i=0;i<len;i++){

            int idx=0;
            while(idx<queue.size()){
                if(p[queue.get(0)]<p[queue.get(idx)]) {
                    queue.add(queue.poll());
                    idx=0;
                }
                idx++;
            }
            result[i]=queue.poll();
        }
        for(int i=0;i<len;i++){
            if(result[i]==l){
                return i+1;
            }
        }
        return result[l];
    }

    public static void main(String[] args) {
        int[] data={
                2,1,3,2
        };
        printerSolution(data,2);
    }
}
