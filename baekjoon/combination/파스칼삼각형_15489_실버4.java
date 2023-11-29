package baekjoon.combination;

public class 파스칼삼각형_15489_실버4 {

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

    public static void main(String[] args)
    {
        System.out.println(combination(7, 4, 1, 1));
        System.out.println(combination(7, 2, 1, 1));
        System.out.println(combination(1, 0, 1, 1));
        System.out.println(combination(7, 7, 1, 1));
        System.out.println(combination(7, 6, 1, 1));
        System.out.println(combination(7, 5, 1, 1));
        System.out.println(combination(7, 3, 1, 1));
        System.out.println(combination(7, 1, 1, 1));
    }

}
