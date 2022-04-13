package Programmers;

public class 괄호회전하기 {
    static int answer = 0;

    public static void main(String[] args) {
        String str = "[](){}";

        System.out.println(solution(str));
    }

    public static int solution(String s) {

        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {
            lotation(arr);
        }

        System.out.println(answer);
        return answer;
    }

    public static void lotation(char[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            char tmp = arr[0];
            arr[i - 1] = arr[i];
            arr[arr.length - 1] = tmp;
        }

        checkTheString(arr);
    }

    public static void checkTheString(char[] arr) {
        char[] left = { '{', '(', '[' };
        char[] right = { '}', ')', ']' };
        boolean[] visit = new boolean[3];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < left.length; j++) {
                if (arr[i] == left[j]) {
                    visit[j] = true;
                }
                if (arr[i] == right[j] && visit[j] == true) {
                    count++;
                }
            }
        }

        if (count == 3) {
            answer++;
        }
    }
}
