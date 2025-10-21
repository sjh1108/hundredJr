import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N == 0){
            System.out.println(1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        if(list.size() == P && score <= list.get(P-1)){
            System.out.println(-1);
            return;
        }

        list.add(score);
        Collections.sort(list, Collections.reverseOrder());
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == score){
                System.out.println(i+1);
                return;
            }
        }
    }
}