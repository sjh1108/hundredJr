import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];
        for(int i = 0; i < N; i++){
            String s = br.readLine();

            int len = s.length();
            for(int j = 0; j < len; j++){
                alpha[s.charAt(j) - 'A'] += (int)Math.pow(10, len - j - 1);
            }
        }

        Arrays.sort(alpha);
        
        int num = 9;
        int ans = 0;
        int i = 25;
        while(alpha[i] != 0){
            ans += alpha[i--] * num--;
        }
        System.out.println(ans);
    }
}