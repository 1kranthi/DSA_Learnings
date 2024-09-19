public class BinaryTree_NodeAtDistanceK {

    //if we want to find the subtree of  the target node
    void pintSubtreeNode(TreeNode root, int k){
        if(root==null || k<0){
            return;
        }

        if(k == 0){
            System.out.print(root.data+" ");
            return;
        }
        //decrese by 1 for  each step
        pintSubtreeNode(root.left, k-1);
        pintSubtreeNode(root.right, k-1);
    }

    //if we found target and return the distance with the node ansistors
    int printNodesAtK(TreeNode root,TreeNode target,int k){
        if(root==null){
            return -1;
        }

        if(root ==target){
            pintSubtreeNode(root,k);
            return 0;
        }

        int dl=printNodesAtK(root.left, target, k);
        if(dl != -1){
            if(dl+1==k){
                System.out.print(root.data+" ");

            }else{
                printNodesAtK(root.right, target, k-dl-2);
            }
            return 1+dl;
        }

        int dr=printNodesAtK(root.right, target, k);
        if(dr != -1){
            if(dr+1==k){
                System.out.print(root.data+" ");

            }else{
                printNodesAtK(root.left, target, k-dr-2);
            }
            return 1+dr;
        }
        return -1;
    }
    public static void main(String[] args) {
        BinaryTree_NodeAtDistanceK tree=new BinaryTree_NodeAtDistanceK();
        TreeNode root=new TreeNode(1);
        root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        tree.printNodesAtK(root, root.left, 1);
    }
}
