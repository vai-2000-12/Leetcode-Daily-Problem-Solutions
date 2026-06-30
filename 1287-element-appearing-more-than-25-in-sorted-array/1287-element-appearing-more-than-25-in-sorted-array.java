class Solution {
    public int findSpecialInteger(int[] arr) {
       HashMap<Integer, Integer> map = new HashMap<>();
       int n = arr.length;
       for(int i = 0 ; i < n ; i++){
         map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
       }   
       int ans = 0;
       for(Map.Entry<Integer, Integer> e : map.entrySet()){
           int key = e.getKey();
           int freq = e.getValue();

           if(freq > n/4){
             ans = key;
              return ans;
           }
       }
        return ans;
    }
}