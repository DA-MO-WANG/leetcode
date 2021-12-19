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
}
