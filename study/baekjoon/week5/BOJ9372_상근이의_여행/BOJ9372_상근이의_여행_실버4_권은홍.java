package study.baekjoon.week5.BOJ9372_상근이의_여행;
import java.util.Scanner;

public class BOJ9372_상근이의_여행_실버4_권은홍 {
    public static class Graph
    {
        static int V;
        static int[] parents;

        public static void initGraph(int v)
        {
            V = v;
            parents = new int[v+1];
            for(int i = 1; i < V+1; i++) parents[i] = i;
        }

        public static int find(int v)
        {
            if(parents[v] == v) return v;
            else return find(parents[v]);
        }

        public static int union(int v1, int v2)
        {
            int p1 = find(v1);
            int p2 = find(v2);
            if(p1 == p2) return -1;
            else if(p1 > p2)
            {
                parents[p1] = p2;
                return p2;
            }
            else
            {
                parents[p2] = p1;
                return p1;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++)
        {
            int result = 0;
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            Graph.initGraph(N);
            for(int m = 0; m < M; m++)
            {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();
                if(!(Graph.union(v1, v2) == -1))
                {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
