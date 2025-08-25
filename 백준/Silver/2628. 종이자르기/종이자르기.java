import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> R = new PriorityQueue<>();
        PriorityQueue<Integer> C = new PriorityQueue<>();

        int beforeR = 0;
        int maxR = -1;

        int beforeC = 0;
        int maxC = -1;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            if(command == 0){
                R.add(Integer.parseInt(st.nextToken()));
            }
            else{
                C.add(Integer.parseInt(st.nextToken()));
            }
        }

        while(!R.isEmpty()){
            int commandR = R.poll();
            maxR = Math.max(maxR, commandR - beforeR);
            beforeR = commandR;
        }
        while(!C.isEmpty()){
            int commandC = C.poll();
            maxC = Math.max(maxC, commandC - beforeC);
            beforeC = commandC;
        }

        maxR = Math.max(maxR, r - beforeR);
        maxC = Math.max(maxC, c - beforeC);

        System.out.println(maxR * maxC);
    }
}