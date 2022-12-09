package com.example;

/**
 * 226 翻转二叉树
 */
public class Subject226Demo {
    public TreeNode invertTree(TreeNode root) {
       return nodeFlip(root);
    }

    /**
     * 使用dfs
     */
    public TreeNode nodeFlip(TreeNode node) {
        if(node == null){
            return null;
        }
        return new TreeNode(node.val, nodeFlip(node.right), nodeFlip(node.left));
    }
}