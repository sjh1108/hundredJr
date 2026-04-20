//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        
        int a = 0;
        for(int i = 1; i < N; i++){
            int sum = i;
            int n = i;
            while(n != 0){
                sum += n % 10;
                n /= 10;
            }
            if(sum == N){
                a = i;
                break;
            }
        }
        System.out.println(a);
    }
}