class Solution {
    public int removeDuplicates(int[] nums) {
       int n = nums.length;

       LinkedHashSet<Integer> set = new LinkedHashSet<>();
       
       for(int i = 0 ; i < n ; i++){
        set.add(nums[i]);
       }

         int k = 0;

        for(int x : set) {
            nums[k] = x;
            k++;
        }

        return k; 
       
    }
}