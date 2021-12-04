package liuyuboo;

public class S11 {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        int mid = l;
        while(numbers[l] >= numbers[r]) {
            mid = (r + l) / 2;
            if(numbers[mid] == numbers[l] && numbers[l] == numbers[r]) {
                return findMin11(numbers,l,r);
            }
            if(numbers[mid] >= numbers[l]) {
                l = mid;
            }else if(numbers[mid] <= numbers[r]) {
                r = mid;
            }
        }
        return numbers[mid];
        // return 0;
    }
    public int findMin11(int[] arr, int p, int q) {
        int ret = arr[p];
        for(int i = p + 1; i <= q; i++) {
            if(arr[i] < ret) {
                ret =  arr[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        S11 s11 = new S11();
        int min11 = s11.minArray(arr);
        System.out.println(min11);

    }
}
