import java.io.*;
import java.util.*;

class Main {
    static final int DIR_COUNT = 5;
    static final int[] DX = {0, 0, 1, 0, -1};
    static final int[] DY = {0, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] prevDp = new long[DIR_COUNT];
        Arrays.fill(prevDp, Long.MAX_VALUE);
        prevDp[0] = 0; // DX[0]=0, DY[0]=0 → 빵집은 제자리 고정, 비용 0

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prevX = Integer.parseInt(st.nextToken());
        int prevY = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            long[] curDp = new long[DIR_COUNT];
            Arrays.fill(curDp, Long.MAX_VALUE);

            for (int cur = 0; cur < DIR_COUNT; cur++) {
                for (int prev = 0; prev < DIR_COUNT; prev++) {
                    if (prevDp[prev] == Long.MAX_VALUE) continue;
                    long dist = Math.abs((curX + DX[cur]) - (prevX + DX[prev]))
                              + Math.abs((curY + DY[cur]) - (prevY + DY[prev]));
                    curDp[cur] = Math.min(curDp[cur], prevDp[prev] + dist);
                }
            }

            prevDp = curDp;
            prevX = curX;
            prevY = curY;
        }

        long answer = Long.MAX_VALUE;
        for (int d = 0; d < DIR_COUNT; d++) {
            answer = Math.min(answer, prevDp[d]);
        }
        System.out.println(answer);
    }
}