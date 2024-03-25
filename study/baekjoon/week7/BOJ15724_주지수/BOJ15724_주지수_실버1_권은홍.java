package study.baekjoon.week7.BOJ15724_주지수;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15724_주지수_실버1_권은홍 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = reader.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]);
        int M = Integer.parseInt(tmp[1]);
        int[][] arr = new int[N][M];
        int result = 0;

        // 누적합 이차원배열 arr 만들기
        int sum = 0;
        for(int n = 0; n < N; n++)
        {
            String[] info = reader.readLine().split(" ");
            for(int m = 0; m < M; m++)
            {
                sum += Integer.parseInt(info[m]);
                arr[n][m] = sum;
                // System.out.print(arr[n][m] + " ");
            }
            // System.out.println();
            sum = 0;
        }

        // result 구하기
        int K = Integer.parseInt(reader.readLine());
        for(int k = 0; k < K; k++)
        {
            String[] scope = reader.readLine().split(" ");
            int x1 = Integer.parseInt(scope[0])-1;
            int x2 = Integer.parseInt(scope[1])-1;
            int y1 = Integer.parseInt(scope[2])-1;
            int y2 = Integer.parseInt(scope[3])-1;

            for(int i = x1; i < y1+1; i++)
            {
                if(x2 == 0) result += arr[i][y2];
                else result += (arr[i][y2] - arr[i][x2-1]);
            }
            // System.out.println();
            System.out.println(result);
            result = 0;
        }
    }
}

