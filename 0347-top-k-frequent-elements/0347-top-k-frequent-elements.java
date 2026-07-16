class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
      int n = nums.length;
      for(int i = 0 ; i < n ; i++){
         map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
      }  

      PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

      for(Map.Entry<Integer, Integer> e : map.entrySet()){
         pq.offer(e);


         if (pq.size() > k) {
            pq.poll();
         }   
      }

        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll().getKey();
        }

        return ans;  
    }
}