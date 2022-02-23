package BOJ.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class boj1655_가운데를말해요 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> sort1 = new PriorityQueue<>(); // 오름차순정렬
        PriorityQueue<Integer> sort2 = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순정렬

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (sort1.size() == sort2.size()) {
                if (!sort1.isEmpty() && value > sort1.peek()) {
                    sort2.offer(sort1.poll());
                    sort1.offer(value);
                } else {
                    sort2.offer(value);
                }
            } else {
                if (!sort2.isEmpty() && value < sort2.peek()) {
                    sort1.offer(sort2.poll());
                    sort2.offer(value);
                } else {
                    sort1.offer(value);
                }
            }
            sb.append(sort2.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
