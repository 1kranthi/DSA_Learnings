import java.util.Stack;
public class Stack_LargestRectangle_Histogram{

    public int[] prevSmaller(int arr[]){
        int ps[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                ps[i]=-1;
            }else{
                ps[i]=stack.peek();
            }
            stack.push(i);
        }
        return ps;
    }

    public int[] nextSmaller(int arr[]){
        int ns[]=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                ns[i]=arr.length;
            }else{
                ns[i]=stack.peek();
            }
            stack.push(i);
        }
        return ns;
    }

    public void maxArea(int arr[]){
        int maxAns=0;
        int ps[]=prevSmaller(arr);
        int ns[]=nextSmaller(arr);

        for(int i=0;i<arr.length;i++){
            int curr=(ns[i]-ps[i]-1)*arr[i];
            maxAns=Math.max(maxAns,curr);
        }
        System.out.println(maxAns);
    }
   
    public static void main(String[] args) {

        int arr[]={1,2,4,5,3,6,3,2,-1,9,2};

        Stack_LargestRectangle_Histogram obj=new Stack_LargestRectangle_Histogram();
        obj.maxArea(arr);

    }
}