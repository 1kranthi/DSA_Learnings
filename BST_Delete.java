public class BST_Delete {

    TreeNode root;

    public void insert(int key){
        root=insertRec(root,key);
    }

    public TreeNode insertRec(TreeNode root,int key){
        if(root==null){
            root=new TreeNode(key);
            return root;
        }
        if(key<root.data){
            root.left=insertRec(root.left, key);
        }else if(key>root.data){
            root.right=insertRec(root.right, key);
        }
        return root;
    }

    public void inOrder(){
        inOrderRec(root);
    }
    private void inOrderRec(TreeNode root){
        if(root!=null){
            inOrderRec(root.left);
            System.out.print(root.data+" ");
            inOrderRec(root.right);
        }
    }

    //method to find inorderSec
    TreeNode inOrderSuc(TreeNode root){

        TreeNode curr=root;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }

    //Delete in BST 
    //here key is the node to be deleted
    TreeNode deleteInBST(TreeNode root,int key){
        if(root==null){
            return null;
        }
        if(key<root.data){
            root.left=deleteInBST(root.left, key);
        } 
         else if(key>root.data){
            root.right=deleteInBST(root.right, key);
        }else{
            if(root.left==null){
                TreeNode temp=root.right;
                return temp;
            }else if(root.right==null){
                TreeNode temp=root.left;
                return temp;
            }

            TreeNode temp=inOrderSuc(root.right);
            root.data=temp.data;
            root.right=deleteInBST(root.right,temp.data);
        }
        return root;
    }

    public static void main(String[] args) {
        BST_Delete tree=new BST_Delete();
        
        tree.insert(50);
        tree.insert(30);
        tree.insert(60);
        tree.insert(70);
        tree.insert(10);

        tree.inOrder();
        tree.deleteInBST(tree.root, 30);
        System.out.println();
        tree.inOrder();
    }
}
