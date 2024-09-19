public class BinaryTree_ShortestDistance{

    @SuppressWarnings("unused")
    TreeNode LCA(TreeNode root  ,int n1,int n2){
        if(root==null){
            return null;
        }

        if(root.data==n1 || root.data==n2){
            return root;
        }
        TreeNode left=LCA(root.left, n1, n2);
        TreeNode right=LCA(root.right, n1, n2);

        if(left !=null || right != null){
            return root;
        }

        if(left==null || right==null){
                return null;
        }

        if(left != null){
            return LCA(root.left, n1, n2);
        }
        return LCA(root.right, n1, n2);
    }

    int findDist(TreeNode root,int k,int dist){
        if(root==null){
            return -1;
        }
        if(root.data==k){
            return dist;
        }

        int left=   findDist(root.left, k, dist+1);
        if(left != -1){
            return left;
        }

        return findDist(root.right, k, dist+1);
    }
    int distance(TreeNode root,int n1,int n2){
        TreeNode lca=LCA(root, n1, n2);

        int d1=findDist(lca,n1,0);
        int d2=findDist(lca,n2,0);

        return d1+d2;
    }
    public static void main(String[] args) {
        BinaryTree_ShortestDistance tree=new BinaryTree_ShortestDistance();
        TreeNode root=new TreeNode(1);
        root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(4);
        root.left.left=new TreeNode(5);
        root.right.left=new TreeNode(6);

        System.out.println(tree.distance(root, 4, 5));

    }
}