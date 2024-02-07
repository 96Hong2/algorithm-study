package study.baekjoon.week2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ9375_패션왕신해빈_실버3_권은홍 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스
        for(int t = 0; t < T; t++)
        {
            int N = scanner.nextInt(); // 의상 수
            if(N == 0)
            {
                System.out.println(0);
            }
            else
            {
                HashMap<String, ArrayList<String>> map = new HashMap<>();
                for(int i = 0; i < N; i++)
                {
                    String value = scanner.next();
                    String key = scanner.next();
                    ArrayList<String> arr = new ArrayList<>();
                    if(map.containsKey(key)) // 맵에 해당 의상종류가 있으면 거기에 넣고, 아니면 새로 만들어서 넣음
                    {
                        arr = map.get(key);
                    }
                    arr.add(value);
                    map.put(key, arr);
                }

                int current = 0; // 현재 의상종류(list)에 해당하는 경우의 수
                int result = 1; // 결과값 (각 의상종류 수 + 없는 경우 1)을 모두 곱한 값 - 1(모든 의상종류가 '없는' 경우)
                for(String key : map.keySet())
                {
                    ArrayList<String> list = map.get(key);
                    // System.out.println("----" + key + "----");
                    // System.out.println(list);
                    current = list.size() + 1; // 해당 의상종류 수 + 없는 경우 1
                    result *= current;
                }
                System.out.println(result - 1); // 모든 의상종류가 없는 경우(알몸 경우) 빼기
            }
        }
    }
}