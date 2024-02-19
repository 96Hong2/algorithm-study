package study.baekjoon.week3.BOJ5766_할아버지는_유명해;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class BOJ5766_할아버지는_유명해_실버4_권은홍 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            int N, M, firstScore = 0, firstKey = 0;
            HashMap<Integer, Integer> scoreMap = new HashMap<>();
            ArrayList<Integer> secondArr = new ArrayList<>();

            N = scanner.nextInt();
            if(N == 0)
            {
                break;
            }
            M = scanner.nextInt();

            for(int m = 0; m < N*M; m++)
            {
                int num = scanner.nextInt();
                if(scoreMap.containsKey(num))
                {
                    int score = scoreMap.get(num) + 1;
                    scoreMap.put(num, score);
                    if(score > firstScore) // 1등 점수 갱신
                    {
                        firstKey = num; // 1등선수
                        firstScore = score; // 1등점수
                    }
                }
                else
                {
                    scoreMap.put(num, 1);
                }
            }

            scoreMap.remove(firstKey); // 1등 제거

            int secondScore = Collections.max(scoreMap.values()); // 다음 최대는 2등값임
            for(int num : scoreMap.keySet())
            {
                if(scoreMap.get(num) == secondScore)
                {
                    secondArr.add(num); // 2등들의 배열에 추가
                }
            }

            Collections.sort(secondArr);
            String result = "";
            for(int x : secondArr)
            {
                result += x + " ";
            }

            System.out.println(result.substring(0, result.length()-1));

        }
    }
}
