class BSTIterator {
    Queue<TreeNode> q;

    public BSTIterator(TreeNode root) {
        q = new LinkedList<>();

        if(root == null){
            return;
        }

        inorder(root);
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        q.add(root);
        inorder(root.right);
    }

    public int next() {
        TreeNode curr = q.poll();
        return curr.val;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}