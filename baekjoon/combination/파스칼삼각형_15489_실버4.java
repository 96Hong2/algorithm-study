package baekjoon.combination;

public class 파스칼삼각형_15489_실버4 {

    // 조합 nCr을 구하는 함수, head는 분자, tail은 분모
    public static int combination(int n, int r, int head, int tail)
    {
        if(n == r)
        {
            return 1; // nCn은 1
        }
        else if(r == 0)
        {
            return head/tail;
        }
        head *= (n-(r-1));
        tail *= r;
        return combination(n, r-1, head, tail);
    }

    public static void main(String[] args)
    {
        System.out.println(combination(7, 4, 1, 1));
        System.out.println(combination(0, 0, 1, 1));
        System.out.println(combination(1, 0, 1, 1));
        System.out.println(combination(7, 7, 1, 1));
        System.out.println(combination(7, 0, 1, 1));
        System.out.println(combination(7, 3, 1, 1));
        System.out.println(combination(7, 1, 1, 1));
    }

}
