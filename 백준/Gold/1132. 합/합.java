import java.io.*;
import java.util.*;

class Main {
    private static long ans = 0;

    private static long[] alpha = new long[10];
    private static boolean[] notZero = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            
            notZero[input.charAt(0) - 'A'] = true;
            
            long k = 1;
            for (int j = input.length() - 1; j >= 0; j--) {
                alpha[input.charAt(j) - 'A'] += k;
                k *= 10;
            }
        }

        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            if (alpha[i] == 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            long min = Long.MAX_VALUE;
            int idx = -1;

            for (int i = 0; i < 10; i++) {
                if (!notZero[i] && alpha[i] < min) {
                    min = alpha[i];
                    idx = i;
                }
            }
            if (idx != -1) {
                alpha[idx] = 0;
            }
        }

        Arrays.sort(alpha);

        int mul = 0;
        for (int i = 0; i < 10; i++) {
            ans += alpha[i] * mul++;
        }

        System.out.println(ans);
    }
}