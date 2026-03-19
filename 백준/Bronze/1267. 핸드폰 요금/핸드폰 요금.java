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

        st = new StringTokenizer(br.readLine());
        int y = 0, m = 0;
        for(int i = 0; i < N; i++){
            int time = Integer.parseInt(st.nextToken());

            for(int j = 0; j < 2; j++){
                if(j == 0){
                    y += 10 * ((time / 30) + 1);
                } else{
                    m += 15 * ((time / 60) + 1);
                }
            }
        }

        if(y < m){
            sb.append('Y');
            sb.append(' ').append(y);
        } else if(y == m){
            sb.append("Y M");
            sb.append(' ').append(y);

        } else{
            sb.append('M');
            sb.append(' ').append(m);

        }

        System.out.println(sb);
    }

}