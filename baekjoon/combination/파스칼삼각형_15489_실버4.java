package baekjoon.combination;
import java.util.Scanner;

public class 파스칼삼각형_15489_실버4 {
    static int r;
    static int c;
    static int w;
    static int result = 0;

    // TODO : factorial 을 구하는 재귀함수를 이용하여 조합함수 만들기
    // 조합 nCr을 구하는 함수, head는 분자, tail은 분모
    public static long combination(int n, int r, long head, long tail)
    {
        if(n == r)
        {
            return 1; // nCn은 1
        }
        else if(r > n/2)
        {
            // 조합의 성질(nCr == nCn-r)을 이용해 계산을 줄인다.
            return combination(n, n-r, head, tail);
        }
        else if(r == 0)
        {
            return head/tail;
        }
        head *= (n-(r-1));
        tail *= r;
        return combination(n, r-1, head, tail);
    }

    // 구하려는 삼각형의 값을 한 줄씩 구한다.
    public static void getSum(int p, int q)
    {
        // p는 구하려는 삼각형의 몇 번째 줄인지, q는 해당 줄이 전체삼각형의 몇번째 줄인지(해당 줄 조합의 앞의 수)
        if(p > w) return; // p가 범위를 넘어가면 종료

        for(int i = 0; i < p; i++) // 구하려는 삼각형의 해당 줄의 총합을 구한다.
        {
            // System.out.println("n : " + (q-1) + ", r : " + (c-1+i));
            result += combination(q-1, c-1+i, 1, 1);
        }
        getSum(p+1, q+1);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(" ");
        r = Integer.parseInt(info[0]);
        c = Integer.parseInt(info[1]);
        w = Integer.parseInt(info[2]);

        if(r == 1)
        {
            for(int i = 0; i < w; i++)
            {
                result += (int) Math.pow(2, i);
            }
        }
        else
        {
            getSum(1, r); // 구하려는 삼각형의 맨 위 꼭짓점 수부터 시작
        }

        System.out.println(result);
    }
}
