import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr[i]);
        }

		int max=0;

        Queue<Student> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pq.add(new Student(i, 0, arr[i][0]));
			max = Math.max(max, arr[i][0]);
		}

		int ans = Integer.MAX_VALUE;

		while(true) {
			Student cur = pq.poll();
			ans = Math.min(ans, max - cur.pow);

			if(cur.idx == M-1){
                break;
            }

			Student nxt = new Student(cur.cls, cur.idx + 1, arr[cur.cls][cur.idx + 1]);
			max = Math.max(nxt.pow, max);

			pq.add(nxt);
		}

		System.out.println(ans);
	}
	
	static class Student implements Comparable<Student>{
		int cls, idx, pow;
		public Student(int cls, int idx, int pow) {
			this.cls = cls;
			this.idx = idx;
			this.pow = pow;
		}
		@Override
		public int compareTo(Student o) {
			return this.pow - o.pow;
		}
	}

}