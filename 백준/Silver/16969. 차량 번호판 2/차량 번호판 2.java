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
        char[] arr = s.toCharArray();
        int len = s.length();
        long ans = 1;
        if(arr[0] == 'd') ans = 10;
        else ans = 26;

        for(int i = 1; i < len; i++){
            if(arr[i] == 'd'){
                if(arr[i-1] == 'd') ans *= 9;
                else ans *= 10;
            }else{
                if(arr[i-1] == 'c') ans *= 25;
                else ans *= 26;
            }
            ans %= 1000000009;
        }


        System.out.println(ans);
    }
}