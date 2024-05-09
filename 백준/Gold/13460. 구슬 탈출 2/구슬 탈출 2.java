import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

	static boolean[][] wall;
	static class Node{
		int x, y;
		int cnt = 0;

		boolean flag = false;

		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
		Node(Node node){
			this.x = node.x;
			this.y = node.y;
			this.cnt = node.cnt+1;
			this.flag = node.flag;
		}

		boolean holeIn(){
			if(this.equals(hole)) {
				flag = true;
				return true;
			}
			return false;
		}
		void goLeft(){
			while(!wall[x][y-1]){
				y--;
				if(holeIn()) break;
				if(y == 0) break;
			}
		}
		void goRight(){
			while(!wall[x][y+1]){
				y++;
				if(holeIn()) break;
				if(y == M-1) break;
			}
		}
		void goUp(){
			while(!wall[x-1][y]){
				x--;
				if(holeIn()) break;
				if(x == 0) break;
			}
		}
		void goDown(){
			while(!wall[x+1][y]){
				x++;
				if(holeIn()) break;
				if(x == N-1) break;
			}
		}
		
		@Override
		public boolean equals(Object obj){
			Node node = (Node)obj;
			return x == node.x && y == node.y;
		}
	}
	static Node hole;

    public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		wall = new boolean[N][M];

		Node red, blue;
		red = blue = hole = null;
		for(int i = 0; i < N; i++){
			String line = br.readLine();

			for(int j = 0; j < M; j++){
				char c = line.charAt(j);

				if(c == '#') 		wall[i][j] = true;
				else if(c == 'B') 	blue = new Node(i, j);
				else if(c == 'R') 	red = new Node(i, j);
				else if(c == 'O') 	hole = new Node(i, j);
			}
		}

		move(red, blue);
	}

	static boolean isMovedAnything(Node bRed, Node aRed, Node bBlue, Node aBlue){
		return !bRed.equals(aRed) || !bBlue.equals(aBlue);
	}
	static void move(Node red, Node blue){
		Queue<Node[]> q = new LinkedList<>();
		q.offer(new Node[]{red, blue});

		while(!q.isEmpty()){
			Node cur[] = q.poll();
			Node r = cur[0], b = cur[1];

			if(b.flag) continue;
			if(r.flag) {
				System.out.println(r.cnt);
				return;
			}

			if(r.cnt > 10) break;

			// goLeft
			Node lRed = new Node(r), lBlue = new Node(b);
			lRed.goLeft(); lBlue.goLeft();
			if(lRed.equals(lBlue)) {
				if(r.y < b.y) lBlue.y++;
				else lRed.y++;
			}
			if(isMovedAnything(r, lRed, b, lBlue)) q.offer(new Node[]{lRed, lBlue});

			// goRight
			Node rRed = new Node(r), rBlue = new Node(b);
			rRed.goRight(); rBlue.goRight();
			if(rRed.equals(rBlue)) {
				if(r.y < b.y) rRed.y--;
				else rBlue.y--;
			}
			if(isMovedAnything(r, rRed, b, rBlue)) q.offer(new Node[]{rRed, rBlue});

			// goUp
			Node uRed = new Node(r), uBlue = new Node(b);
			uRed.goUp(); uBlue.goUp();
			if(uRed.equals(uBlue)) {
				if(r.x < b.x) uBlue.x++;
				else uRed.x++;
			}
			if(isMovedAnything(r, uRed, b, uBlue)) q.offer(new Node[]{uRed, uBlue});

			// goDown
			Node dRed = new Node(r), dBlue = new Node(b);
			dRed.goDown(); dBlue.goDown();
			if(dRed.equals(dBlue)) {
				if(r.x < b.x) dRed.x--;
				else dBlue.x--;
			}
			if(isMovedAnything(r, dRed, b, dBlue)) q.offer(new Node[]{dRed, dBlue});
		}
		
		System.out.println(-1);
	}
}