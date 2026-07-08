class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0 ; i < nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }       
        int n = nums.length;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();

            if(val > Math.floor(n/3)){
                lst.add(key);
            }
        }
        return lst;
    }
}