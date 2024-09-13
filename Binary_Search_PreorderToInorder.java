class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class Binary_Search_PreorderToInorder {

    // Class-level variable to track the index in the preorder array
    int idx = 0;

    int search(int[] inorder, int start, int end, int curr) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == curr) {
                return i;
            }
        }
        return -1;
    }

    TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // Get the current root node from preorder using idx
        int curr = preorder[idx++];
        TreeNode node = new TreeNode(curr);

        // If the node has no children (leaf node), return it
        if (start == end) {
            return node;
        }

        // Find the position of the current root in the inorder array
        int pos = search(inorder, start, end, curr);

        // Recursively build the left and right subtrees
        node.left = buildTree(preorder, inorder, start, pos - 1);
        node.right = buildTree(preorder, inorder, pos + 1, end);

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
        Binary_Search_PreorderToInorder tree = new Binary_Search_PreorderToInorder();

        int inorder[] = { 1, 2, 4, 3, 5 };
        int preorder[] = { 4, 2, 1, 5, 3 };

        // Build the tree
        TreeNode root = tree.buildTree(preorder, inorder, 0, inorder.length - 1);

        // Print the tree in inorder traversal
        tree.inorderPrint(root);
    }
}
