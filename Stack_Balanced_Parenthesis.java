import java.util.Stack;

public class Stack_Balanced_Parenthesis{

    boolean isValid(String str){

        char[] arr=str.toCharArray();

        Stack<Character> stack=new Stack<>();

        boolean ans=true;

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='{' || arr[i]=='[' || arr[i]=='('){
                stack.push(arr[i]);
            }else if(arr[i]=='}'){
                if(stack.peek()=='{' && !stack.isEmpty()){
                    stack.pop();
                }else{
                    ans=false;
                    break;
                }  
            }else if(arr[i]==']'){
                if(stack.peek()=='[' && !stack.isEmpty()){
                    stack.pop();
                }else{
                    ans=false;
                    break;
                }  
            }else if(arr[i]==')'){
                if(stack.peek()=='(' && !stack.isEmpty()){
                    stack.pop();
                }else{
                    ans=false;
                    break;
                }  
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return ans;
    }
    public static void main(String[] args) {
        Stack_Balanced_Parenthesis obj=new Stack_Balanced_Parenthesis();

        String str="{[()]}";

        if(obj.isValid(str)){
            System.out.println("Valid String");
        }else{
            System.out.println("Not Valid String");
        }
    }
}