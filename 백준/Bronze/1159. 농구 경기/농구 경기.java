import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];
        boolean flag = false;
        while(N-- > 0){
            String s = br.readLine();

            char c = s.charAt(0);
            arr[c - 'a']++;
            if(arr[c - 'a'] >= 5){
                flag = true;
            }
        }

        if(!flag){
            System.out.println("PREDAJA");
            return;
        }
        for(int i = 0; i < 26; i++){
            if(arr[i] >= 5){
                sb.append((char)(i + 'a'));
            }
        }
        System.out.println(sb);
    }
}