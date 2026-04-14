import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        Arrays.sort(inputs, new Comparator<String>() {
            public int compare(String o1, String o2){
                return (o2+o1).compareTo(o1+o2);
            }
        });

        StringBuilder sb = new StringBuilder(N * 10);
        for(String str: inputs) sb.append(str);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(sb.charAt(0) == '0')
            bw.write("0");
        else
            bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
    }
}