import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        char[] arr = {'A', 'B', 'C', 'D', 'E', 'G', 'I', 'M', 'R'};

        char[] input = br.readLine().toCharArray();
        for(int i = 0; i < input.length; i++) {
            boolean flag = false;
            for(int j = 0; j < arr.length; j++) {
                if(input[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                sb.append(input[i]);
            }
        }

        System.out.println(sb);
    }
}