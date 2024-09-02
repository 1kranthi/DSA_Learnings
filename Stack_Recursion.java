import java.util.Stack;

public class Stack_Recursion{

    public void insertAtBottom(Stack<Integer> st, int element){

        if(st.empty()){
            st.push(element);
            return;
        }
        int topEle=st.peek();
        st.pop();
        insertAtBottom(st, element);

        st.push(topEle);
    }

    public void reverse(Stack<Integer> st){
        if(st.empty()){
            return;
        }
        int element=st.peek();
        st.pop();
        reverse(st);
        insertAtBottom(st,element);
    }
    public static void main(String[] args) {
        Stack_Recursion stack=new Stack_Recursion();

        Stack<Integer> list=new Stack<>();
        list.push(10);
        list.push(3);
        list.push(5);
        list.push(8);
        stack.reverse(list);

        while(!list.empty()){
            System.out.print(list.peek()+" ");
            list.pop();
        }
        

    }
}