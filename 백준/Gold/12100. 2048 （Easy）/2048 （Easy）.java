import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

	static int max = 0;

	static class Map{
		int[][] map;
		int cnt;
        public Map(int[][] map){
            this(map, 0);
        }
		public Map(int[][] map, int cnt){
            this.map = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    this.map[i][j] = map[i][j];
                }
            }
			this.cnt = cnt;
		}

		public int getMax(){
			int max = 0;
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					max = Math.max(max, map[i][j]);
				}
			}
			return max;
		}

		public int[][] goLeft(){
            int[][] tmp = new int[N][N];
            
            for(int i = 0; i < N; i++){
                int[] t = new int[N];

                int idx = 0;
                for(int j = 0; j < N; j++){
                    if(map[i][j] == 0) continue;

                    if(t[idx] == 0){
                        t[idx] = map[i][j];
                    }
                    else if(t[idx] == map[i][j]){
                        t[idx] *= 2;
                        idx++;
                    }else{
                        idx++;
                        t[idx] = map[i][j];
                    }
                }

                tmp[i] = t.clone();
            }

            return tmp;
		}
        public int[][] goRight(){
            int[][] tmp = new int[N][N];
            
            for(int i = 0; i < N; i++){
                int[] t = new int[N];

                int idx = N-1;
                for(int j = N-1; j >= 0; j--){
                    if(map[i][j] == 0) continue;

                    if(t[idx] == 0){
                        t[idx] = map[i][j];
                    }
                    else if(t[idx] == map[i][j]){
                        t[idx] *= 2;
                        idx--;
                    }else{
                        idx--;
                        t[idx] = map[i][j];
                    }
                }

                tmp[i] = t.clone();
            }

            return tmp;
        }
        public int[][] goUp(){
            int[][] tmp = new int[N][N];
            
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
                    tmp[j][i] = t[j];
                }
            }

            return tmp;
        }
        public int[][] goDown(){
            int[][] tmp = new int[N][N];
            
            for(int i = 0; i < N; i++){
                int[] t = new int[N];

                int idx = N-1;
                for(int j = N-1; j >= 0; j--){
                    if(map[j][i] == 0) continue;

                    if(t[idx] == 0){
                        t[idx] = map[j][i];
                    }
                    else if(t[idx] == map[j][i]){
                        t[idx] *= 2;
                        idx--;
                    }else{
                        idx--;
                        t[idx] = map[j][i];
                    }
                }

                for(int j = 0; j < N; j++){
                    tmp[j][i] = t[j];
                }
            }

            return tmp;
        }
    }

    public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		bfs(map);

		System.out.println(max);
	}

	static void bfs(int[][] map){
		Queue<Map> q = new LinkedList<>();
		q.offer(new Map(map));

		while(!q.isEmpty()){
			Map cur = q.poll();
			if(cur.cnt == 5){
				max = Math.max(max, cur.getMax());
				continue;
			}
			q.offer(new Map(cur.goLeft(),   cur.cnt+1));
			q.offer(new Map(cur.goRight(),  cur.cnt+1));
			q.offer(new Map(cur.goUp(),     cur.cnt+1));
			q.offer(new Map(cur.goDown(),   cur.cnt+1));
		}
	}
}