package liuyuboo;

public class Z5954 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int[] dp = new int[plants.length];
        int alice = capacityA;
        int bob = capacityB;
        int left = 0;
        int right = plants.length - 1;
        while (left <= right) {
            if (left == right) {
                if (alice >= bob) {
                    water(plants,dp,capacityA,left,alice);
                }else {
                    water(plants,dp,capacityB,right,bob);
                }
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
            int c = Math.abs(diff) % capacity == 0 ? diff / capacity : 1 + diff / capacity;
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
