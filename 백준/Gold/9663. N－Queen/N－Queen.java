import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;

    private static int cnt;
    private static boolean[] sero;
    private static boolean[] lUp;
    private static boolean[] rUp;
    private static void dfs(int depth){
        if(depth == N){
            ++cnt;
            return;
        }

        for(int i = 0; i < N; i++){
            if(sero[i] || rUp[depth+i] | lUp[depth - i + (N-1)]){
                continue;
            }

            sero[i] = true;
            rUp[depth + i] = true;
            lUp[depth - i + (N-1)] = true;

            dfs(depth + 1);

            sero[i] = false;
            rUp[depth + i] = false;
            lUp[depth - i + (N-1)] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sero = new boolean[N];
        lUp = new boolean[(N << 1) - 1];
        rUp = new boolean[(N << 1) - 1];

        dfs(0);

        System.out.println(cnt);
    }
}