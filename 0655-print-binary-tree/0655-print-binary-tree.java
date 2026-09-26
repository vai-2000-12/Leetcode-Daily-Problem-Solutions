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
    public List<List<String>> printTree(TreeNode root) {
        
        // Mo of rows = height of the Tree + 1;
        // No of cols  = 2^height of Tree +1 + 1;
        // root Location : res[0][(n-1)/2]
        // for left child = res[r+1][c-2^height-r-1];
        // for right child = res[r+1][c+2^hieght-r-1];
        // for empty cells -- empty string --> ""
        int height = getHeight(root)-1;
        
        int row = height+1; 
        int col = (int)Math.pow(2, height+1) - 1;
        
        String[][] matrix = new String[row][col];

         // Fill all cells with ""
        for(int i = 0; i < row; i++){
            Arrays.fill(matrix[i], "");
        }

        // Fill the tree
        fillMatrix(root, matrix, 0, (col - 1) / 2, height);

        // Convert String[][] to List<List<String>>
        List<List<String>> res = new ArrayList<>();

        for(int i = 0; i < row; i++){
            res.add(Arrays.asList(matrix[i]));
        }

        return res;
    }

    public void fillMatrix(TreeNode root, String[][] matrix, int r, int c, int height){
        
        if(root == null){
            return;
        }

        matrix[r][c] = String.valueOf(root.val);

        int gap = (int)Math.pow(2, height - r - 1);

        if(root.left != null){
            fillMatrix(root.left, matrix, r + 1, c - gap, height);
        }

        if(root.right != null){
            fillMatrix(root.right, matrix, r + 1, c + gap, height);
        }
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            height++;
        }
        return height;
    }
}