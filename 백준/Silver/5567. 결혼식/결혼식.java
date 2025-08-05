import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visit;
    private static List<List<Integer>> link;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visit = new boolean[N+1];
        link = new LinkedList<>();
        for(int i = 0; i <= N; i++){
            link.add(new LinkedList());
        }
        StringTokenizer st;
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link.get(a).add(b);
            link.get(b).add(a);
        }

        visit[1] = true;
        DFS(link.get(1), 0);
        int cnt = -1;
        for(boolean b: visit){
            if(b) cnt++;
        }
        System.out.println(cnt);
    }

    private static void DFS(List<Integer> list, int depth){
        if(depth == 1) {
            for(int x: list){
                if(visit[x]) continue;

                visit[x] = true;
            }

            return;
        }


        for(int x: list){
            visit[x] = true;
            DFS(link.get(x), depth+1);
        }
    }
}
