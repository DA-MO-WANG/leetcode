package liuyuboo;

public class Z5954 {

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int size = plants.length;
        int ret = 0;
        if ((size & 1) == 1) {
            int sumleft = sum(plants, 0,size / 2 - 1);
            int sumright = sum(plants,size / 2 + 1, size - 1);
            int cleft = count(sumleft,capacityA);
            int cright = count(sumright,capacityB);
            int alice = (cleft + 1) * capacityA - sumleft;
            int bob = (cright + 1) * capacityB - sumright;
            ret = cleft + cright;
            if (alice >= bob) {

                ret = (plants[size / 2] <= alice) ? ret : ret + 1;
            }else {
                ret = (plants[size / 2] <= bob) ? ret : ret + 1;
            }
        }else {
            int sumleft = sum(plants, 0,size / 2 - 1);
            int sumright = sum(plants,size / 2, size - 1);
            int cleft = count(sumleft,capacityA);
            int cright = count(sumright,capacityB);
            ret = ret + cleft + cright;
        }
        return ret;
    }

    public int count(int sum, int capacity) {
        return sum % capacity == 0 ? sum / capacity - 1: sum / capacity;
    }
    public int sum(int[] plants, int begin, int over) {
        int sum = 0;
        for (int i = begin; i <= over; i++) {
            sum += plants[i];
        }
        return sum;
    }


    //暴力思路
    public int minimumRefill1(int[] plants, int capacityA, int capacityB) {
        int[] dp = new int[plants.length];
        int alice = capacityA;
        int bob = capacityB;
        int left = 0;
        int right = plants.length - 1;
        while (left <= right) {
            if (left == right) {
                if (alice >= bob) {
                    water(plants,dp,capacityA,left,alice);
                    left++;
                }else {
                    water(plants,dp,capacityB,right,bob);
                    right--;
                }
                break;
            }
            if(left == right - 1) {
                System.out.println(1111);
            }
            alice = water(plants,dp,capacityA,left,alice);
            bob = water(plants,dp,capacityB,right,bob);
            left++;
            right--;
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }
        return sum;
    }

    public int water(int[] plants, int[] dp,int capacity, int index, int role) {
        int diff = role - plants[index];
        if(diff < 0) {
            int c = Math.abs(diff) % capacity == 0 ? Math.abs(diff) / capacity : 1 + Math.abs(diff) / capacity;
            dp[index] = c;
            role = c * capacity + diff;
        }else {
            dp[index] = 0;
            role = diff;
        }
        return role;
    }

    public static void main(String[] args) {
        Z5954 z = new Z5954();
        int[] arr = {1,2,4,4,5};
        int alice = 6;
        int bob = 5;
        int i = z.minimumRefill(arr, alice, bob);
        System.out.println(i);

    }
}
