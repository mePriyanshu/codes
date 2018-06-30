/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
class Solution {
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
        
    }
    public void inorder(TreeNode root)
    {
        if(root!=null)
        {
            inorder(root.left);
            if(first==null&&prev.val>=root.val)
                first=prev;
            if(first!=null&&prev.val>=root.val)
                second=root;
             prev=root;
            inorder(root.right);
        }
    }
}
