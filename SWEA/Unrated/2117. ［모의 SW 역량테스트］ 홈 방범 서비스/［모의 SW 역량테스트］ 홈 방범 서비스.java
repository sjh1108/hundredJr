import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<int[]> home = new ArrayList<>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    int tmp = Integer.parseInt(st.nextToken());

                    if(tmp == 1) {
                        home.add(new int[]{i, j});
                    }
                }
            }

            int maxHome = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    for (int k = 1; k <= N+1; k++) {
                        int cnt = 0;
                        for (int[] arr : home) {
                            if (Math.abs(arr[0] - x) + Math.abs(arr[1] - y) <= k - 1) {
                                cnt++;
                            }
                        }
                        int cost = k * k + (k - 1) * (k - 1);
                        if (cnt * M >= cost) {
                            maxHome = Math.max(maxHome, cnt);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + maxHome);
        }
    }
}