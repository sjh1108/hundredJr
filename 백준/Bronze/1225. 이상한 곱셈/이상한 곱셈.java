import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken(), s2 = st.nextToken();
        long sum = 0;
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                sum += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }

        System.out.println(sum);
    }
}