package Programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class kakao3 {
    public static void main(String[] args) throws ParseException {
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
        solution(fees, records);
    }

    public static int[] solution(int[] fees, String[] records) throws ParseException {
        int[] answer = {};
        StringBuilder sb = new StringBuilder();
        Queue<Pair> q = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        List<Integer> costlist = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i], " ");
            String time = st.nextToken();
            String carnum_s = st.nextToken();
            int carnum = Integer.parseInt(carnum_s);
            String type = st.nextToken();

            if (type.equals("IN")) {
                q.offer(new Pair(time, carnum));

            } else {
                while (!q.isEmpty()) {
                    Pair cur = q.poll();
                    if (carnum == cur.number) {
                        Date date1 = new SimpleDateFormat("HH:mm").parse(cur.time);
                        Date date2 = new SimpleDateFormat("HH:mm").parse(time);

                        long diffMin = (date2.getTime() - date1.getTime()) / 60000;
                        int cost = 0;
                        // 기본요금만 내는경우
                        if (diffMin <= fees[0]) {

                            cost += fees[1];
                        }
                        // 추가요금이 있는경우
                        else {
                            cost += fees[1] + ((diffMin - fees[0]) / fees[2]) * fees[3];
                        }
                        costlist.add(cost);
                        sb.append(cost);
                    }
                }
            }
        }
        answer = new int[costlist.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = costlist.get(i);
        }
        return answer;
    }

    static class Pair {
        String time;
        int number;

        public Pair(String time, int number) {
            this.time = time;
            this.number = number;

        }
    }
}
