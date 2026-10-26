import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Step 1: Convert the integer array to a String array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        // Step 2: Sort using a Custom Comparator (Lambda Expression)
        // (b + a).compareTo(a + b) sorts in descending order based on our trick
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        
        // Step 3: Handle the edge case where the array is full of zeros
        if (strNums[0].equals("0")) {
            return "0";
        }
        
        // Step 4: Build the final string
        StringBuilder result = new StringBuilder();
        for (String numStr : strNums) {
            result.append(numStr);
        }
        
        return result.toString();
    }
}