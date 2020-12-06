package chapter2.struct.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private BinaryTreeNode root;
    static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    // 假设中序遍历和前序遍历中都不含重复元素
    public static BinaryTree constructFromPreorderAndInorder(int[] preorder, int[] inorder) throws Exception {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            throw new Exception("invalid input");
        }
        BinaryTreeNode rootNode = constructFromPreAndInCore(preorder, 0, inorder, 0, preorder.length);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = rootNode;
        return binaryTree;
    }

    private static BinaryTreeNode constructFromPreAndInCore(int[] preorder, int prestart, int[] inorder, int instart, int length) throws Exception {
        if (length <= 0) {
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = preorder[prestart];
        int i = 0;
        // 在中序遍历中找到根节点
        for (; i < length; i++) {
            if (inorder[i+instart] == node.value) {
                break;
            }
        }
        // 在中序遍历中没有找到根节点，说明输入数据有问题
        if (i == length) {
            throw new Exception("invalid input");
        }
        node.left = constructFromPreAndInCore(preorder, prestart + 1, inorder, instart, i);
        node.right = constructFromPreAndInCore(preorder, prestart + 1 + i, inorder, instart + i + 1, length - i - 1);
        return node;
    }

    public static void main(String[] args) throws Exception {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTree binaryTree = BinaryTree.constructFromPreorderAndInorder(pre, in);
        System.out.println(1);
    }
}
