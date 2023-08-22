import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        while(N-- >0){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preOrder(head);
        sb.append('\n');        
        inOrder(head);
        sb.append('\n');        
        postOrder(head);
        System.out.println(sb);
    }

    static class Node{
        char value;
        Node left;
        Node right;
        
        Node(char value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node temp, char root, char left, char right) {
		if (temp.value == root) {
			temp.left = (left == '.' ? null : new Node(left,null,null));
			temp.right = (right == '.' ? null : new Node(right,null,null)); 
		}
		else {
			if(temp.left != null) insertNode(temp.left, root, left, right);
			if(temp.right != null) insertNode(temp.right, root, left, right);
		}
	}
	
	public static void preOrder(Node node) {
		if(node ==null) return;
		sb.append(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if(node ==null) return;
		inOrder(node.left);
		sb.append(node.value);
		inOrder(node.right);
	}
	
	public static void postOrder(Node node) {
		if(node ==null) return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.value);
	}

}