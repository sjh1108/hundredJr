import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        String title;
        int dif;
        public Node(String title, int dif) {
            this.title = title;
            this.dif = dif;
        }

        @Override
        public String toString(){
            return title;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.dif != o2.dif){
                    return o1.dif - o2.dif;
                } else{
                    return o1.title.compareTo(o2.title);
                }
            }
        });

        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            pq.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        System.out.println(pq.poll());
    }
}
