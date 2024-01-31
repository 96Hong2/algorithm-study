package study.beakjoon.week1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class 백준2018_통계학_실버3_권은홍 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int current = 0, sum = 0, modCnt = 1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> arr = new ArrayList<>(); // 중앙값 계산을 위한 배열
        HashMap<Integer, Integer> modMap = new HashMap<>(); // 최빈값 계산을 위해 각 수가 나타난 횟수를 저장하는 map
        ArrayList<Integer> modArr = new ArrayList<>(); // 최빈값이 여러 개일 경우 정렬을 위한 배열

        // N개의 수 입력받기
        for(int i = 0; i < N; i++)
        {
            current = scanner.nextInt(); // 현재 입력받은 수

            sum += current;

            if(max < current) max = current;
            if(min > current) min = current;
            arr.add(current);
            if(modMap.containsKey(current)) // 맵에 현재 수가 있으면 출현횟수 추가, 없으면 맵에 생성
            {
                modMap.put(current,(int)modMap.get(current) + 1);
                if (modCnt < modMap.get(current)) modCnt = modMap.get(current); // 현재 최빈값의 나타난 횟수
            }
            else
            {
                modMap.put(current, 1);
            }
            // System.out.println("current : " + current + " || sum : " + sum + "/ max : " + max + "/ min : " + min + "/ modCnt : " + modCnt);
        }
        scanner.close();

        // 산술평균 출력
        System.out.println(Math.round((float) sum /N));

        // 중앙값 출력
        Collections.sort(arr);
        System.out.println(arr.get(N / 2));

        // 최빈값 출력
        for(int key : modMap.keySet())
        {
            // 최빈값들을 모두 찾아 최빈값 배열 modArr에 넣는다
            if(modMap.get(key) == modCnt) modArr.add(key);
        }
        // 최빈값이 하나면 0번째 수 출력, 여러 개면 두 번째로 작은 수 출력
        Collections.sort(modArr);
        if(modArr.size() < 2) System.out.println(modArr.get(0));
        else System.out.println(modArr.get(1));

        // 범위 출력
        System.out.println(max-min);
    }
}
