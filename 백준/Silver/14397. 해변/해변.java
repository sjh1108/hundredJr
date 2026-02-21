import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int[][] evenDir = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 0}};
        int[][] oddDir = {{-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};
        
        int ans = 0;
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == '#') {
                    int[][] dirs = (r % 2 == 0) ? evenDir : oddDir;
                    
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        
                        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            if (map[nr][nc] == '.') {
                                ans++;
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(ans);
    }
}