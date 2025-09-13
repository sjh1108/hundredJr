import java.io.*;
import java.util.*;

class Main {
    private static boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        char[] arr = br.readLine().toCharArray();
        for(int idx = 0; idx < N; idx++){
            if(arr[idx] == 'A'){
                list.add(idx);
            }
        }

        if(list.size() < 2){
            System.out.println("NO");
            return;
        }

        int minIdx = M-3;
        if(list.get(list.size()-2) < minIdx){
            System.out.println("NO");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = list.get(list.size()-2) - minIdx; i < list.get(list.size()-2); i++){
            sb.append(arr[i]);
        }
        sb.append("AA");
        for(int i = list.get(list.size()-1) + 1; i < arr.length; i++){
            if(!isVowel(arr[i])){
                sb.append(arr[i]);
                break;
            }
        }

        if(sb.length() < M){
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(sb.toString());
        }
    }
}
