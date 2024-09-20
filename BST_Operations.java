
class TreeNode{
    int data;
    TreeNode left,right;

    public TreeNode(int item){
        data=item;
        left=right=null;
    }
}

public class BST_Operations{

    TreeNode root;

    //Insert a new node in the BST
    public void insert(int key){
        root=insertRec(root,key);
    }

    private TreeNode insertRec(TreeNode root,int key){
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

    //Search for a node in the BST
    public boolean search(int key){
        return searchRec(root,key);
    }

    private boolean searchRec(TreeNode root,int key){

        if(root==null) return false;
        if(root.data==key) return true;
        if(key<root.data) return searchRec(root.left, key);
        return searchRec(root.right, key);
    }

    //in-order traversal of the BST
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

    public static void main(String[] args) {
        BST_Operations tree=new BST_Operations();
        tree.insert(50);
        tree.insert(30);
        tree.insert(60);
        tree.insert(70);
        tree.insert(10);

        System.out.println("Inorder BST");
        tree.inOrder();

        System.out.println(tree.search(10));
        System.out.println(tree.search(95));
    }
}