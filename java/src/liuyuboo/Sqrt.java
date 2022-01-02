package liuyuboo;

import java.util.Arrays;

public class Sqrt {
    int[] data;
    int[] blocks;
    int N;//元素总数
    int B;//每组元素个数
    int Bn;//组数
    public Sqrt(int[] nums) {
        N = nums.length;
        if(N == 0) return;
        //向下取整, 往小里取
        B = (int)Math.sqrt(N);
        //组数是浮动的，因为B不是精确的，有余数就单拿出一组来放
        Bn = N / B + (N % B > 0 ? 1 : 0 );
        //处理data bloks
        data = Arrays.copyOf(nums,N);
        for (int i = 0; i < N; i++) {
            //0-b-1是一组
            //b-b+b-1是一组
            //多个数据归为一组
            blocks[i / B] += nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if(left < 0 || left >= N || right < 0 || right >= N || left > right ) {
            //与面试官约定交流
            return 0;
        }
        //开始组号
        int bstart = left / B;
        //结束组号
        int bend = right / B;


        int res = 0;
        if(bstart == bend) {
            //每一种情况对应一副图
            for (int i = left; i <= right; i++) {
                res += data[i];
            }
        }else {
            //因为组号是从0开始，计算本组内的元素，要+1
            for (int i = left; i <= (bstart + 1) * B; i++) {
                res += data[i];
            }
            //中间的块，不用遍历，直接拿统计值·
            for (int i = bstart + 1; i < bend; i++) {
                res += blocks[i];
            }
            //同理，错开的，-1就相当于 bend本身
            for (int i = bend * B; i <= right; i++) {
                res += data[i];
            }
        }

        return res;
    }
}
