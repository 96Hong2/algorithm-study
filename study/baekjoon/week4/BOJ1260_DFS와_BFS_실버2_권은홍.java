package study.baekjoon.week4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1260_DFS와_BFS_실버2_권은홍 {

    public static class Graph
    {
        static int V; // 정점의 개수
        static LinkedList[] adjArr; // 인접 리스트
        static String resultStr = ""; // 결과

        public static void setGraph(int v)
        {
            V = v;
            adjArr = new LinkedList[V+1];
            for(int i = 1; i < V+1; i++) adjArr[i] = new LinkedList<Integer>();
        }

        public static void addEdge(int v1, int v2)
        {
            adjArr[v1].add(v2);
            adjArr[v2].add(v1);
        }

        public static void dfs(int start)
        {
            resultStr = "";
            boolean[] visited = new boolean[V+1];
            visited[start] = true;
            dfsUtil(visited, start);
            System.out.println(resultStr.substring(0, resultStr.length()-1));
        }

        public static void dfsUtil(boolean[] visited, int vertex)
        {
            // 인접 리스트 꺼내기
            LinkedList<Integer> adjList = adjArr[vertex];
            Collections.sort(adjList);
            resultStr += (vertex + " ");
            for(int v : adjList)
            {
                if(!visited[v])
                {
                    visited[v] = true;
                    dfsUtil(visited, v);
                }
            }
        }

        public static void bfs(int start)
        {
            resultStr = "";
            boolean[] visited = new boolean[V+1];
            Queue<Integer> que = new LinkedList<>();
            que.add(start);
            visited[start] = true;
            int cur = start;
            while (!que.isEmpty())
            {
                cur = que.poll();
                resultStr += (cur + " ");
                LinkedList<Integer> adjlist = adjArr[cur];
                Collections.sort(adjlist);
                for(int adj : adjlist)
                {
                    if(!visited[adj])
                    {
                        que.add(adj);
                        visited[adj] = true;
                    }
                }
            }
            System.out.println(resultStr.substring(0, resultStr.length()-1));
        }

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        int V = Integer.parseInt(info[2]);
        Graph.setGraph(N);
        for(int m = 0; m < M; m++)
        {
            String[] vertexes = reader.readLine().split(" ");
            Graph.addEdge(Integer.parseInt(vertexes[0]), Integer.parseInt(vertexes[1]));
        }
        Graph.dfs(V);
        Graph.bfs(V);
    }
}
