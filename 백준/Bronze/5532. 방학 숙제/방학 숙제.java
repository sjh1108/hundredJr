import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int day = sc.nextInt();
        int kor = sc.nextInt();
        int mat = sc.nextInt();
        
        int kh = sc.nextInt();
        int mh = sc.nextInt();
        
        if(kor % kh == 0){
            kor = kor / kh;
        } else{
            kor = (kor / kh) + 1;
        }
        if(mat % mh == 0){
            mat = mat / mh;
        } else{
            mat = (mat / mh) + 1;
        }
        
        System.out.println(day - (int)(Math.max(mat, kor)));
    }
}