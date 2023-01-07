import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);


        // pMat 1 : is Prime, 2 : not Prime
        int[] pMat = new int[10000];

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

        int N = s.nextInt();
        for(int i = 0; i < N; i++){
            int n = s.nextInt();


            int a = 0, b = 0;
            for(int q = n / 2; q > 1; q--){
                if(pMat[q] == 2) continue;

                int w = n - q;
                if(pMat[w] == 2) continue;

                if(q + w == n){
                    a = q;
                    b = w;
                    break;
                }
            }

            System.out.println(a + " " + b);
        }

        s.close();
    }
}
