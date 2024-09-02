import java.util.Stack;
public class Stack_ReverseSentence {

    public void reverse(String str){

        Stack<String> list=new Stack<>();

       String[] store=str.split(" ");
       for(int i=0; i<store.length;i++){
        // System.out.println(store[i]);
        list.push(store[i]);
       }

       while(!list.empty()){
        System.out.print(list.pop()+" ");
       }


    }

    public static void main(String[] args) {
        Stack_ReverseSentence stack=new Stack_ReverseSentence();
        String str="Hey! how are you doing?";
        stack.reverse(str);

    }
    
}
