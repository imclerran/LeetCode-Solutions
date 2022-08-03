class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] idx = {-1,-1};
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        
        // brute force solution:
        // O(n^2)
        // for(int i = 0; i < nums.length; i++) {
        //     for(int j = 0; j < nums.length; j++) {
        //         if(nums[i] + nums[j] == target) {
        //             idx[0] = i;
        //             idx[1] = j;
        //             return idx;
        //         }
        //     }
        // }
        
        // optimized solution:
        // O(n)
        for(int i = 0; i < nums.length; i++) {
            int lookfor = target - nums[i];
            if(numMap.containsKey(lookfor)) {
                idx[0] = i;
                idx[1] = numMap.get(lookfor);
                break;
            }
            numMap.put(nums[i], i);
        }
        
        
        return idx;
    }
}