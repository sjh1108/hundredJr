import java.util.Scanner;

public class Main {
	static int n,l;
	static int s,e;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();//합이 n
		l=sc.nextInt();// 길이가 적어도 이 길이 2~100
		int min=Integer.MAX_VALUE;//길이
		int sum=0;
		int start=0;
		for (int i = 0; i <=n; i++) {//n이 n을 넘지는 않으니 일단 최대 n까지 돌려본다.(중간에 나간다)
				sum+=i;
				while(sum>n) {// 일단 더해준 다음에 n보다 크면 가장 앞의수 (start)를 빼준다.
					sum-=start;
					start+=1;//시작 지점은 그 다음수로 업데이트되는 것이다.
				}
				if(sum==n && i-start+1>=l) {//길이가 l이상이고 합이 n일 때
					if(min>i-start+1) {//구해준 길이가 이전보다 더 작다면 업데이트
						s=start;
						e=i;
						min=i-start+1;
					}
                    //시뮬레이션 돌리다보면 앞의 수를 빼주다가 자기자신(i)가 되면 끝나게 된다.
                    //손으로 써보면 이해된다. i가 자기자신이 될 때가 있다.
					if(i-start+1==1)break;
				}
		}
		//정수 0이 없어도 길이조건을 만족할 때 0을 빼준다.
		if(sum-s==n && (e-s+1)>l) {//정수 0이 필요없을 때 빼준다.
			s+=1;
		}
		
		if(e-s+1>100 || min==Integer.MAX_VALUE) {//길이가 100보다 크거나 그런 수가 없을 때
			System.out.println(-1);
		}else {
			for (int i = s; i <=e; i++) {
				System.out.print(i+" ");
			}
		}

		
	}
	
}