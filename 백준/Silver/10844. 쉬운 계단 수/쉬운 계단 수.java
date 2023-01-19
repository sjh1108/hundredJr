import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] f;
    static long[][] arr;
    final static long mod = 1000000000;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());


        arr = new long[N + 1][10];

        for(int i = 1; i < 10; i++){
            arr[1][i] = 1;
        }

        for(int i = 2; i < N + 1; i++){

            for(int j = 0; j < 10; j++){

                if(j == 0){
                    arr[i][0] = arr[i - 1][1] % mod;
                } 
                
                else if(j == 9){
                    arr[i][9] = arr[i - 1][8] % mod;
                }

                else{
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % mod;
                }
            }
        }

        long n = 0;

        for(int i = 0; i < 10; i++){
            n += arr[N][i];
        }

        System.out.println(n % mod);
        
    }

    static void func(){
    }
}