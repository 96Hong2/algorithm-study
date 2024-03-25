package study.baekjoon.week7.BOJ9655_돌_게임;
import java.util.Scanner;

public class BOJ9655_돌_게임_실버5_권은홍 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N%2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}
