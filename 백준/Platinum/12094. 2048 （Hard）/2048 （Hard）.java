import java.io.*;
import java.util.*;

public class Main {
    private static int N;

    private static int max = 0;

    // 맵의 최대값을 저장하기 위한 메소드
    private static void getMax(int[][] map) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                max = Math.max(max, map[i][j]);
            }
        }
    }

    private static int[][] rotate(int[][] map) {
        int[][] rotated = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N - 1 - i] = map[i][j];
            }
        }

        return rotated;
    }

    private static void pressMap(int[][] map){
        for(int i = 0; i < N; i++){
            int[] t = new int[N];

            int idx = 0;
            for(int j = 0; j < N; j++){
                if(map[j][i] == 0) continue;

                if(t[idx] == 0){
                    t[idx] = map[j][i];
                }
                else if(t[idx] == map[j][i]){
                    t[idx] *= 2;
                    idx++;
                }else{
                    idx++;
                    t[idx] = map[j][i];
                }
            }

            for(int j = 0; j < N; j++){
                map[j][i] = t[j];
            }
        }
    }
    
    private static boolean areMapsEqual(int[][] a, int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void dfs(int[][] map, int depth) {
        if (depth == 10) {
            getMax(map);
            return;
        }

        // --- 최적화 2: 최대값 기반 가지치기 ---
        // 현재 맵에서 가장 큰 블록을 찾습니다.
        int currentMax = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                currentMax = Math.max(currentMax, map[i][j]);
            }
        }
        // 남은 횟수(10 - depth)만큼 2를 곱해도(왼쪽 시프트) 
        // 전역 max보다 작거나 같으면, 더 탐색할 필요가 없습니다.
        if (currentMax * (1 << (10 - depth)) <= max) {
            return;
        }
        // --- 최적화 2 끝 ---


        // 현재 맵(map)을 4번 회전시키며 4방향을 탐색합니다.
        int[][] tempMap = map;
        for (int i = 0; i < 4; i++) {
            // tempMap은 0, 90, 180, 270도 회전된 상태가 됩니다.
            
            // pressMap은 맵을 직접 수정하므로, 깊은 복사본(newMap)을 만듭니다.
            int[][] newMap = new int[N][N];
            for (int r = 0; r < N; r++) {
                // System.arraycopy가 더 빠릅니다.
                System.arraycopy(tempMap[r], 0, newMap[r], 0, N);
            }

            // "위" 방향으로 밀기(pressMap)를 실행합니다.
            pressMap(newMap);

            // --- 최적화 1: 상태가 변하지 않으면 탐색 중단 ---
            // pressMap을 하기 전(tempMap)과 한 후(newMap)의 상태가 다를 때만 
            // 다음 깊이로 재귀 호출을 합니다.
            if (!areMapsEqual(tempMap, newMap)) {
                dfs(newMap, depth + 1);
            }
            // --- 최적화 1 끝 ---

            // 다음 방향(왼쪽, 아래, 오른쪽)을 탐색하기 위해 맵을 회전시킵니다.
            tempMap = rotate(tempMap);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }
        int[][] map = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, 0);

        System.out.println(max);
    }
}