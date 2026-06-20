import java.util.*;

class Solution {
    int size = -1;
    List<Node> nodeList;
    
    public int[][] solution(int[][] nodeinfo) {
        size = nodeinfo.length;
        
        nodeList = new ArrayList<>();
        for(int[] node: nodeinfo){
            nodeList.add(new Node(node[0], node[1]));
        }
        
        Collections.sort(nodeList);
        
        Node root = nodeList.get(0);
        
        for(int i = 1; i < size; i++){
            makeTree(root, nodeList.get(i));
        }
        
        List<Integer> pre, post;
        pre = new ArrayList<>();
        preOrder(root, pre);
        
        post = new ArrayList<>();
        postOrder(root, post);
        
        System.out.println(pre.size());
        int[][] answer = new int[2][size];
        for(int i = 0; i < size; i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
    }
    
    void makeTree(Node root, Node child){
        if(root.x > child.x){
            
            if(root.left == null){
                root.setLeft(child);
                return;
            }
            
            makeTree(root.left, child);
        }
        
        else{
            
            if(root.right == null){
                root.setRight(child);
                return;
            }
            
            makeTree(root.right, child);
        }
    }
    
    void preOrder(Node root, List<Integer> list){
        if(root == null) return;
        
        list.add(root.n);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    void postOrder(Node root, List<Integer> list){
        if(root == null) return;
        
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.n);
    }
}

class Node implements Comparable<Node>{
    static int num = 1;

    int n;
    int x, y;
    
    Node left, right;

    Node(int x, int y){
        n = num++;
        this.x = x; this.y = y;
    }
    
    void setLeft(Node left){
        this.left = left;
    }
    void setRight(Node right){
        this.right = right;
    }
    
    @Override
    public int compareTo(Node n){
        if(this.y == n.y) return Integer.compare(this.x, n.x);
        return Integer.compare(n.y, this.y);
    }
}