package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1446_지름길 {
    static class Pair implements Comparable<Pair> {
        int s;
        int g;
        int v;

        public Pair(int s, int g, int v) {
            this.s = s;
            this.g = g;
            this.v = v;
        }

        @Override
        public int compareTo(Pair p) {
            return this.v - p.v;

        }
    }

    static int[] distance;
    static ArrayList<Pair> map;
    static int D;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        distance = new int[D + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (g > D)
                continue;
            if (g - s <= v)
                continue;

            map.add(new Pair(s, g, v));
        }
        // dijkstra(0);
        // System.out.println(distance[D]);

        result = Integer.MAX_VALUE;
        go(0, 0);
        System.out.println(result);

        // Collections.sort(map, new Comparator<Pair>() {
        // public int compare(Pair p1, Pair p2) {
        // if (p1.s == p2.s)
        // return p1.g - p2.g;
        // return p1.s - p2.s;
        // }
        // });

        // for (int i = 0; i < map.size(); i++) {
        // System.out.println(map.get(i).s + " " + map.get(i).g + " " + map.get(i).v);
        // }

        // int index = 0;
        // int lastPoint = 0;
        // int sum = 0;
        // int size = 0;
        // while (true) {
        // Pair cur = map.get(index);
        // size--;
        // if (lastPoint == cur.s) {
        // lastPoint = cur.g - cur.s;
        // sum += cur.v;
        // } else if (lastPoint < cur.s) {
        // if (sum > cur.v) {
        // sum = cur.v;
        // lastPoint = cur.g - cur.s;
        // } else
        // continue;
        // }
        // if (lastPoint == D) {
        // System.out.println(sum);
        // break;
        // }
        // if (size == 0) {
        // sum = sum + (D - lastPoint);
        // System.out.println(sum);
        // break;
        // }

        // lastPoint = cur.g - cur.s;
        // sum += cur.v;
        // }
    }

    public static void go(int index, int sum) {
        if (sum >= result)
            return;
        if (index == D) {
            result = sum;
            return;
        }
        for (int i = 0; i < map.size(); i++) {
            Pair cur = map.get(i);
            if (cur.s == index) {
                go(cur.g, sum + cur.v);
            }
        }
        go(index + 1, sum + 1);
    }
    // public static void dijkstra(int idx) {
    // PriorityQueue<Pair> pq = new PriorityQueue<>();
    // pq.offer(new Pair(idx, 0, 0));
    // distance[idx] = 0;

    // while (!pq.isEmpty()) {
    // Pair cur = pq.poll();
    // int goal = cur.g;
    // boolean check = false;
    // for (Pair next : map) {
    // if (next.s >= goal) {
    // if (next.g > D)
    // continue;
    // int tmp = next.s - goal;
    // check = true;
    // if (distance[next.g] > distance[goal] + next.v + tmp) {
    // distance[next.g] = distance[goal] + next.v + tmp;
    // pq.offer(new Pair(goal, next.g, distance[next.g]));
    // }
    // }
    // }
    // distance[D] = Math.min(distance[goal] + D - goal, distance[D]);
    // }

    // }
}
