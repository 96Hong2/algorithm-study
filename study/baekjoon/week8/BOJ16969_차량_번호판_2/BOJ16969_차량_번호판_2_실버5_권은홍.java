package study.baekjoon.week8.BOJ16969_차량_번호판_2;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ16969_차량_번호판_2_실버5_권은홍 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] format = reader.readLine().split("");
        String before = "x";
        long result = 1;
        long dNum =  1000000009;
        for(String x : format)
        {
            if(x.equals("d"))
            {
                if(before.equals("d")) result *= 9;
                else result *= 10;
            }
            else
            {
                if(before.equals("c")) result *= 25;
                else result *= 26;
            }
            if(result > dNum) result %= dNum;
            before = x;
        }
        System.out.println(result % dNum);
    }
}
