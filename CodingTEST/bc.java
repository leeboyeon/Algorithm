package CodingTEST;

public class bc {
    public static void main(String[] args) {
        String input = "1101100";
        String[] split = input.split("");
        int oneCount = 0;

        for (int i = 1; i < input.length(); ++i) {
            if (split[i].equals(split[i - 1])) {
                if (split[i].equals("1")) {
                    ++oneCount;
                    split[i] = "0";
                } else if (oneCount > 0) {
                    split[i] = "1";
                    --oneCount;
                }
            }
        }

        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i] + " ");
        }
    }
}
