class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        boolean ans = true;
        for(int i=1;i<n;i++)
            {
                if((nums[i]%2==0 && nums[i-1]%2==0) || (nums[i]%2!=0 && nums[i-1]%2!=0))
                {
                    ans=false;
                    break;
                }   
            }
        return ans;
    }
}