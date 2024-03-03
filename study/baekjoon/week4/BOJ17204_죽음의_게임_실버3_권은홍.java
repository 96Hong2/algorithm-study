package study.baekjoon.week4;
import java.util.Scanner;

public class BOJ17204_죽음의_게임_실버3_권은홍 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 참여인원
        int B = scanner.nextInt(); // 보성이 번호
        int[] callArr = new int[N];
        int m = 1; // 결과값

        for(int n = 0; n < N; n++)
        {
            callArr[n] = scanner.nextInt();
        }
        int called = 0; // 호출된 사람
        int curr = 0; // 현재 지목하는 사람
        while(m <= N)
        {
            called = callArr[curr];
            // System.out.println("curr : " + curr + " / called: "+called);
            if(called == -1 || (called != B && called == curr)) // 이미 호출된 적 있거나 자기 자신 호출 시
            {
                m = -1;
                break;
            }
            if(called == B) break; // 보성이가 걸렸으면 break
            callArr[curr] = -1; // 사이클 방지로 호출된 사람은 -1 로 구분

            // 지목된 사람이 다음 지목을 한다
            curr = called;
            m++;
        }
        System.out.println(m);
    }
}
