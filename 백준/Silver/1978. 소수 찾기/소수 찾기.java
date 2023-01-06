import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            int num = s.nextInt();

            boolean isPrime = true;

            if(num == 1){
                continue;
            }
            for(int j = 2; j <= Math.sqrt(num); j++){
                if(num % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                cnt++;
            }
        }

        System.out.println(cnt);

        s.close();
    }
}
