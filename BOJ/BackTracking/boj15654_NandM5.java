package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15654_NandM5 {
    static int N,M;
    static ArrayList<Integer> list;
    static int[] arr;
    static int[] comb;
    static boolean[] visit;
    static StringBuffer sb = new StringBuffer();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        comb = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }
        Arrays.sort(arr);
        back(0,0);
       
        System.out.println(sb.toString());
    }
    static void back(int idx, int count){
        
        if(count == M){
            for(int i=0;i<M;i++){
                if(comb[i] != 0){
                    sb.append(comb[i]+" ");
                }
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i] = true;
                comb[count] = arr[i];
                back(i+1, count+1);
                visit[i] = false;
            }
            
        }
    }
}
