import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M, K;
    
    static int[] arr;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        N = 0; M = 0; K = 0;

        boolean isFirst = true;
        boolean isMinus = true;
        boolean lastC = true;
        int len = s.length();
        char c;

        for(int i = 0; i < len - 1; i++){
            c = s.charAt(i);

            if(c == '+'){
                lastC = true;
                if(isFirst){
                    N += K;
                    K = 0;
                    isFirst = false;
                    continue;
                }
                M += K;
                K = 0;
                continue;
            }
            else if (c == '-'){
                lastC = false;
                if(isFirst){
                    N += K;
                    K = 0;
                    isFirst = false;
                    isMinus = false;
                    continue;
                }
                if(isMinus){
                    M += K;
                    N += M;
                    M = 0;
                    K = 0;
                    isMinus = false;
                    continue;
                }
                M += K;
                N -= M;
                M = 0;
                K = 0;
            }
            else{
                int tmp = c - '0';

                K = (K * 10) + tmp;
            }
        }
        int tmp = s.charAt(len - 1)- '0';

        K = (K * 10) + tmp;

        if(lastC){
            M += K;
            if(isFirst){
                N = K;
            }
            else if(!isMinus){
                N -= M;
            } else{
                N += M;
            }
        } else{
            N -= K;
        }

        System.out.println(N);
    }
}