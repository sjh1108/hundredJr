import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] arr, ans;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        if(n == 0){
            System.out.println(M);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));
        
        int[][] map = new int[M][];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            map[i] = new int[m];
            for(int j = 0; j < m; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = M;
        boolean visited[] = new boolean[M];
        boolean flag = true;
        while(flag && cnt > 0){
            flag = false;

            for(int i = 0; i < M; i++){
                if(visited[i]) continue;
                
                for(int j = 0; j < map[i].length; j++){
                    if(set.contains(map[i][j])){
                        visited[i] = true;
                        flag = true;
                        cnt--;
                        for(int k = 0; k < map[i].length; k++){
                            set.add(map[i][k]);
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}