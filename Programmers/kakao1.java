package Programmers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class kakao1 {
    public static void main(String[] args) throws IOException {
        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        solution(id_list, report, 2);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        String[][] userid = new String[report.length][2];
        Stack<String> singo = new Stack<>();
        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i], " ");
            userid[i][0] = st.nextToken();
            userid[i][1] = st.nextToken();
        }
        for (int j = 0; j < id_list.length; j++) {
            for (int i = 0; i < userid.length; i++) {
                if (id_list[j].equals(userid[i][0])) {
                    if (!singo.equals(userid[i][1])) {
                        singo.push(userid[i][1]);
                        answer[j]++;
                    }
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == k) {

            }
        }
        int[] listid = new int[id_list.length];
        int count = 0;
        for (int i = 0; i < userid.length; i++) {
            for (int j = 0; j < id_list.length; j++) {
                if (userid[i][1].equals(id_list[j])) {
                    listid[j] += 1;
                }
            }
        }
        int cnt = 0;
        Queue<String> stack = new LinkedList<>();
        for (int i = 0; i < listid.length; i++) {
            if (listid[i] == k) {
                // System.out.println(id_list[i]);
                for (int j = 0; j < userid.length; j++) {
                    if (userid[j][1].equals(id_list[i])) {
                        stack.offer(userid[j][0]);
                    }
                }

            }
        }
        System.out.println(stack.toString());
        while (!stack.isEmpty()) {
            String cur = stack.peek();
            for (int i = 0; i < id_list.length; i++) {
                if (cur.equals(id_list[i])) {
                    answer[i] += 1;
                    stack.poll();
                } else
                    continue;
            }
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

        return answer;
    }
}
