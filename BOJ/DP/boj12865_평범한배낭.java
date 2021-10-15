package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12865_평범한배낭 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] bag = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            bag[i][0] = w;
            bag[i][1] = v;
        }
        int max = 0;
        int c = 0;
        for(int i=0;i<N-1;i++){
            // 배낭 1개
            if(bag[c++][0] <= K){
                max = Math.max(bag[i][0], bag[i+1][0]);
            }
        }
    }
}
