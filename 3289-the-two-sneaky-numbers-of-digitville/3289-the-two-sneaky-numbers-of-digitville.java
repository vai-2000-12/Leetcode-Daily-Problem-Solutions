class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i< n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
       ArrayList<Integer> lst = new ArrayList<>(); 
       for(Map.Entry<Integer, Integer> e : map.entrySet()){
           int key = e.getKey();
           int freq = e.getValue();

           if(freq == 2){
                lst.add(key);
           }
       }

       int[] ans = new int[lst.size()];
       int len = lst.size();
       for(int i = 0 ; i < len; i++){
         ans[i] = lst.get(i);
       }

       return ans;
    }
}