import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[X][Y];
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for(int i = 0; i < X; i++){
                for(int j = 0; j < Y; j++){
                    if(map[i][j]) continue;

                    map[i][j] = true;
                    cnt++;
                    
                    int nx = i + x;
                    int ny = j + y;
                    if(nx >= X || ny >= Y) continue;

                    map[nx][ny] = true;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
