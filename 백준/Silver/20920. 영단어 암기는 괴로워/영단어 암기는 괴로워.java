import java.util.*;
import java.io.*;

import java.util.stream.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        while(N-- > 0){
            String s = br.readLine();
            // 길이가 M보다 작으면 무시
            if(s.length() < M) continue;

            // 빈도수 체크
            if(map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }

        // 사전순 정렬을 위한 리스트
        List<String> list = map.keySet().stream().collect(Collectors.toList());

        // 정렬
        list.sort((o1, o2) -> {
            int c1 = map.get(o1);
            int c2 = map.get(o2);

            // 빈도수가 같으면
            if(c1 == c2){

                // 길이가 같으면 사전순
                if(o1.length() == o2.length())
                    return o1.compareTo(o2);

                // 길이가 다르면 길이가 짧은 순
                else
                    return o2.length() - o1.length();
            }

            // 빈도수 높을수록 앞으로 배치
            return c2 - c1;
        });

        for(String s : list)
            sb.append(s).append("\n");

        System.out.println(sb);
    }
}
