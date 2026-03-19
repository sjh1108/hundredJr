import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        int c = System.in.read() - 'A';
        if(c == 'F' - 'A'){
            System.out.print(0.0);
            return;
        }
        char a = (char) System.in.read();
        
        double out = 4 - c;
        switch(a){
            case '+': 
                out += 0.3;
                break;
            case '-':
                out -= 0.3;
                break;
        }
        
        System.out.println(out);
    }
}