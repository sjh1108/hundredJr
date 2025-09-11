import java.util.*;

class Solution {
	private static int size;
	private static int min;
	
	private static int[] stairHeight;
	private static int[] peopleStair;
	private static int[][] dp;

	private static int simulate(List<Integer> arrivals, int offset){
		if(arrivals.isEmpty()) return 0;

		Collections.sort(arrivals);

		int[] stair = new int[3];

		for(int arrivalTime: arrivals){
			// 가장 빨리 사람이 비워지는 슬롯 선택
			int idx = 0;
			for(int i = 1; i < 3; i++){
				if(stair[i] < stair[idx]){
					idx = i;
				}
			}
			
			// 시작 시간은 도착시간+1, 비워지는 시간 중 늦게 시작하는것을 선택
			int startTime = Math.max(arrivalTime + 1, stair[idx]);
			// 계단은 startTime + offset동안 사용 불가함
			stair[idx] = startTime + offset;
			// 가지치기
			if(stair[idx] > min) return min;
		}

		int max = 0;
		for(int t: stair){
			max = Math.max(max, t);
		}

		return max;
	}

	private static void cal(){
		List<Integer> stair0 = new ArrayList<>();
		List<Integer> stair1 = new ArrayList<>();

		for(int i = 0; i < size; i++){
			if(peopleStair[i] == 0)
				stair0.add(dp[0][i]);
			else
				stair1.add(dp[1][i]);
		}

		int total = Math.max(simulate(stair0, stairHeight[0]),
							simulate(stair1, stairHeight[1]));

		min = Math.min(min, total);
	}

	private static void combi(int idx){
		if(idx == size){
			cal();
			return;
		}

		peopleStair[idx] = 0;
		combi(idx + 1);
		
		peopleStair[idx] = 1;
		combi(idx + 1);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; ++t) {
			int N = sc.nextInt();
			
			// init
			min = Integer.MAX_VALUE;

			/*
			 * init
			 * 	map
			 * 	stair
			 * 	people
			 */
			int idx = 0;
			List<int[]> people = new ArrayList<>();
			int[][] stair = new int[2][2];
			stairHeight = new int[2];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					int tmp = sc.nextInt();
					
					if(tmp == 1) people.add(new int[]{i, j});
					if(tmp >= 2){
						stair[idx][0] = i;
						stair[idx][1] = j;

						stairHeight[idx] = tmp;
						++idx;
					}
				}
			}
			
			size = people.size();
			// 계단과의 거리 계산
			dp = new int[2][size];
			for(int i = 0; i < size; i++){
				int[] cur = people.get(i);
				for(int stairIdx = 0; stairIdx < 2; stairIdx++){
					dp[stairIdx][i] = Math.abs(cur[0] - stair[stairIdx][0])
									+ Math.abs(cur[1] - stair[stairIdx][1]);
				}
			}
			
			peopleStair = new int[size];

			combi(0);

			System.out.println("#" + t + " " + min);
		}

		sc.close();
	}
}