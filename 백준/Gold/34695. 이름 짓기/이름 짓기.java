import java.io.*;
import java.util.*;

class Main {
    private static final int MOD = 1_000_000_007;
    private static final int ALPHABET = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] from = new int[k];
        int[] to = new int[k];

        for (int i = 0; i < k; i++) {
            String pair = br.readLine();
            from[i] = pair.charAt(0) - 'a';
            to[i] = pair.charAt(1) - 'a';
        }

        // prev[c]: number of valid names of current length ending with character c
        int[] prev = new int[ALPHABET];
        int[] curr = new int[ALPHABET];

        for (int i = 0; i < k; i++) {
            int end = to[i];
            prev[end]++;
            if (prev[end] >= MOD) {
                prev[end] -= MOD;
            }
        }

        int answer = k % MOD; // length 2 names

        for (int len = 3; len <= n; len++) {
            Arrays.fill(curr, 0);

            for (int i = 0; i < k; i++) {
                int next = to[i];
                int value = curr[next] + prev[from[i]];
                if (value >= MOD) {
                    value -= MOD;
                }
                curr[next] = value;
            }

            int countThisLength = 0;
            for (int c = 0; c < ALPHABET; c++) {
                countThisLength += curr[c];
                if (countThisLength >= MOD) {
                    countThisLength -= MOD;
                }
            }

            answer += countThisLength;
            if (answer >= MOD) {
                answer -= MOD;
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        System.out.println(answer);
    }
}
