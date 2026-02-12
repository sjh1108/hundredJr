import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

		BigInteger answer = new BigInteger("0");
		
		ArrayList<Long> pList = new ArrayList<Long>();
		ArrayList<Long> mList = new ArrayList<Long>();

        int oCnt = 0;
		for(int i = 0; i < N; i++)
		{
			long n = Long.parseLong(br.readLine());
			if(n > 1)
				pList.add(n);
			else if(n < 1)
				mList.add(n);
			else
                oCnt++;
		}
		
		Collections.sort(pList, Collections.reverseOrder());
		Collections.sort(mList);
		
		if(pList.size() % 2 == 0) {
			for(int i = 0; i < pList.size(); i+=2)
				answer = answer.add(BigInteger.valueOf(pList.get(i) * pList.get(i + 1)));
		}
		
		else {
			for(int i = 0; i < pList.size() - 1; i+=2)
				answer = answer.add(BigInteger.valueOf(pList.get(i) * pList.get(i + 1)));
			answer = answer.add(BigInteger.valueOf(pList.get(pList.size()-1)));
		}
		
		if(mList.size() % 2 == 0)
			for(int i = 0; i < mList.size(); i+=2)
				answer = answer.add(BigInteger.valueOf(mList.get(i) * mList.get(i + 1)));
		
		else {
			for(int i = 0; i < mList.size()-1; i+=2)
				answer = answer.add(BigInteger.valueOf(mList.get(i) * mList.get(i + 1)));
			answer=answer.add(BigInteger.valueOf(mList.get(mList.size() - 1)));
		}
		
		answer = answer.add(BigInteger.valueOf(oCnt));
		System.out.println(answer);
    }
}