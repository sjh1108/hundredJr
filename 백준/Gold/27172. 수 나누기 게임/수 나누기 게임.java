import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static int[] hands;
    static int[] point = new int[1_000_001];
    static boolean[] card = new boolean[1_000_001];

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        hands = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            card[tmp] = true;

            hands[i] = tmp;
        }

        for(int i = 0; i < N; i++){
            int tmp = hands[i];

            for(int j = tmp * 2; j <= 1_000_000; j += tmp){
                if(card[j]){
                    point[tmp]++;
                    point[j]--;
                }
            }
        }

        for(int hand: hands){
            sb.append(point[hand]).append(" ");
        }
        System.out.println(sb);
    }
}