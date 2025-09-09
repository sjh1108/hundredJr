import java.io.*;
import java.util.*;

public class Main{
    private static HashMap<String, Integer> map = new HashMap<>();
    private static List<Command> commands = new ArrayList<>();

    private static class Command{
        int x, y, cost;

        public Command(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int[] execute(int[] arr){
            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
            return arr;
        }
    }

    private static String arrayToString(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb.append(num);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] original = new int[N];
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = original[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(answer);
        map.put(arrayToString(original), 0);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            commands.add(new Command(x, y, cost));
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(original);

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(Command cmd: commands){
                int[] nxt = cmd.execute(cur.clone());

                String key = arrayToString(nxt);
                if(!map.containsKey(key)){
                    map.put(key, map.get(arrayToString(cur)) + cmd.cost);
                    q.add(nxt);
                } else{
                    int newCost = map.get(arrayToString(cur)) + cmd.cost;
                    if(map.get(key) > newCost){
                        map.put(key, newCost);
                        q.add(nxt);
                    }
                }
            }
        }

        String ansKey = arrayToString(answer);
        System.out.println(map.getOrDefault(ansKey, -1));
    }
}