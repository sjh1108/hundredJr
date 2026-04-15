import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        String name = st.nextToken();
        int age = Integer.parseInt(st.nextToken());
        int wgt = Integer.parseInt(st.nextToken());
        
        while(!name.equals("#")){
            sb.append(name).append(" ");
            if(age > 17 || wgt > 79)
                sb.append("Senior\n");
               
            else
                sb.append("Junior\n");
            st = new StringTokenizer(sc.nextLine());
            name = st.nextToken();
            age = Integer.parseInt(st.nextToken());
            wgt = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }
}