public class Binary_Search_Preorder {
    TreeNode root;

    public void preOrder(TreeNode node){
        if(node==null){
            return;
        }

        System.out.print(node.data+" ");

        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(TreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.err.print(node.data+" ");
        inOrder(node.right);
    }

    public void postOrder(TreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    public static void main(String[] args) {
        Binary_Search_Preorder tree=new Binary_Search_Preorder();
        tree.root=new TreeNode(2);
        tree.root.left=new TreeNode(3);
        tree.root.right=new TreeNode(4);
        tree.root.left.left=new TreeNode(5);
        tree.root.left.right=new TreeNode(6);

        System.out.print("PreOder Travesal: ");
        tree.preOrder(tree.root);
        System.out.println();
        System.out.print("Inorder Treversal: ");
        tree.inOrder(tree.root);
        System.out.println();
        System.out.print("PostOrder Traversal: ");
        tree.postOrder(tree.root);
    }
}
