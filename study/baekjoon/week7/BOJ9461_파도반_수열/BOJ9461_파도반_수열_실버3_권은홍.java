package study.baekjoon.week7.BOJ9461_파도반_수열;
import java.util.Scanner;

public class BOJ9461_파도반_수열_실버3_권은홍 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++)
        {
            int N = scanner.nextInt();
            long[] padovanArr = new long[N+1];
            for(int i = 1; i < N+1; i++)
            {
                if(i <= 3) padovanArr[i] = 1;
                else if(i <= 5) padovanArr[i] = 2;
                else
                {
                    padovanArr[i] = padovanArr[i-5] + padovanArr[i-1];
                }
            }
            System.out.println(padovanArr[N]);
        }
    }
}
