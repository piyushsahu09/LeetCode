class Solution {
    public int maxProduct(int[] nums) {

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int current = nums[i];

            int tempMax = Math.max(
                current,
                Math.max(max * current, min * current)
            );

            int tempMin = Math.min(
                current,
                Math.min(max * current, min * current)
            );

            max = tempMax;
            min = tempMin;

            result = Math.max(result, max);
        }

        return result;
    }
}