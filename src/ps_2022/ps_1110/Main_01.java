package ps_2022.ps_1110;

public class Main_01 {
    public static int isPrime(int n){
        if(n==1){
            return 0;
        }
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
    public static String convertNtoK(int n,int k){
        String str = "";
        while(n>k){
            str=n%k+str;
            n/=k;
        }
        str= n+str;
        return str;
    }
    public static int k(int n,int k){
        int count=0;

        String str = convertNtoK(n,k);
        System.out.println(str);
        for(String temp: str.split("0")){
            if(isPrime(Integer.parseInt(temp))==1){
                System.out.println(temp);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(k(437674,3));
    }
}
