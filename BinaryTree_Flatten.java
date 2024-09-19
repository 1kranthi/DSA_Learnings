public class BinaryTree_Flatten {

    void flatten(TreeNode root){

        //if root,left,right is null  then thre is no need to flatten
        if(root==null ||(root.left==null && root.right==null)){
            return;
        }
        if(root.left==null){
            flatten(root.left);

            TreeNode temp=root.right;
            root.right=root.left;
            root.left=null;

            TreeNode t=root.right;
            while(t.right !=null){
                t=t.right;
            }

            //assign tailright to the temp
            t.right=temp;
         }

         flatten(root.right);
    }

    void inOrderPrint(TreeNode root){
        if(root==null){
            return;
        }

        inOrderPrint(root.left);
        System.out.print(root.data+" ");
        inOrderPrint(root.right);
    }
    public static void main(String[] args) {
        BinaryTree_Flatten tree=new BinaryTree_Flatten();
        TreeNode root=new TreeNode(1);
        root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        tree.flatten(root);
        tree.inOrderPrint(root);
    }
}
