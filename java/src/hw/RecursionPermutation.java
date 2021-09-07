package hw;

public class RecursionPermutation {

    public static void permutate(String input){
        if(input == null)
            throw new IllegalArgumentException();
        char[] data = input.toCharArray();
        permutate(data, 0);
    }

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

    private static boolean isUnique(char[] data, int begin, int end){
        for(int i = begin; i < end; i++)
            if(data[i] == data[end])
                return false;
        return true;
    }

    private static void swap(char[] data, int left, int right) {
        char temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }


    public static void main(String... args){
        RecursionPermutation.permutate("aac");
    }

}
