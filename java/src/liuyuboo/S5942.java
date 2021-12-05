package liuyuboo;

import java.util.Arrays;

public class S5942 {
    public int[] getOrder(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new BSTSet<>();


                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == 0) {
                        continue;
                    }

                        int three = nums[i] * 100;
                        for (int j = 0; j < nums.length; j++) {
                            if (j == i) {
                                continue;
                            }
                            int two = nums[i] * 10;
                            for (int q = 0; q < nums.length; q++) {
                                if (q == i || q == j || nums[q] % 2 != 0) {
                                    continue;
                                }
                                int one = nums[i] * 1;
                                set.add(three + two + one);
                            }

                }
            }
            for ()
        }

    }


}
