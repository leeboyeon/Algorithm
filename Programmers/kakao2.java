package Programmers;

import java.util.ArrayList;

public class kakao2 {

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        solution(n, k);
    }

    public static int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while (n >= 1) {
            sb.insert(0, n % k);
            n /= k;
        }
        ArrayList<String> list = new ArrayList<>();
        String numbers = sb.toString().trim();
        String[] num = numbers.split("0");
        for (int i = 0; i < num.length; i++) {
            if (num[i].equals("")) {
                continue;
            } else {
                list.add(num[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            long nums = Long.parseLong(list.get(i));
            if (isPrime(nums) == true) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static boolean isPrime(long num) {
        boolean result = false;
        long end = num / 2;
        if (num == 2) {
            result = true;
        } else {
            for (int i = 2; i <= end; i++) {
                if (num % i == 0) {
                    result = false;
                    break;
                } else
                    result = true;
            }
        }

        return result;
    }
}
