package baekjoon.combination;

public class 파스칼삼각형_15489_실버4 {

    // 조합 nCr을 구하는 함수, head는 분자, tail은 분모
    // TODO : n 또는 r이 0 또는 1일 경우
    public static int combination(int n, int r, int head, int tail)
    {
        if(n == 0) return 1; // 0C0은 1
        if(n == r) return 1; // nCn은 1
        if(r == 0) return (n*head)/tail;
        head *= (n-r);
        tail *= r;
        System.out.println(n + " C " + r + " >> head : " + head + ", tail : " + tail);
        return combination(n, r-1, head, tail);
    }

    public static void main(String[] args)
    {
        System.out.println(combination(3, 2, 1, 1));
        System.out.println(combination(0, 0, 1, 1));
        System.out.println(combination(3, 0, 1, 1));
        System.out.println(combination(1, 1, 1, 1));
        System.out.println(combination(7,1,1,1));
    }

}
