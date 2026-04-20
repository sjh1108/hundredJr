import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        int cnt = 0;
        int ans = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                cnt++;
            } else {
                cnt--;

                if(s.charAt(i - 1) == '('){
                    ans += cnt;
                } else{
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}