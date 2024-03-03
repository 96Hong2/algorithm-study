package study.baekjoon.week4;
import java.util.Scanner;

public class BOJ9372_상근이의_여행_실버4_권은홍
{
    /*
    public static class Graph
    {
        Edge[] edges;
    }

    public static class Edge
    {
        int vertex1, vertex2;
        public Edge(int a, int b)
        {
            this.vertex1 = a;
            this.vertex2 = b;
        }
    }
    */

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++)
        {
            // Graph graph = new Graph();
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            // graph.edges = new Edge[M];
            for(int m = 0; m < M; m++)
            {
                // Edge edge = new Edge(scanner.nextInt(), scanner.nextInt());
                // graph.edges[m] = edge;
                scanner.nextInt();
                scanner.nextInt();
            }
            System.out.println(N-1); // MST에서 간선의 개수는 항상 정점개수-1
        }
    }
}
