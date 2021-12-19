package liuyuboo;

public class Z272 {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sbz = new StringBuffer();
        for(int i = 1; i < spaces.length; i++) {

            StringBuffer sb = new StringBuffer(s.substring(spaces[i - 1],spaces[i] - 1));
            sb.append(" ");
            sbz.append(sb);


        }
        return sbz.toString();
    }

    public long getDescentPeriods(int[] prices) {
        long count = prices.length;
        for(int i = 0; i < prices.length - 1; i++) {
            int j = i + 1;
            while(j < prices.length) {
                if(prices[j] - prices[j - 1] != 1) {
                    break;
                }else {
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Z272 z272 = new Z272();
        long q = z272.getDescentPeriods(new int[]{3,2,1,4});
        System.out.println(q);
    }
}
