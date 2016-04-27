import java.math.BigInteger;

public class Sum1 {
    public static void main (String[] args) {
        int n = args.length;
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            String[] input = args[i].split("\\s");
            for (int j = 0; j < input.length; j++) 
            {
                if(input[j].length() == 0) {
                    continue;
                }
                int base = 10;
                if(input[j].startsWith("0x") || input[j].startsWith("0X")) {
                    input[j] = input[j].substring(2);
                    base = 16;
                }
                BigInteger cur = new BigInteger(input[j], base);
                sum = sum.add(cur);
            }
        }
        System.out.println(sum);
    }
}
