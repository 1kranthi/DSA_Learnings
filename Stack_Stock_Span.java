import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Vector;
import java.util.Stack;

public class Stack_Stock_Span {

    Vector<Integer> stockSpan(Vector<Integer> vector){

        Vector<Integer>ans=new Vector<>();
        Stack<SimpleEntry<Integer,Integer>> stack=new Stack<>();

        for(int price:vector){
            int days=1;
            while(!stack.isEmpty()&& stack.peek().getKey() <=price){
                days+=stack.peek().getValue();
                stack.pop();
            }
            stack.push(new SimpleEntry<>(price,days));
            ans.add(days);
    
        }

        return ans;
    }
    public static void main(String[] args) {

        Stack_Stock_Span obj=new Stack_Stock_Span();

        Vector<Integer> vector=new Vector<>(Arrays.asList(100,80,60,70,60,75,85));

        Vector<Integer> result=obj.stockSpan(vector);
        System.out.println(result);
    }
}
