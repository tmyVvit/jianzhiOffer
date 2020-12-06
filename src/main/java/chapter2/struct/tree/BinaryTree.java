package chapter2.struct.tree;

public class BinaryTree<T> {
    private BinaryTreeNode<T> root;
    static class BinaryTreeNode<T> {
        T value;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        BinaryTreeNode<T> parent;
    }

    // 面试题 7
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
        node.parent = null;
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
        if (node.left != null) {
            node.left.parent = node;
        }
        if (node.right != null) {
            node.right.parent = node;
        }
        return node;
    }

    // 面试题 8
    // 给定一个二叉树和其中的一个节点，找到中序遍历中该节点的下一个节点
    // 1. 该节点有右子节点，那么它的下一个节点就是右子节点的最左子节点
    // 2. 没有右子节点，并且是父节点的左子节点，那么下一个节点就是父节点
    // 3. 没有右子节点，并且是父节点的右子节点，那么就要沿着父节点向上遍历，直到找到一个是它父节点的左子节点的节点
    // 我们需要在节点中增加一个指向父节点的指针
    public BinaryTreeNode<T> getNext(BinaryTreeNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right != null) {
            BinaryTreeNode<T> rightnode = node.right;
            while (rightnode.left != null) {
                rightnode = rightnode.left;
            }
            return rightnode;
        } else {
            BinaryTreeNode<T> parent = node.parent;
            while (parent != null && parent.right == node) {
                parent = parent.parent;
            }
            return parent;
        }
    }

    public BinaryTreeNode<T> getNode(T node) {
        if (node == null) {
            return null;
        }
       return getNode(root, node);
    }

    private BinaryTreeNode<T> getNode(BinaryTreeNode<T> node, T value) {
        if (node == null) return null;
        if (node.value == value) {
            return node;
        }
        BinaryTreeNode<T> left = getNode(node.left, value);
        if (left != null && left.value == value) {
            return left;
        }
        return getNode(node.right, value);
    }

    public static void main(String[] args) throws Exception {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTree<Integer> binaryTree = BinaryTree.constructFromPreorderAndInorder(pre, in);
        BinaryTreeNode<Integer> node = binaryTree.getNext(binaryTree.getNode(4));
        System.out.println(node.value);
    }
}
