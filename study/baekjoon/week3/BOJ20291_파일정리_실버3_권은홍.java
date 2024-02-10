package study.baekjoon.week3;
import java.util.Scanner;
import java.util.TreeMap;

public class BOJ20291_파일정리_실버3_권은홍 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> extMap = new TreeMap<>();
        int N = scanner.nextInt();

        for(int i = 0; i < N; i++)
        {
            String file = scanner.next();
            String ext = file.split("\\.")[1];
            extMap.put(ext, extMap.getOrDefault(ext, 0)+1);
        }

        for(String ext : extMap.keySet())
        {
            System.out.println(ext + " " + extMap.get(ext));
        }
    }
}
