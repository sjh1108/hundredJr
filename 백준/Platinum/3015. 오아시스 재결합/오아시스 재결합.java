import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    
    static Stack<Node> stack = new Stack<>();

    static class Node implements Comparable<Node>{
        int height;
        int count;

        Node(int height, int count){
            this.height = height;
            this.count = count;
        }

        @Override
        public int compareTo(Node o){
            return this.height - o.height;
        }
    }
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        long count = 0;
        for(int i = 0; i < N; i++){
            Node node = new Node(Integer.parseInt(br.readLine()), 1);

            while(!stack.isEmpty() && stack.peek().height <= node.height){
                Node tmp = stack.pop();
                count += tmp.count;
                if(tmp.height == node.height){
                    node.count += tmp.count;
                }
            }

            if(!stack.isEmpty()){
                count++;
            }

            stack.push(node);
        }

        System.out.println(count);
    }
}