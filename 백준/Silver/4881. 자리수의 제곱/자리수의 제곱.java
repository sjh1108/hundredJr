import java.util.*;
import java.io.*;

class Main{
    private static void print(String A, String B, int length){
        System.out.println(A + " " + B + " " + length);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A, B;
        while(!(A = st.nextToken()).equals("0") && !(B = st.nextToken()).equals("0")){
            String originA = A, originB = B;
            if(A.equals(B)) {
                print(A, B, 2);
                st = new StringTokenizer(br.readLine());
                continue;
            }
            
            List<String> aList = new LinkedList<>();
            HashMap<String, Integer> aMap = new HashMap<>();
            int idx = 1;
            aMap.put(A, idx++);
            while(true){
                int sum = 0;
                for(int i = 0; i < A.length(); i++){
                    sum += (A.charAt(i) - '0') * (A.charAt(i) - '0');
                }

                A = Integer.toString(sum);
                if(aMap.containsKey(A)) break;
                aMap.put(A, idx++);
                aList.add(A);
            }

            int ans = Integer.MAX_VALUE;
            HashMap<String, Integer> bMap = new HashMap<>();
            idx = 1;
            if(aMap.containsKey(B)){
                ans = aMap.get(B) + 1;
            }
            bMap.put(B, idx++);
            while(true){
                int sum = 0;
                for(int i = 0; i < B.length(); i++){
                    sum += (B.charAt(i) - '0') * (B.charAt(i) - '0');
                }

                B = Integer.toString(sum);
                if(bMap.containsKey(B)) break;
                if(aMap.containsKey(B)){
                    ans = Math.min(ans, aMap.get(B) + idx);
                }
                bMap.put(B, idx++);
            }

            ans = ans == Integer.MAX_VALUE ? 0 : ans;
            print(originA, originB, ans);

            st = new StringTokenizer(br.readLine());
        }
    }
}