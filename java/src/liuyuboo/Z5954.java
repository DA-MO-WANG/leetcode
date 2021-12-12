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
                    left++;
                }else {
                    water(plants,dp,capacityB,right,bob);
                    right--;
                }
                break;
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
        int[] arr = {726,739,934,116,643,648,473,984,482,85,850,806,146,764,156,66,186,339,985,237,662,552,800,78,617,933,481,652,796,594,151,82,183,241,525,221,951,732,799,483,368,354,776,175,974,187,913,842};
        int alice = 1439;
        int bob = 1207;
        int i = z.minimumRefill(arr, alice, bob);
        System.out.println(i);

    }
}
