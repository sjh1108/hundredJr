import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while(M-- > 0){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int min = Z;

        boolean[] visited = new boolean[N+1];
        for(int k = 1; k < min; k++){
            Arrays.fill(visited, false);
            int p = 1;

            while(p != Z){
                p += k;
                if(p > N) p -= N;

                if(p == Z){
                    System.out.println(k);
                    return;
                }
                if(visited[p]) break;

                if(set.contains(p)) break;
                visited[p] = true;
            }
        }
        System.out.println(min);
    }
}