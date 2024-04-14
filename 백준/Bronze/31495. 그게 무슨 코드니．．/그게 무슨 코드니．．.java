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
        int len = s.length();
        if(s.charAt(0) == '"' && s.charAt(len-1) == '"' && len <= 2) {
            System.out.println("CE");
        } else if(s.charAt(0) == '"' && s.charAt(len-1) == '"'){
            System.out.println(s.substring(1, len-1));
        }
        else {
            System.out.println("CE");
        }
    }
}