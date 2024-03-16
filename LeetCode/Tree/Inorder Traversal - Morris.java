class Solution {
     List<Integer> ans = new ArrayList<>();
     public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr!=null){
            if(curr.left!=null){
                prev = curr.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
            else{
                ans.add(curr.val);
                curr = curr.right;
            }
        }
        return ans; 
    }
}
