class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int more = target - nums[i];
            if(hMap.containsKey(more)){
                return new int[]{i, hMap.get(more)};
            }
            hMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}