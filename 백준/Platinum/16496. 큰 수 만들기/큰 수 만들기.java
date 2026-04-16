import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        String[] inputs = br.readLine().split(" ");
        Arrays.sort(inputs, new Comparator<String>() {
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String str: inputs) sb.append(str);

        if(sb.charAt(0) == '0'){
            System.out.println(0);
            return;
        }
        System.out.println(sb);
    }
}