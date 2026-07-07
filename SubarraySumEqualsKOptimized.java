import java.util.*;

public class SubarraySumEqualsKOptimized {

    // Optimized using prefix sum + hashmap
    public static int subarraySumEqualsK(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1); // sum 0 already seen once

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int need = prefixSum - k;
            if (mp.containsKey(need)) {
                count += mp.get(need);
            }

            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(subarraySumEqualsK(nums, k));
        sc.close();
    }
}

