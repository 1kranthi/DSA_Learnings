public class BST_RecoverBst {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);  // Initialize prev element to minimum possible value

    public void recoverTree(TreeNode root) {
        // Perform the in-order traversal and find two elements
        traverse(root);
        // Swap the values of the two nodes to fix the tree
        int temp = firstElement.data;
        firstElement.data = secondElement.data;
        secondElement.data = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        // Traverse the left subtree
        traverse(root.left);

        // Detect the first and second out-of-order nodes
        if (firstElement == null && prevElement.data > root.data) {
            firstElement = prevElement;
        }

        if (firstElement != null && prevElement.data > root.data) {
            secondElement = root;
        }

        // Update prevElement to the current node after visiting it
        prevElement = root;

        // Traverse the right subtree
        traverse(root.right);
    }

    public static void main(String[] args) {
        BST_RecoverBst tree = new BST_RecoverBst();

        // Constructing an invalid BST (5 and 15 are swapped)
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);  // This should be 3
        root.left.right = new TreeNode(8);
        
        System.out.println("Before Recovery:");
        tree.inOrder(root);

        // Recover the BST
        tree.recoverTree(root);

        System.out.println("\nAfter Recovery:");
        tree.inOrder(root);
    }

    // In-order traversal to print the tree
    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}
