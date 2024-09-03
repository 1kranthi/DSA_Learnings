import java.util.Stack;

public class Stack_PrefixEvaluation {

    public void prefixEvaluation(String str){
        Stack<Integer> stack=new Stack<Integer>();

        char[] arr=str.toCharArray();

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>='0' && arr[i]<='9'){
                stack.push(arr[i]-'0');
            }else{
                int operand1=stack.peek();
                stack.pop();

                int operand2=stack.peek();
                stack.pop();

                switch(arr[i]){
                    case '+':
                         stack.push(operand1+operand2);
                         break;
                    case '-':
                         stack.push(operand1-operand2);
                         break;
                    case '*':
                        stack.push(operand1*operand2);
                        break;
                    case '/':
                        stack.push(operand1/operand2);
                        break;
                    case '^':
                        stack.push((int)Math.pow(operand1,operand2));
                }
            }
        }
       System.out.println(stack); 
    }
    public static void main(String[] args) {
        Stack_PrefixEvaluation list=new Stack_PrefixEvaluation();;
        String str="-+7*45+20";
        list.prefixEvaluation(str);
    }
}
