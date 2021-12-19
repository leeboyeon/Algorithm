package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15685_드래곤커브 {
    static int[][] map = new int[101][101];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
        }
    }
    static void dragonCurve(int x, int y, int d, int g){
        // ArrayList<Integer> dir = new ArrayList<>();
        // dir.add(d);

        // for(int i=0;i<g;i++){
        //     int size = dir.size();
        //     for(int j=size-1;j>=0;j--){
        //         dir.add((dir.get(j)+1) % 4);
        //     }
        // }
    }
}
