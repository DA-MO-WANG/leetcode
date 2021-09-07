package hw;

public class RecursionPermutation {

    public static void permutate(String input){
        if(input == null)
            throw new IllegalArgumentException();
        char[] data = input.toCharArray();
        permutate(data, 0);
    }
    //递归方法
    //递归逻辑就是总是要惊醒元素交换--重复操作，不同的递归变量是，交换发起方的位置会逐步轮换
    public static void permutate(char[] data, int begin){
        int length = data.length;
        if(begin == length)
            System.out.println(data);
        for(int i = begin ; i < length; i++)
        {
            if(isUnique(data, begin, i)){
                swap(data, begin, i);
                permutate(data, begin + 1);
                swap(data, begin, i);
            }
        }
    }
    //判断交换的数与后面的数是否相同
    private static boolean isUnique(char[] data, int begin, int end){
        for(int i = begin; i < end; i++)
            if(data[i] == data[end])
                return false;
        return true;
    }
    //简单的交换逻辑
    private static void swap(char[] data, int left, int right) {
        char temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }


    public static void main(String... args){
        RecursionPermutation.permutate("aac");
    }

}
