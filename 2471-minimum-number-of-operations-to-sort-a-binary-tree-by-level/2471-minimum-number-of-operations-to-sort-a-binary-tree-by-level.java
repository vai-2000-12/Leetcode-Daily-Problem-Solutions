/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
         // Store all the Values of the Levels in ArrayList (Perform the Level Order traversal)
         // Check which are unsorted for each level
         // and find min swaps required to make it strictly increasing..

       //PERFORM THE LEVEL ORDER TRAVERSAL:-
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
        int ans = 0;
       while(!q.isEmpty()){
         int size= q.size();
         ArrayList<Integer> lst = new ArrayList<>();

         for(int i = 0 ; i < size ; i++){
           TreeNode curr = q.poll();
           lst.add(curr.val);

          if(curr.left != null){
            q.add(curr.left);
           }

           if(curr.right != null){
             q.add(curr.right);
            }
          }
        ans+=minSwaps(lst);
       }
       return ans;
    }

    public int minSwaps(ArrayList<Integer> level){
        int n = level.size();

        int[] arr = new int[n];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = level.get(i);
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == sorted[i])
                continue;

            swaps++;

            int curr = arr[i];
            int idx = map.get(sorted[i]);

            // swap
            arr[i] = arr[idx];
            arr[idx] = curr;

            // update map
            map.put(arr[i], i);
            map.put(arr[idx], idx);
        }

        return swaps;


    }
}