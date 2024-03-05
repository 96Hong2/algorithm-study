package study.baekjoon.week5.BOJ11724_연결_요소의_개수;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class BOJ11724_연결_요소의_개수_실버2_권은홍 {
    public static class Graph
    {
        static int V;
        static HashMap<Integer, LinkedList<Integer>> adjMap = new HashMap<>();
        static boolean[] visited;
        static int notVisitCnt;

        public static void initGraph(int v)
        {
            V = v;
            visited = new boolean[V+1];
            for(int i = 1; i < V+1; i++)
            {
                adjMap.put(i, new LinkedList<>());
            }
            notVisitCnt = V;
        }

        public static void addEdge(int v1, int v2)
        {
            adjMap.get(v1).add(v2);
            adjMap.get(v2).add(v1);
        }

        public static int getConnectedComponent(int start)
        {
            int result = 0;
            while(notVisitCnt > 0)
            {
                bfs(start);
                result++;
            }
            return result;
        }

        public static void bfs(int start)
        {
            Queue<Integer> que = new LinkedList<>();
            que.add(start);
            visited[start] = true;
            notVisitCnt--;
            while(!que.isEmpty())
            {
                int curr = que.poll();
                notVisitCnt--;
                LinkedList<Integer> adjList = adjMap.get(curr);
                for(int adj : adjList)
                {
                    if(!visited[adj])
                    {
                        visited[adj] = true;
                        que.add(adj);
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Graph.initGraph(N);
        int v1 = 0, v2 = 0;
        for(int m = 0; m < M; m++)
        {
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            Graph.addEdge(v1, v2);
        }

        System.out.println(Graph.getConnectedComponent(v1));
    }
}
