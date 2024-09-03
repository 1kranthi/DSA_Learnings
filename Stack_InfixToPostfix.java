import java.util.Stack;

public class Stack_InfixToPostfix {

    int precedence(Character c){
        if(c=='^'){
            return 3;
        }else if(c=='*' || c=='/'){
            return 2;
        }else if(c=='+' || c=='-'){
            return 1;
        }else{
            return -1;
        }
    }

    public String infixToPostfix(String str){

        Stack<Character> stack=new Stack<>();

        char[] arr=str.toCharArray();

        String result="";
        //we transvese from left to right
        for(int i=0;i<arr.length;i++){
            if((arr[i]>='a' && arr[i]<='z') || (arr[i]>='A' && arr[i]<='Z')){
                result+=arr[i];
            }else if(arr[i]=='('){
                stack.push(arr[i]);
            }else if(arr[i]==')'){
                while (!stack.isEmpty() && stack.peek()!='(') {
                    result += stack.peek();
                    stack.pop();
                }
                if(!stack.isEmpty()){  // if char is '(' then if also need to be pop
                   stack.pop();
                }
            }else{
                while(!stack.isEmpty() && precedence(stack.peek())>precedence(arr[i])){
                    result+= stack.peek();
                    stack.pop();
                }
                stack.push(arr[i]);

            }
        }
        return result;
    }
    
    

    public static void main(String[] args) {
        Stack_InfixToPostfix stack=new Stack_InfixToPostfix();

        String str="(a-b/c)*(a/k-l)";
        System.out.println(stack.infixToPostfix(str));
    }
}
