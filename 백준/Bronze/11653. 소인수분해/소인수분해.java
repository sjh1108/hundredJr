import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int N = s.nextInt();

        if(N == 1){
            System.exit(0);
        }
        int n = N;
        boolean isPrime = true;
        for(int i = 2; i <= N / 2; i++){
            if(n % i == 0){
                if(i == Math.sqrt(N)){
                    System.out.println(i);
                    System.out.println(i);
                    isPrime = false;
                    break;
                }
                System.out.println(i);
                n /= i;
                i = 1;
                isPrime = false;
                if(n == 1){
                    break;
                } else{
                    continue;
                }
            }
        }
        if(isPrime){
            System.out.println(N);
        }

        s.close();
    }
}
