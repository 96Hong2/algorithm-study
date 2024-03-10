package study.baekjoon.week6.BOJ18311_왕복;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BOJ18311_왕복_실버5_권은홍 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] info = reader.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        long K = Long.parseLong(info[1]);
        long length = 0; // 총 코스 길이
        long[] course = new long[N];

        String[] courseStr = reader.readLine().split(" ");
        for(int n = 0; n < N; n++)
        {
            length += Long.parseLong(courseStr[n]);
            course[n] = length;
        }

        if(K == 0) System.out.println(1);
        else if(K == length) System.out.println(N);
        else
        {
            boolean isReturn = false;
            if(K > length)
            {
                isReturn = true;
                K = length - (K - length);
            }
            for(int i = 0; i < N; i++)
            {
                long cur = course[i];
                if(K == cur)
                {
                    if(isReturn) System.out.println(i+1);
                    else System.out.println(i+2);
                    break;
                }
                else if(K < cur)
                {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
