package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2583_영역구하기 {
    static int m,n,k;
    static int[][] map;
    static boolean[][] visit;
    static int count;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Pair> q;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        count = 0;
        visit = new boolean[n][m];
        q = new LinkedList<>();
        list = new ArrayList<>();
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine()," ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=x1;j<x2;j++){
                for(int u = y1;u<y2;u++){
                    map[j][u] = 1;
                }
            }
        }
        int area = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    q.offer(new Pair(i,j));
                    bfs();
                    area++;
                }
            }
        }
        System.out.println(area);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }


    }
    static public void bfs(){
        int count =1;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 1)continue;
                map[nx][ny] =1;
                count++;
                q.offer(new Pair(nx, ny));
            }
        }
        list.add(count);
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
