//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp = new int[31][3];
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        
        int tmp = 0;
        int d = N % 5;
        N -= d;
        if(N < 5){
            sb.append(0);
        }else{
            while(true){
                if(N < 5){
                    sb.append(tmp);
                    break;
                }
                if((N / 5) % 5 == 0){
                    if((N / 25) % 5 == 0) tmp++;
                    tmp++;
                }
                tmp++;
                N -= 5;
            }
        }

        System.out.println(sb);
    }
}