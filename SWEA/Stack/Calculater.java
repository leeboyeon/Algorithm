package SWEA.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculater {
    static Stack<Character> op = new Stack<>();
    static Stack<Integer> sum = new Stack<>();

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String str = br.readLine();
            String tmp = convert_to_post(str);
            int result = calc_post_exp(tmp);
            bw.write("#" + tc + " " + result);
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

    static int calc_post_exp(String exp) {// ������ ���
        int answer = 0;
        int n1, n2;
        for (int i = 0; i < exp.length(); i++) {
            char tmp = exp.charAt(i);
            if (tmp - '0' >= 0 && tmp - '0' < 10)
                sum.push(tmp - '0');
            else {
                switch (tmp) {
                    case '+': {
                        int result = 0;
                        for (int j = 0; j < 2; j++)
                            result += sum.pop();
                        sum.push(result);
                        break;
                    }
                    case '*': {
                        int result = 1;
                        for (int j = 0; j < 2; j++)
                            result *= sum.pop();
                        sum.push(result);
                        break;
                    }
                }
            }
        }
        answer = sum.pop();
        return answer;
    }

    static String convert_to_post(String exp) {
        String post = "";
        for (int i = 0; i < exp.length(); i++) {
            char tmp = exp.charAt(i);
            if (tmp - '0' >= 0 && tmp - '0' < 10)
                post += tmp;
            else {
                while (!op.empty() && get_priority(op.peek()) >= get_priority(tmp)) {
                    // �켱���� ó�� �κ�
                    if (op.peek() == '(')
                        break;
                    post += op.pop();
                }
                if (tmp == ')') {
                    while (op.peek() != '(') {
                        post += op.pop();
                    }
                    op.pop();
                } else
                    op.push(tmp);
            }
        }
        while (!op.empty())
            post += op.pop();
        return post;
    }

    static int get_priority(char op) {
        int pri = 0;
        switch (op) {
            case '+':
                pri = 0;
                break;
            case '*':
                pri = 1;
                break;
            case ')':
            case '(': {
                pri = 2;
                break;
            }
        }
        return pri;
    }
}
