import java.io.*;
import java.util.*;

class Main {
    private static final int MOD = 1_000_000_007;
    private static final int ALPHABET = 26;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int k = fs.nextInt();
        int n = fs.nextInt();

        // M[to][from] = 1 if transition from -> to is allowed.
        int[][] m = new int[ALPHABET][ALPHABET];
        // base[end] = number of length-2 names ending with end.
        int[] base = new int[ALPHABET];

        for (int i = 0; i < k; i++) {
            int u = fs.nextLowerAlpha();
            int v = fs.nextLowerAlpha();
            m[v][u] = 1;
            base[v]++;
        }

        long terms = n - 1L; // number of terms in I + M + ... + M^(n-2)
        int[][] resultPow = identity();
        int[][] resultSum = new int[ALPHABET][ALPHABET];

        int[][] blockPow = m;
        int[][] blockSum = identity(); // sum for one term block: I

        while (terms > 0) {
            if ((terms & 1L) != 0L) {
                resultSum = add(resultSum, multiply(resultPow, blockSum));
                resultPow = multiply(resultPow, blockPow);
            }

            blockSum = add(blockSum, multiply(blockPow, blockSum));
            blockPow = multiply(blockPow, blockPow);
            terms >>= 1;
        }

        int[] totalByEnd = multiply(resultSum, base);
        int answer = 0;
        for (int c = 0; c < ALPHABET; c++) {
            answer += totalByEnd[c];
            if (answer >= MOD) {
                answer -= MOD;
            }
        }
        System.out.println(answer);
    }

    private static int[][] identity() {
        int[][] id = new int[ALPHABET][ALPHABET];
        for (int i = 0; i < ALPHABET; i++) {
            id[i][i] = 1;
        }
        return id;
    }

    private static int[][] add(int[][] a, int[][] b) {
        int[][] out = new int[ALPHABET][ALPHABET];
        for (int i = 0; i < ALPHABET; i++) {
            for (int j = 0; j < ALPHABET; j++) {
                int value = a[i][j] + b[i][j];
                if (value >= MOD) {
                    value -= MOD;
                }
                out[i][j] = value;
            }
        }
        return out;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] out = new int[ALPHABET][ALPHABET];
        for (int i = 0; i < ALPHABET; i++) {
            for (int k = 0; k < ALPHABET; k++) {
                if (a[i][k] == 0) {
                    continue;
                }

                long left = a[i][k];
                for (int j = 0; j < ALPHABET; j++) {
                    if (b[k][j] == 0) {
                        continue;
                    }

                    long value = out[i][j] + left * b[k][j];
                    out[i][j] = (int) (value % MOD);
                }
            }
        }
        return out;
    }

    private static int[] multiply(int[][] a, int[] v) {
        int[] out = new int[ALPHABET];
        for (int i = 0; i < ALPHABET; i++) {
            long sum = 0L;
            for (int j = 0; j < ALPHABET; j++) {
                if (a[i][j] == 0 || v[j] == 0) {
                    continue;
                }
                sum += (long) a[i][j] * v[j];
            }
            out[i] = (int) (sum % MOD);
        }
        return out;
    }

    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= 32);

            int value = 0;
            while (c > 32) {
                value = value * 10 + (c - '0');
                c = read();
            }
            return value;
        }

        int nextLowerAlpha() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= 32);
            return c - 'a';
        }
    }
}
