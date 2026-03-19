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

        while(flag(N--));

        System.out.println(N + 1);
    }

    static boolean flag(int a){
        while(a > 0){
            if(a % 10 == 4 || a % 10 == 7){
                a /= 10;
            } else{
                return true;
            }
        }

        return false;
    }
}