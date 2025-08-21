import java.io.*;
import java.util.*;

public class Solution{
    private static int V, E;

    private static int[] cnt;
    private static List<Integer>[] list;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// int T = sc.nextInt();
		for(int t = 1; t <= 10; t++) {
            V = sc.nextInt();
            E = sc.nextInt();

            cnt = new int[V+1];
            list = new List[V+1];
            for(int i = 1; i < V+1; i++){
                list[i] = new ArrayList<>();
            }

            for(int e = 0; e < E; e++){
                int from = sc.nextInt();
                int to = sc.nextInt();

                list[from].add(to);
                cnt[to]++;
            }

            Queue<Integer> q = new ArrayDeque<>();

            for(int i = 1; i < V+1; i++){
                if(cnt[i] == 0) q.add(i); 
            }

            Queue<Integer> ans = new ArrayDeque<>(V);
            while(!q.isEmpty()){
                int cur = q.poll();

                ans.add(cur);

                for(int next: list[cur]){
                    cnt[next]--;

                    if(cnt[next] == 0){
                        q.add(next);
                    }
                }
            }
            System.out.print("#" + t + " ");
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
		}
		
		sc.close();
	}
}
