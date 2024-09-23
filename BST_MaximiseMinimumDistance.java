import java.util.Arrays;

public class BST_MaximiseMinimumDistance{

    boolean ifFeasible(int mid,int[] arr,int  n,int k){
        int pos=arr[0],element=1;

        for (int i=1;i<n;i++){
            if(arr[i]-pos>=mid){
                pos=arr[i];
                element++;
                if(element ==k){
                    return true;
                }
            }
        }
        return false;
    }

    int LargestMinDistance(int[] arr,int n,int k){
        Arrays.sort(arr);
        // Arrays.sort(arr+n);

        int result=-1;
        int left=1,right=arr[n-1];

        while(left<right){
            int mid=(left+right)/2;
            if(ifFeasible(mid,arr,n,k)){
                result=Math.max(mid,result);
                //searchh in mid right half
                left=mid+1;

            }else{
                //search in mid left half
                right=mid;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        BST_MaximiseMinimumDistance tree=new BST_MaximiseMinimumDistance();
       int arr[]={1,2,4,8,9};
       int n=5;
       int k=3;

       System.out.println(tree.LargestMinDistance(arr, n, k));
    }
}