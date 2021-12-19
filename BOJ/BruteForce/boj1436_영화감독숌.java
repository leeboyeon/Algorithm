package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1436_영화감독숌 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int title = 666;
        String tmp = "";
        for(int i=0;i<N;i++){
            title++;
            tmp = String.valueOf(title);
        }
    }
}
