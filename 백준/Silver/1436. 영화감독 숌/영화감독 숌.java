//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        
        
        int n = 1;

        for(int i = 666; i < 2147483647 && n <= N; i++){
            if(i % 1000 == 666){
                if(n == N){
                    System.out.println(i);
                }
                n++;
            } else if((i % 10000) / 10 == 666){
                if(n == N){
                    System.out.println(i);
                }
                n++;
            } else if((i % 100000) / 100 == 666){
                if(n == N){
                    System.out.println(i);
                    break;
                }
                n++;
            } else if((i % 1000000) / 1000 == 666){
                if(n == N){
                    System.out.println(i);
                    break;
                }
                n++;
            } else if((i % 10000000) / 10000 == 666){
                if(n == N){
                    System.out.println(i);
                    break;
                }
                n++;
            }
        }
    }
}