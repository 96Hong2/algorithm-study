package study.baekjoon.week2.BOJ1158_요세푸스_문제;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1158_요세푸스_문제_실버4_권은홍 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Queue<Integer> que = new LinkedList<>();
        String result = "<";

        // 큐 초기화
        for(int i = 1; i < N+1; i++) que.offer(i);

        int index = 1; // 인덱스
        int current = 0;
        while(que.size() > 1)
        {
            if(index % K == 0) // 현재 인덱스가 K의 배수이면
            {
                current = que.poll();
                result += (current + ", ");
            }
            else
            {
                current = que.poll();
                que.offer(current);
            }
            index++;
        }
        // queue에 하나만 남으면
        result += (que.poll() + ">");

        System.out.println(result);
    }
}
