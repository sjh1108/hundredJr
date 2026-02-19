import java.io.IOException;
import java.io.InputStream;

class Main {
    private static int r;
    private static int c;
    private static int cnt;
    private static boolean[][] blocked;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        r = fs.nextInt();
        c = fs.nextInt();

        blocked = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                blocked[i][j] = fs.nextByte() == 'x';
            }
        }

        for (int i = 0; i < r; i++) {
            if (dfs(i, 0)) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }

    private static boolean dfs(int x, int y) {
        blocked[x][y] = true;

        if (y == c - 2) {
            return true;
        }

        int ny = y + 1;
        int nx = x - 1;
        if (nx >= 0 && !blocked[nx][ny] && dfs(nx, ny)) {
            return true;
        }
        if (!blocked[x][ny] && dfs(x, ny)) {
            return true;
        }
        nx = x + 1;
        return nx < r && !blocked[nx][ny] && dfs(nx, ny);
    }

    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr;
        private int len;

        private FastScanner(InputStream in) {
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

        private int nextInt() throws IOException {
            int ch = read();
            while (ch <= ' ') {
                ch = read();
            }

            int num = 0;
            while (ch > ' ') {
                num = num * 10 + (ch - '0');
                ch = read();
            }
            return num;
        }

        private byte nextByte() throws IOException {
            int ch = read();
            while (ch <= ' ') {
                ch = read();
            }
            return (byte) ch;
        }
    }
}
