package baekjoon.implement;
import java.util.Scanner;
public class 홀수홀릭호석_20164_골드5 {
    static int maxOddCnt = 0; // 최대 홀수 개수
    static int minOddCnt = 0; // 최소 홀수 개수

    // 최대/최소 갱신
    public static void getMinMax(int oddCnt)
    {
        if(oddCnt > maxOddCnt)
        {
            maxOddCnt = oddCnt;
        }
        if(oddCnt < minOddCnt)
        {
            minOddCnt = oddCnt;
        }
    }

    // target의 부분(part)을 받아 최대/최소 홀수 값을 계산하는 재귀함수
    public static void getOdd(String part, int oddCnt)
    {
        System.out.println("getOdd part : " + part + ", oddCnt : " + oddCnt);
        // 각 자리의 홀수 개수 count
        for(int i = 0; i < part.length(); i++)
        {
            if(Character.getNumericValue(part.charAt(i))%2 == 1)
            {
                oddCnt++;
            }
        }

        // part가 1자리수면 지금까지 계산한 홀수개수로 min/max를 갱신하고 종료
        // TODO : 오류 : 케이스의 종료 시점이 아닌 처음으로 수가 1개 남았을 시점의 oddCnt가 min값이 됨
        if(part.length() == 1)
        {
            getMinMax(oddCnt);
            return;
        }
        // part가 2자리수이면 둘을 더한 수로 getOdd를 다시 돌려서 홀수개수 계산
        else if(part.length() == 2)
        {
            part = String.valueOf(Character.getNumericValue(part.charAt(0))
                    + Character.getNumericValue(part.charAt(1)));
            getOdd(part, oddCnt);
        }
        // part가 3자리수 이상이면 구분자를 나눠 각각의 case에 대하여 getOdd를 돌림
        else
        {
            // part를 나눠 모든 case들을 만들기 위한 getPart 재귀함수 수행
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        minOddCnt = target.length(); // 최솟값 초기화
        getOdd(target, 0);

        if(maxOddCnt == 0) minOddCnt = maxOddCnt;
        System.out.println(minOddCnt + " " + maxOddCnt);
    }
}
