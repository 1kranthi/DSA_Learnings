class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class Binary_Search_PostorderToInorder {

    // Class-level variable to track the index in the postorder array (starting from the last element)
    int idx;

    int search(int[] inorder, int start, int end, int curr) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == curr) {
                return i;
            }
        }
        return -1;
    }

    TreeNode buildTree(int[] postorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // Get the current root node from postorder using idx (starting from the end)
        int curr = postorder[idx--];
        TreeNode node = new TreeNode(curr);

        // If the node has no children (leaf node), return it
        if (start == end) {
            return node;
        }

        // Find the position of the current root in the inorder array
        int pos = search(inorder, start, end, curr);

        // Recursively build the right and then the left subtree
        // Since postorder is left-right-root, we need to build the right subtree first
        node.right = buildTree(postorder, inorder, pos + 1, end);
        node.left = buildTree(postorder, inorder, start, pos - 1);

        return node;
    }

    void inorderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        Binary_Search_PostorderToInorder tree = new Binary_Search_PostorderToInorder();

        int inorder[] = { 1, 2, 4, 3, 5 };
        int postorder[] = { 1, 2, 5, 3, 4 };

        // Initialize the index to point to the last element of postorder array
        tree.idx = postorder.length - 1;

        // Build the tree
        TreeNode root = tree.buildTree(postorder, inorder, 0, inorder.length - 1);

        // Print the tree in inorder traversal
        tree.inorderPrint(root);
    }
}
