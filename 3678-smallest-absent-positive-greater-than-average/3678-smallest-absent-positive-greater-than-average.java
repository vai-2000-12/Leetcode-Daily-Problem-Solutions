class Solution {
    public int smallestAbsent(int[] nums) {
        int s=0;
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            s+=i;
            set.add(i);
        }
        int n=nums.length;
        int avg=s/n;
    
        int v;
        if(avg>0) v=avg+1;
        else v=1;
        while(set.contains(v)){
            v++;
        }
        return v;
    }
}