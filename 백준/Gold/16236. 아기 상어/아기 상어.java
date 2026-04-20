import java.util.*;
import java.io.*;

class Node{
    int x;
    int y;
    int d;

    Node(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new
    // OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;
    
    static int[][] box, dist;
    static int age = 2, eat = 0, time = 0;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Queue<Node> q = new LinkedList<>();

        box = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                box[i][j] = Integer.parseInt(st.nextToken());

                if(box[i][j] == 9){
                    q.add(new Node(i, j, 0));
                    box[i][j] = 0;
                }
            }
        }

        while(true){
            LinkedList<Node> fish = new LinkedList<>();
            dist = new int[N][N];
            
            while(!q.isEmpty()){
                Node now = q.poll();

                for(int i = 0; i< 4; i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                 
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                        continue;
                    }
                    if(dist[nx][ny] > 0) continue;
                    if(box[nx][ny] > age) continue;

                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    q.add(new Node(nx, ny, dist[nx][ny]));

                    if(box[nx][ny] > 0 && box[nx][ny] < age && box[nx][ny] < 7){
                        fish.add(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
            
            if(fish.isEmpty()){
                System.out.println(time);
                return;
            }

            Node now = fish.get(0);
            for(int i = 1; i < fish.size(); i++){
                Node next = fish.get(i);
                
                if(now.d > next.d){
                    now = next;
                }

                else if(now.d == next.d){

                    if(now.x > next.x){
                        now = next;
                    } 
                    else if(now.x == next.x){
                        if(now.y > next.y){
                            now = next;
                        }
                    }
                }
            }

            time += now.d;
            eat++;
            box[now.x][now.y] = 0;
            if(eat == age){
                eat = 0;
                age++;
            }
            q.add(new Node(now.x, now.y, 0));
        }
    }

}