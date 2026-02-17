import java.io.*;
import java.util.*;

class Main {
    static class Node {
        String first;
        String second;
        Node(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    private static Map<String, String> map;
    private static Queue<Node> pq;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        init();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringBuilder order = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'n' && j + 1 < str.length() && str.charAt(j + 1) == 'g') {
                    order.append(map.get("ng"));
                    j++;
                } else {
                    order.append(map.get(String.valueOf(str.charAt(j))));
                }
            }
            pq.add(new Node(str, order.toString()));
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll().first);
        }
    }
    
    private static void init() {
        map = new HashMap<>();
        pq = new PriorityQueue<>((o1, o2) -> o1.second.compareTo(o2.second));

        map.put("a", "a"); map.put("b", "b"); map.put("k", "c"); map.put("d", "d");
        map.put("e", "e"); map.put("g", "f"); map.put("h", "g"); map.put("i", "h");
        map.put("l", "i"); map.put("m", "j"); map.put("n", "k"); map.put("ng", "l");
        map.put("o", "m"); map.put("p", "n"); map.put("r", "o"); map.put("s", "p");
        map.put("t", "q"); map.put("u", "r"); map.put("w", "s"); map.put("y", "t");
    }
}