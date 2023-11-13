import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int num = 1;
        int cnt = 0;

        int sum = 0;
        int msum = 0;
        for(int i = 1; i <= M; i++){
            sum += num;
            if(i == N - 1) msum = sum;

            cnt++;
            if(cnt == num){
                num++;
                cnt = 0;
            }
        }

        System.out.println(sum - msum);
    }
}