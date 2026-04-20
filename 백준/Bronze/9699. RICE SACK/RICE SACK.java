import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int riceWeight = Integer.parseInt(st.nextToken());
                if (riceWeight > max) {
                    max = riceWeight;
                }
            }
            System.out.printf("Case #%d: %d\n", i, max);
        }
    }
}