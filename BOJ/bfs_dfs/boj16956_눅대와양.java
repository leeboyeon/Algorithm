package BOJ.bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16956_눅대와양 {
    static int r,c;
    static char[][] map;
    static Queue<Pair> w;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean check;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
    
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        w = new LinkedList<>();
        check = false;
        String[] str = new String[r];
        for(int i=0;i<r;i++){
            str[i] = br.readLine();
            for(int j=0;j<c;j++){
                map[i][j] = str[i].charAt(j);
                if(map[i][j] == 'S'){
                    w.offer(new Pair(i,j));
                }
            }
        }

        bfs();

        if(check == false){
            System.out.println("1");
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }else{
            System.out.println("0");
        }
    
    }
    public static void bfs(){
        while(!w.isEmpty()){
            Pair cur = w.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if(map[nx][ny] == 'S' || map[nx][ny] =='D') continue;
                if(map[nx][ny] == 'W'){
                    check = true;
                    break;
                }
                map[nx][ny] = 'D';
            }
            if(check == true) break;
        }
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
