import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        char name;
        Node left;
        Node right;

        static final char root = 'A';
        static List<Node> list = new LinkedList<>();
        Node(char name) {
            this.name = name;

            list.add(this);
        }

        void setLeft(Node left){
            this.left = left;
        }
        void setRight(Node right){
            this.right = right;
        }

        static Node findNode(char c){
            for(Node n: list){
                if(n.name == c){
                    return n;
                }
            }

            return null;
        }

        static List<Node> preOrder(Node head){
            if(head == null){
                return List.of();
            }
            List<Node> nodes = new ArrayList<>();

            nodes.add(head);
            nodes.addAll(preOrder(head.left));
            nodes.addAll(preOrder(head.right));

            return nodes;
        }
        static List<Node> inOrder(Node head){
            if(head == null){
                return List.of();
            }
            List<Node> nodes = new ArrayList<>();

            nodes.addAll(inOrder(head.left));
            nodes.add(head);
            nodes.addAll(inOrder(head.right));

            return nodes;
        }
        static List<Node> postOrder(Node head){
            if(head == null){
                return List.of();
            }
            List<Node> nodes = new ArrayList<>();

            nodes.addAll(postOrder(head.left));
            nodes.addAll(postOrder(head.right));
            nodes.add(head);

            return nodes;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node hNode = Node.findNode(root);
            if(hNode == null){
                hNode = new Node(root);
            }
            Node lNode, rNode;
            if(left == '.') lNode = null;
            else{
                lNode = new Node(left);
            }
            if(right == '.') rNode = null; 
            else{
                rNode = new Node(right);
            }

            hNode.setLeft(lNode);
            hNode.setRight(rNode);
        }

        StringBuilder sb = new StringBuilder();
        for(Node n: Node.preOrder(Node.findNode(Node.root))){
            sb.append(n.name);
        }
        sb.append('\n');
        for(Node n: Node.inOrder(Node.findNode(Node.root))){
            sb.append(n.name);
        }
        sb.append('\n');
        for(Node n: Node.postOrder(Node.findNode(Node.root))){
            sb.append(n.name);
        }
        System.out.println(sb);
    }
}
