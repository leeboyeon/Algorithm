package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3055_탈출 {
    static char[][] map;
    static int R, C;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static Queue<Pair> move;
    static Queue<Pair> water;
    static boolean[][] visit;
    static int time;
    static boolean flag;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visit = new boolean[R][C];
        String str = "";
        move = new LinkedList<>();
        water = new LinkedList<>();
        int endx = 0;
        int endy = 0;
        time = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    move.add(new Pair(i, j));
                }
                if (map[i][j] == '*') {
                    water.add(new Pair(i, j));
                } 
            }
        }
        time = 0;

        go();
        if(flag = false){
            System.out.println(time);
        }
        
    }

    public static void go() {
        while(true){
            time++;
            for(int i=0;i<water.size();i++){
                Pair wcur = water.poll();
                for(int j=0;j<4;j++){
                    int nx = wcur.x+dx[j];
                    int ny = wcur.y+dy[j];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if(map[nx][ny] == '.'){
                            map[nx][ny] = '*';
                            water.add(new Pair(nx,ny));
                        }
                    }               
                }
            }
            if(move.size() == 0){
                flag = true;
                System.out.println("KAKTUS");
                break;
            }
            for(int i=0;i<move.size();i++) {
                Pair mcur = move.poll();
                for(int j=0;j<4;j++){
                    int nx = mcur.x + dx[j];
                    int ny = mcur.y + dy[j];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if(map[nx][ny] == 'D'){
                            return;
                        }
                        if(map[nx][ny] == '.'){
                            map[nx][ny] ='S';
                            move.add(new Pair(nx,ny));
                        }
                    }        
                }
            }
        }
        // for (int i = 0; i < water.size(); i++) {
        //     Pair wcur = water.poll();
        //     for (int k = 0; k < 4; k++) {
        //         int nx = wcur.x + dx[k];
        //         int ny = wcur.y + dy[k];
        //         if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
        //             if (map[nx][ny] == '.') {
        //                 map[nx][ny] = '*';
        //                 water.add(new Pair(nx, ny));
        //             }
        //             if (map[nx][ny] == 'X' || map[nx][ny] == '*' || map[nx][ny] == 'D') {
        //                 continue;
        //             }
        //         }
        //     }
        // }
        // if (move.size() == 0) {
        //     return;
        // }
        // for (int i = 0; i < move.size(); i++) {
        //     Pair mcur = move.poll();
        //     for (int k = 0; k < 4; k++) {
        //         int nx = mcur.x + dx[k];
        //         int ny = mcur.y + dy[k];
        //         if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
        //             if (visit[nx][ny] == false) {

        //                 visit[nx][ny] = true;
        //                 map[mcur.x][mcur.y] = '.';
        //                 if (map[nx][ny] == 'D') {
        //                     time = depth + 1;
        //                     flag = true;
        //                     return;
        //                 }
        //                 if (map[nx][ny] == '.') {
        //                     map[nx][ny] = 'S';
        //                     move.add(new Pair(nx, ny));
        //                 }

        //                 if (map[nx][ny] == 'X' || map[nx][ny] == '*') {
        //                     continue;
        //                 }

        //             }
        //         }

        //     }
        // }
        // go(depth + 1);
    }
}
