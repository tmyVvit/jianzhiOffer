package chapter2.struct.tree;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
    }

    // 假设中序遍历和前序遍历中都不含重复元素
    public static BinaryTree<Integer> constructFromPreorderAndInorder(int[] preorder, int[] inorder) throws Exception {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            throw new Exception("invalid input");
        }
        BinaryTreeNode<Integer> rootNode = constructFromPreAndInCore(preorder, 0, inorder, 0, preorder.length);
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
        binaryTree.root = rootNode;
        return binaryTree;
    }

    private static BinaryTreeNode<Integer> constructFromPreAndInCore(int[] preorder, int prestart, int[] inorder, int instart, int length) throws Exception {
        if (length <= 0) {
            return null;
        }
        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>();
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
        BinaryTree<Integer> binaryTree = BinaryTree.constructFromPreorderAndInorder(pre, in);
        System.out.println(1);
    }
}
