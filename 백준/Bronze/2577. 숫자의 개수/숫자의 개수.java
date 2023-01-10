//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        long a = 0;
        a = Integer.parseInt(br.readLine());
        for(int i = 0; i < 2; i++){
            a *= Integer.parseInt(br.readLine());
        }
        int[] count = new int[10];
        while(a / 10 != 0 || a != 0){
            count[(int) (a%10)]++;
            a /= 10;
        }
        for(int i = 0; i < 10; i++){
            sb.append(count[i]).append('\n');
        }

        System.out.println(sb);
    }
}