package study.baekjoon.week1;
import java.util.Scanner;

public class 백준3085_사탕게임_실버2_권은홍 {
    public static int getMaxCandy(int maxCandy, char[][] arr, int N)
    {
        for(int i = 0; i < N; i++)
        {
            char before = 'X'; // 바로 직전의 색깔
            int cnt = 0; // 지금까지 이어진 수

            for(int x = 0; x < N; x++) // i행의 각 열 검사 (행 검사)
            {
                if(before == 'X' || before == arr[i][x])
                {
                    cnt++;
                    if(cnt == N) return N;
                }
                else
                {
                    if(maxCandy < cnt) maxCandy = cnt;
                    cnt = 1; // 현재 수
                }
                before = arr[i][x];
            }
            if(maxCandy < cnt) maxCandy = cnt;

            cnt = 0;
            before = 'X';
            for(int y = 0; y < N; y++) // i열의 각 행 검사 (열 검사)
            {
                if(before == 'X' || before == arr[y][i])
                {
                    cnt++;
                    if(cnt == N) return N;
                }
                else
                {
                    if(maxCandy < cnt) maxCandy = cnt;
                    cnt = 1;
                }
                before = arr[y][i];
            }
            if(maxCandy < cnt) maxCandy = cnt;
        }
        return maxCandy;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int maxCandy = 0; // 최대로 먹을 수 있는 사탕 수

        // 사탕 판 2차원 배열 채우기
        char[][] arr = new char[N][N];
        for(int i = 0; i < N; i++)
        {
            String[] row = scanner.next().split("");
            for(int j = 0; j < N; j++)
            {
                arr[i][j] = row[j].charAt(0);
            }
        }

        // 처음 사탕 판에서 이어진 최대 사탕 개수 구하기
        maxCandy = getMaxCandy(maxCandy, arr, N);

        if(maxCandy == N)
        {
            // 최대 사탕 수는 N을 넘을 수 없다.
            System.out.println(N);
        }
        else
        {
            for(int k = 0; k < N; k++)
            {
                // 인접한 오른쪽 문자와 자리바꿈
                for(int i = 0; i < N - 1; i++) {
                    char temp = arr[k][i];
                    arr[k][i] = arr[k][i + 1];
                    arr[k][i + 1] = temp;

                    int currentMax = getMaxCandy(maxCandy, arr, N);
                    if (currentMax > maxCandy) {
                        maxCandy = currentMax;
                    }

                    // 원래대로 돌려놓기
                    temp = arr[k][i];
                    arr[k][i] = arr[k][i + 1];
                    arr[k][i + 1] = temp;
                }

                // 인접한 아래쪽 문자와 자리바꿈
                for(int i = 0; i < N - 1; i++) {
                    char temp = arr[i][k];
                    arr[i][k] = arr[i + 1][k];
                    arr[i + 1][k] = temp;

                    int currentMax = getMaxCandy(maxCandy, arr, N);
                    if (currentMax > maxCandy) {
                        maxCandy = currentMax;
                    }

                    // 원래대로 돌려놓기
                    temp = arr[i][k];
                    arr[i][k] = arr[i + 1][k];
                    arr[i + 1][k] = temp;
                }
            }

            // 최대 사탕 수 출력
            System.out.println(maxCandy);
        }
    }
}
