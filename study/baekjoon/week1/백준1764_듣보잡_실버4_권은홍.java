package study.baekjoon.week1;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 백준1764_듣보잡_실버4_권은홍 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        HashSet<String> hashSet = new HashSet<>(); // 듣지 못한 사람 목록
        ArrayList<String> result = new ArrayList<>(); // 듣보잡 결과 리스트
        int count = 0; // 듣보잡 수

        for(int i = 0; i < n; i++)
        {
            hashSet.add(reader.readLine());
        }
        for(int j = 0; j < m; j++)
        {
            String unSeen = reader.readLine();
            if(hashSet.contains(unSeen))
            {
                count++;
                result.add(unSeen);
            }
        }

        // 사전순으로 정렬
        Collections.sort(result);
        // 출력
        System.out.println(count);
        for(String name : result)
        {
            System.out.println(name);
        }
    }

}
