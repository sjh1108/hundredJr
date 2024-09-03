import java.util.*;
import java.util.LinkedList;
import java.io.*;

public class Main {
    public static class LinkedListStack<E> {
        LinkedList<E> list;
    
        public LinkedListStack(){
            this.list = new LinkedList<>();
        }
    
        public boolean isEmpty(){
            return this.list.isEmpty();
        }
    
        public void push(E element){
            this.list.addLast(element);
        }
    
        public E pop(){
            return this.list.removeLast();
        }
    
        public E top(){
            return this.list.getLast();
        }

        public int size(){
            return this.list.size();
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        LinkedListStack<Integer> stack = new LinkedListStack<>();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            switch(c){
                case 1:
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case 2:
                    if(stack.size() > 0){
                        sb.append(stack.pop());
                    } else{
                        sb.append(-1);
                    }
                    sb.append('\n');
                    break;
                case 3:
                    sb.append(stack.size());
                    sb.append('\n');
                    break;
                case 4:
                    if(stack.size() == 0){
                        sb.append(1);
                    } else{
                        sb.append(0);
                    }
                    sb.append('\n');
                    break;
                case 5:
                    if(stack.size() == 0){
                        sb.append(-1);
                    } else {
                        sb.append(stack.top());
                    }
                    sb.append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}
