
public class BST_ConstructBST{

   TreeNode ConstructBST(int preorder[],int preorderIdx,int key,int min,int max,int n){
      TreeNode root=null;

      if(preorderIdx>=n){
        return null;
      }
      if(key>min && key<max){
        root=new TreeNode(key);
        preorderIdx=preorderIdx+1;

        if(preorderIdx<n){
           root.left= ConstructBST(preorder, preorderIdx, preorder[preorderIdx], min, key, n);
        }

        if(preorderIdx<n){
           root.right= ConstructBST(preorder, preorderIdx, preorder[preorderIdx], key, max, n);
        }
      }

      return root;
   }


   void printPreoder(TreeNode root){
     if(root==null){
        return;
     }

     System.out.print(root.data+" ");
     printPreoder(root.left);
     printPreoder(root.right);
   }
    
    public static void main(String[] args) {
        BST_ConstructBST tree=new BST_ConstructBST();
        int[] preorder={10,2,1,13,11};
        int n=preorder.length;
        int preorderIdx=0;

        TreeNode root=tree.ConstructBST(preorder, preorderIdx, preorder[0], Integer.MIN_VALUE, Integer.MAX_VALUE, n);
        tree.printPreoder(root);
        
    }
}