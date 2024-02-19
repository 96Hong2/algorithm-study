package study.baekjoon.week3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class BOJ17128_소가_정보섬에_올라온_이유_실버2_권은홍 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int Q = Integer.parseInt(info[1]);
        int[] cows = new int[N+1];
        int[] minusCows = new int[Q];
        HashMap<Integer, Integer> fourCowsMap = new HashMap<>();
        int result = 0;

        String[] cowStrArr = reader.readLine().split(" ");
        cows[0] = Integer.parseInt(cowStrArr[N-1]);
        for(int i = 1; i < N+1; i++)
        {
            cows[i] = Integer.parseInt(cowStrArr[i-1]);
            //System.out.println(cows[i]);
        }

        //System.out.println("-----q------");

        String[] minusCowStrArr = reader.readLine().split(" ");
        for(int j = 0; j < Q; j++)
        {
            minusCows[j] = Integer.parseInt(minusCowStrArr[j]);
            //System.out.println(minusCows[j]);
        }

        for(int i = 1; i < N+1; i++)
        {
            int tmp = 1;
            tmp *= (cows[i%N])*(cows[(i+1)%N])*(cows[(i+2)%N])*(cows[(i+3)%N]);
            fourCowsMap.put(i, tmp);
        }

        /*for(int sum : fourCowsMap.values())
        {
            System.out.print(sum + " ");
        }*/

        for(int q = 0; q < Q; q++)
        {
            int minusIdx = minusCows[q];
            int idx1 = minusIdx-3 <= 0 ? N+(minusIdx-3) : minusIdx-3;
            int idx2 = minusIdx-2 <= 0 ? N+(minusIdx-2) : minusIdx-2;
            int idx3 = minusIdx-1 <= 0 ? N+(minusIdx-1) : minusIdx-1;
            int idx4 = minusIdx == 0 ? N : minusIdx;

            for(int n = 1; n < N+1; n++)
            {
                int temp = fourCowsMap.get(n);
                if(n == idx1 || n == idx2 || n == idx3 || n == idx4)
                {
                    temp *= -1;
                    fourCowsMap.put(n, temp);
                }
                //System.out.println("n : " + n + " / temp : "+temp);
                result += temp;
            }
            System.out.println(result);
            result = 0;
        }
    }
}
