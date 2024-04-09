import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int max = 0;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        boolean[] visited = new boolean[N+1];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            if(list.get(i).size() == 0) {
                result.add(i);
                visited[i] = true;
            }
        }
        
        while(result.size() < N){
            for(int i = 1; i <= N; i++){
                if(visited[i]) continue;

                if(list.get(i).size() == 0){
                    result.add(i);
                    visited[i] = true;
                    continue;
                }

                if(list.get(i).size() == 1){
                    if(visited[list.get(i).get(0)]){
                        result.add(i);
                        visited[i] = true;
                        list.get(i).remove(0);
                    }
                } else{
                    for(int j = 0; j < list.get(i).size(); j++){
                        if(visited[list.get(i).get(j)]) {
                            list.get(i).remove(j);
                        }
                    }
                }
            }
        }

        for(int i = result.size() - 1; i >= 0; i--){
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}