import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static class Node{
        int key;
        Node left, right;

        Node(int key){
            this.key = key;
        }

        void insert(int key){
            if(key < this.key){
                if(this.left == null) this.left = new Node(key);
                else this.left.insert(key);
            } else{
                if(this.right == null) this.right = new Node(key);
                else this.right.insert(key);
            }
        }
    }


    public static void main(String[] args) throws IOException{
        
        Node root = new Node(Integer.parseInt(br.readLine()));

        String s;
        while((s = br.readLine()) != null){
            root.insert(Integer.parseInt(s));
        }
        order(root);

        System.out.println(sb);
    }

    static void order(Node node){
        if(node == null) return;

        order(node.left);
        order(node.right);
        sb.append(node.key).append("\n");
    }

}