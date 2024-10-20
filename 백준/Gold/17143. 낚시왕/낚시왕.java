import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    
    static Shark[][] map;
    static class Shark{
        int x, y, speed, dir, size;
        Shark(int x, int y, int speed, int dir, int size){
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }

    static ArrayList<Shark> sharks = new ArrayList<>();
    static int fishingShark(int pos){
        for(int i = 1; i < N+1; i++){
            if(map[i][pos] != null){
                int size = map[i][pos].size;
                map[i][pos] = null;
                return size;
            }
        }
        return 0;
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static void moveSharks(){
        Queue<Shark> sharks = new LinkedList<>();
        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                if(map[i][j] != null) sharks.add(map[i][j]);
            }
        }

        map = new Shark[N+1][M+1];

        while(!sharks.isEmpty()){
            Shark shark = sharks.poll();
            
            int speed = shark.speed;
            if(shark.dir == 1 || shark.dir == 2) speed %= (2*N-2);
            else speed %= (2*M-2);

            while(speed-- > 0){
                switch(shark.dir){
                    case 1:
                        if(shark.x == 1){
                            shark.dir = 2;
                            shark.x++;
                        } else{
                            shark.x--;
                        }
                        break;
                    case 2:
                        if(shark.x == N){
                            shark.dir = 1;
                            shark.x--;
                        } else{
                            shark.x++;
                        }
                        break;
                    case 3:
                        if(shark.y == M){
                            shark.dir = 4;
                            shark.y--;
                        } else{
                            shark.y++;
                        }
                        break;
                    case 4: 
                        if(shark.y == 1){
                            shark.dir = 3;
                            shark.y++;
                        } else{
                            shark.y--;
                        }
                        break;
                }
            }
            
            if(map[shark.x][shark.y] != null){
                // 움직일 위치의 상어가 더 작다면 그 위치 그대로 들어가기
                if(map[shark.x][shark.y].size < shark.size) map[shark.x][shark.y] = shark;
            }
            // 상어가 존재하지 않는다면 그 위치로 그대로 이동
            else map[shark.x][shark.y] = shark;
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        map = new Shark[N+1][M+1];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            map[x][y] = new Shark(x, y, s, d, size);
        }

        int pos = 1;
        int sum = 0;
        for(int t = 1; t <= M; t++){
            sum += fishingShark(pos++);
            moveSharks();
        }

        System.out.println(sum);
    }
}