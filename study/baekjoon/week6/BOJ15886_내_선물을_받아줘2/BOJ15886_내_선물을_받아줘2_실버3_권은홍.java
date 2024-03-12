package study.baekjoon.week6.BOJ15886_내_선물을_받아줘2;
import java.util.Scanner;

public class BOJ15886_내_선물을_받아줘2_실버3_권은홍 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // 엔터 소비
        String[] mapArr = scanner.nextLine().split("");

        String before = "E"; // 바로 전 자리 값
        int result = 0; // 결과값
        for(String x : mapArr)
        {
            if("E".equals(before) && "W".equals(x)) result++;
            before = x;
        }
        System.out.println(result);
    }
}
