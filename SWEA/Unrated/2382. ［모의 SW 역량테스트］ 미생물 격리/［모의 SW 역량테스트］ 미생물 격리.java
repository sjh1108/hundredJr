import java.util.*;

class Solution {
	private static int N, M;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static List<Swarm> list;

	static class Swarm implements Comparable<Swarm>{
		int x, y;
		int dir;
		int amount;

		public Swarm(int x, int y, int amount, int dir){
			this.x = x;
			this.y = y;
			this.amount = amount;
			this.dir = dir;
		}

		public void changeDirection(){
			switch (dir) {
				case 0:
					dir = 1;
					break;
				case 1:
					dir = 0;
					break;
				case 2:
					dir = 3;
					break;
				case 3:
					dir = 2;
					break;
			}
		}

		@Override
		public int compareTo(Swarm o) {
			if(this.x == o.x && this.y == o.y){
				return Integer.compare(o.amount, this.amount);
			}
			return Integer.compare((this.x * N) + this.y, (o.x * N) + o.y);
		}
		
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++){
			N = sc.nextInt();
			M = sc.nextInt();
			int K = sc.nextInt();

			list = new ArrayList<>(K);
			for(int i = 0; i < K; i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				int amount = sc.nextInt();
				int dir = sc.nextInt() - 1;
				Swarm tmp = new Swarm(x, y, amount, dir);
				list.add(tmp);
			}

			for(int time = 0; time < M; time++){
				// move
				for(int idx = list.size() - 1; idx >= 0; idx--){
					Swarm tmp = list.get(idx);

					tmp.x += dx[tmp.dir];
					tmp.y += dy[tmp.dir];

					// check side
					if(tmp.x == 0 || tmp.x == N-1 || tmp.y == 0 || tmp.y == N-1){
						tmp.amount >>= 1;
						if(tmp.amount == 0) list.remove(idx);
						else tmp.changeDirection();
					}
				}

				Collections.sort(list);

				// combine
				for(int idx = list.size() - 1; idx > 0; idx--){
					Swarm cur = list.get(idx);
					Swarm prev = list.get(idx-1);

					if(cur.x == prev.x && cur.y == prev.y){
						prev.amount += cur.amount;
						list.remove(idx);
					}
				}
			}

			int res = 0;
			for(Swarm swm: list){
				res += swm.amount;
			}

			System.out.println("#" + t + " " + res);
		}
		sc.close();
	}
}