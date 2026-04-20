import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int M = s.nextInt();
        int N = s.nextInt();

        int min = 0, sum = 0;
        for(int i = M; i <= N; i++){

            boolean isPrime = true;

            if(i == 1){
                continue;
            }

            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                if(min == 0){
                    min = i;
                }
                sum += i;
            }
        }

        if(min == 0){
            System.out.println(-1);
        } else{
            System.out.println(sum);
            System.out.println(min);
        }

        s.close();
    }
}
