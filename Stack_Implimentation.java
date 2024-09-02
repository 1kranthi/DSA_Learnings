
public class Stack_Implimentation{
    int maxSize;
    int[] stackArray;
    int top;

    public Stack_Implimentation(int size){
        maxSize=size;
        stackArray=new int[maxSize];
        top=-1;
    }

    //pushing the elements into the stack
     public void push(int value){
        if(isFull()){  //checkinng if the stack is full
            System.out.println("stack is full");
        }else{
            stackArray[++top]=value; //++top because first move to next available position 
        }
     }

     //to  remove top element  from the stack
     public int pop(){   // the pop option must return something so it return type is int
        if(isEmpty()){
            System.out.println("stackArray is empty");
            return -1;
        }else{
            return stackArray[top--]; //top-- because we want to move top to the next element
        }
     }

     //to peek the top element in the array
     public int peek(){
        if(isEmpty()){
            System.out.println("stackArray is empty");
            return -1;
        }else{
            return stackArray[top];
        }
     }

     //to check if the stackarray is empty
     public boolean isEmpty(){
        return (top==-1);
     }

     //check if the stackArray is full
     public boolean isFull(){
        return (top==maxSize-1);
     }
    public static void main(String[] args) {
        Stack_Implimentation stack=new Stack_Implimentation(5);
        stack.push(2);
        stack.push(5);
        stack.push(-1);
        stack.push(0);

        for(int i=0;i<=stack.top;i++){
            System.out.print(stack.stackArray[i]+" ");
        }
        System.out.println();

        stack.pop();
        stack.pop();

        for(int i=0;i<=stack.top;i++){
            System.out.println(stack.stackArray[i]+" ");
        }

        stack.peek();


    }
}