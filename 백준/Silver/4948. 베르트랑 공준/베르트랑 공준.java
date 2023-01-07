import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);


        // pMat 1 : is Prime, 2 : not Prime
        int[] pMat = new int[123456 * 2 + 1];

        // fill pMat
        pMat[1] = 2; pMat[2] = 1;
        for(int i = 3; i < pMat.length; i++){
            if(pMat[i] == 2){
                continue;
            }
            if(i % 2 == 0){
                pMat[i] = 2;
                continue;
            }
            boolean isPrime = true;

            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                pMat[i] = 1;
                for(int j = 2; j * i < pMat.length; j++){
                    pMat[j * i] = 2;
                }
            }
        }

        // count prime num loop
        while(true){
            int N = s.nextInt();
            if(N == 0){
                break;
            }

            int count = 0;
            for(int i = N + 1; i <= 2 * N; i++){
                if(pMat[i] == 1){
                    count++;
                }
            }
            System.out.println(count);
        }

        s.close();
    }
}
