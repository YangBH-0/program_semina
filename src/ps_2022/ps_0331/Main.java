package ps_2022.ps_0331;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static int solution(int[] food_times, long k) {
        if(food_times.length>k){
            return (int)(k)%food_times.length+1;
        }else if(Arrays.stream(food_times).sum() <=k){
            return -1;
        }
        int count=0;
        while(true){
            for(int i=0;i<food_times.length;i++){
                if(food_times[i]==0)
                    continue;
                else if(count==k) {
                    return (i+1);
                }
                food_times[i]--;
                count++;
            }
        }
    }
    public static int solution2(int[] food_times, long k) { // batch
        if(Arrays.stream(food_times).sum() <=k){ // k보다 음식량이 적을 경우
            return -1;
        }

        ArrayList<Integer> orders  = new ArrayList<>(); // index
        ArrayList<Integer> values = new ArrayList<>(); // val = left of food
        for(int i=0;i<food_times.length;i++){
            orders.add(i);
            values.add(food_times[i]);
        }
        int min_food; // 가장 작은 배치의 크기
        int pre_min_food=0; // 바로 전의 배치 크기
        long count=0; // 지난 시간 = 먹은 음식의 량
        int index; // food 위치
        int batch=0;
        while(count<k){
            min_food = Collections.min(values); // 가장 작은 음식의 크기 구하기, <- 오래걸림
            batch = min_food-pre_min_food; // 배치 크기 구하기
            if((long) batch * orders.size()+count>k){ // 배치 덩어리보다 k가 적을 경우
                return orders.get(((int) (k-count)) % orders.size())+1; // 순서대로 음식먹다가 나올 경우
            }
            count += (long) batch*orders.size();
            for (int i=0 ;i<orders.size();) {
                index = orders.get(i);
                if (food_times[index] <= min_food) {
                    orders.remove(i);
                    values.remove(i);
                }else{
                    i++;
                }
            }
            pre_min_food=min_food;
        }
        return orders.get((int) (k-count) % orders.size())+1;
    }
    public static int solution3(int[] food_times, long k) { // batch
        if(Arrays.stream(food_times).sum() <=k){ // k보다 음식량이 적을 경우
            return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<food_times.length;i++){
            map.put(food_times[i],i);
        }
        int pre_min_food=0; // 바로 전의 배치 크기

        return 0;
    }

    public static void main(String[] args) {
        int[] ft = {3,1,2};// 1
        int k =5;
        int[] ft2= {1,100}; // 2
        int k2=10;
        int[] ft3 ={3,1,1,1,2,4,3}; // 6
        int k3 = 12;
        int[] ft4 ={4, 3, 5, 6, 2}; // 3
        int k4= 7;
        int[] ft5= {4,1,1,5};
        int k5=4; // 1
        int k6=5; // 4
        int k7=6; //1
        int k8=7; //4
        int[] tc= {1,1,1,1};
        int k9 = 4;//-1
        System.out.println(solution2(ft3,k3));
    }
}
