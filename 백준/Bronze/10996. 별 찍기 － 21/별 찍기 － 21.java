import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println("*");
            return;
        }

        char[][] arr = new char[N][2];
        for(int i = 0; i < N; i++){
            if(i % 2 == 0){
                arr[i][0] = '*';
                arr[i][1] = ' ';
            } else {
                arr[i][0] = ' ';
                arr[i][1] = '*';
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int j = 0; j < 2; j++){
            for(int i = 0; i < N; i++){
                ans.append(arr[i][j]);
            }
            if(j == 0) ans.append("\n");
        }

        for(int i = 0; i < N; i++){
            sb.append(ans.toString()).append("\n");
        }

        System.out.println(sb);
    }
}