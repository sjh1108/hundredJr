import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        StringTokenizer st;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int max = 0;
        for(int i = 0; i < list.size()-1; i++){
            int cnt = 0;
            int[] cur = list.get(i);
            for(int j = i+1; j < list.size(); j++){
                int[] nxt = list.get(j);

                if(nxt[0] > cur[1]) break;

                if(nxt[1] < cur[1]){
                    cnt++;
                }
            }

            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}