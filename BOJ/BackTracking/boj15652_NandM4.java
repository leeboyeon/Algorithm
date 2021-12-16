package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15652_NandM4 {
    static int M, N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        solution(0);
        System.out.println(sb);
        
    }

    static void solution(int cnt) throws IOException {

        if (cnt == M) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {

            // if(arr[cnt+1] > i) continue;
            if(cnt == 0){
                arr[cnt] = i;
                solution(cnt + 1);
            }
            if(cnt >= 1){
                if(arr[cnt-1] <= i){
                    arr[cnt] = i;
                    solution(cnt + 1);
                }
            }

        }

    }  
}
