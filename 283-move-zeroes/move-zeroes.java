class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            // When we find a non-zero element, swap it to the front
            if (nums[i] != 0) {
                int temp = nums[zeroIndex];
                nums[zeroIndex] = nums[i];
                nums[i] = temp;
                
                // Move the zero pointer up by one
                zeroIndex++; 
            }
        }
    }
}