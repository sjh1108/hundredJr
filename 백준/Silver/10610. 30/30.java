import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();
        int[] arr = new int[10];

        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - '0']++;
        }
        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum += i * arr[i];
        }
        if(arr[0] == 0 || sum % 3 != 0){
            System.out.println(-1);
            return;
        }

        for(int i = 9; i >= 0; i--){
            for(int j = 0; j < arr[i]; j++){
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}