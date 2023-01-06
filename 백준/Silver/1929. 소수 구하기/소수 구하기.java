import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int M = s.nextInt();
        int N = s.nextInt();

        //pMat 1 : Prime / 2 : not Prime
        int[] pMat = new int[N + 1];

        if(M == 1){
            pMat[1] = 2;
            M = 2;
        }

        if(M == 2){
            System.out.println(2);
        }
        
        for(int i = 3; i <= N; i++){
            boolean isPrime = true;
            if(i % 2 == 0){
                pMat[i] = 2;
                continue;
            }

            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                if(i >= M){
                    System.out.println(i);
                }
                pMat[i] = 1;
                for(long a = i; a < N + 1; a *= i){
                    pMat[(int) a] = 2;
                }
            } else{
                pMat[i] = 2;
            }
        }
        

        s.close();
    }
}
