import java.io.*;
import java.util.*;

class Main {
    private static final int FREE_SIZE = 5;
    private static final int PRINT_SIZE = 6;
    private static final int MALLOC_SIZE = 7;

    private static final String MALLOC_TOKEN = "=";
    private static final String FREE_STRING = "free";
    private static final String PRINT_STRING = "print";

    static class Node {
        int start, len;
        boolean blank;
        Node prev, next;

        Node(int start, int len) {
            this.start = start;
            this.len = len;
            this.blank = true;
        }
    }

    private static Map<String, Integer> map;
    private static Map<String, Node> key2Node;
    private static Node head, tail;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new HashMap<>();
        key2Node = new HashMap<>();

        head = new Node(0, 0); 
        head.blank = false;
        
        tail = new Node(100_001, 0); 
        tail.blank = false;
        
        Node tmp = new Node(1, 100_000);
        
        head.next = tmp; tmp.prev = head;
        tmp.next = tail; tail.prev = tmp;

        int commandCount = Integer.parseInt(br.readLine());
        while (commandCount-- > 0) {
            String cmd = br.readLine();

            if (cmd.startsWith(FREE_STRING)) {
                String key = separateBrackets(cmd, FREE_SIZE);
                free(key);
            } else if (cmd.startsWith(PRINT_STRING)) {
                String key = separateBrackets(cmd, PRINT_SIZE);
                sb.append(print(key)).append('\n');
            } else {
                StringTokenizer st = new StringTokenizer(cmd, MALLOC_TOKEN);
                String key = st.nextToken().trim();
                
                String valStr = st.nextToken().trim();
                int size = Integer.parseInt(separateBrackets(valStr, MALLOC_SIZE));
                
                malloc(size, key);
            }
        }
        System.out.println(sb);
    }

    private static String separateBrackets(String cmd, int commandSize) {
        return cmd.substring(commandSize, cmd.length() - 2);
    }

    private static void malloc(int size, String key) {
        Node cur = head.next;

        map.put(key, 0); 
        key2Node.remove(key); 
        
        while (cur != tail) {
            if (cur.blank && cur.len >= size) {
                cur.blank = false;
                map.put(key, cur.start);
                key2Node.put(key, cur);

                if (cur.len > size) {
                    Node tmp = new Node(cur.start + size, cur.len - size);
                    
                    tmp.next = cur.next;
                    tmp.prev = cur;
                    
                    cur.next.prev = tmp;
                    cur.next = tmp;
                    
                    cur.len = size;
                }
                return;
            }
            cur = cur.next;
        }
    }

    private static void free(String key) {
        Node n = key2Node.get(key);
        if (n == null) return;

        n.blank = true;
        
        Node next = n.next;
        if (next != tail && next.blank) {
            n.len += next.len;
            n.next = next.next;
            next.next.prev = n;
        }

        Node prev = n.prev;
        if (prev != head && prev.blank) {
            prev.len += n.len;
            prev.next = n.next;
            n.next.prev = prev;
        }

        key2Node.remove(key);
        map.put(key, 0);
    }

    private static int print(String key) {
        return map.getOrDefault(key, 0);
    }
}