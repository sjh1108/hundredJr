import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int max = 0;
        List<Integer> crane = new ArrayList<>(N);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
            max = Math.max(max, crane.get(i));
        }
        
        int M = Integer.parseInt(br.readLine());
        
        List<Integer> box = new ArrayList<>(M);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int b = Integer.parseInt(st.nextToken());
            box.add(b);
            if(b > max){
                System.out.println(-1);
                return;
            }
        }
        
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box);
        
        int answer = 0;
        int cur = 0, index = M-1;
        while(!box.isEmpty()){
            if(box.get(index) <= crane.get(cur)){
                box.remove(index);
                cur++;
            }
            index--;
            
            
            if(cur == N || index == -1){
                cur = 0;
                index = box.size()-1;
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}