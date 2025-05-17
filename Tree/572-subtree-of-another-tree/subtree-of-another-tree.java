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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Boolean ans = false;
        while(!q.isEmpty()){
            TreeNode rv = q.poll();
            if(rv.val==subRoot.val) ans = ans || is(rv,subRoot);
            if(rv.left!=null) q.add(rv.left);
            if(rv.right!=null) q.add(rv.right);
        }
        return ans;
    }
    public boolean is(TreeNode node1,TreeNode node2){
        if(node1==null && node2==null) return true;
        if(node1==null || node2==null) return false;
        boolean lft = is(node1.left,node2.left);
        boolean rgt = is(node1.right,node2.right);
        return node1.val==node2.val && lft && rgt;
    }
}