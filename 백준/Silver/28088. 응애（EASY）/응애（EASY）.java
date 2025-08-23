import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[2][N];
        for (int i = 0; i < M; i++) {
            arr[0][Integer.parseInt(br.readLine())] = true;
        }

        int n = N - 1;
        int nn = N - 2;
        int time = 0;
        while (time < K) {
            int t = time % 2;
            int td = (t + 1) % 2;
            for (int i = 1; i < N - 1; i++) {
                if ((arr[t][i - 1] && arr[t][i + 1]) || (!arr[t][i - 1] && !arr[t][i + 1])) arr[td][i] = false;
                else arr[td][i] = true;
            }
            if ((arr[t][n] && arr[t][1]) || (!arr[t][n] && !arr[t][1])) arr[td][0] = false;
            else arr[td][0] = true;
            if ((arr[t][0] && arr[t][nn]) || (!arr[t][0] && !arr[t][nn])) arr[td][n] = false;
            else arr[td][n] = true;

            time++;
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[time % 2][i]) cnt++;
        }
        System.out.print(cnt);

    }

}