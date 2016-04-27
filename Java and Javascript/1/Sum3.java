public class Sum3 {
    public static void main(String[] args) {
        int n = args.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            String[] input = args[i].split("\\s");
            for (int j = 0; j < input.length; j++) {
                if (input[j].length() == 0) {
                    continue;
                }
                int base = 10;
                String[] parsed = input[j].split("_");
                if (parsed.length > 2) {
                	System.out.println("Wrong input format!!");
                	return;
                }
                if (parsed.length == 2) {
                    if(parsed[1].length() != 1 || Character.digit(parsed[1].charAt(0), 36) < 0) {
                		System.out.println("Wrong radix format!!!");
                        return;
                    }
                    base = Character.digit(parsed[1].charAt(0), 36) + 1;
                }
                sum += Long.parseLong(parsed[0], base);
            }
        }
        System.out.println(sum);
    }
}
