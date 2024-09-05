import java.util.ArrayDeque;
import java.util.Deque;

public class Deque_SlidingWindow{

    public static void slidingWindow(int arr[],  int k){
        //breute force approach
        // int n=arr.length;
        // int max;
        // for(int i=0;i<=n-k;i++){
        //     max=arr[i];
        //     for(int j=0;j<k;j++){
        //         if(arr[i+j]>max){
        //             max=arr[i+j];
        //         }
        //     }
        //     System.out.print(max+" ");
        // }


        Deque<Integer> deque=new ArrayDeque<Integer>();
        //for first k iteration of elements
        for( int i=0;i<k;++i){

            //for every element the previous element is useless so remove from the deque
            while(!deque.isEmpty() && arr[i] < arr[deque.peekLast()]){
                //remove from the last
                deque.removeLast();
            }
            //add from the last
            deque.addLast(i);
        }

        //next process the rest of elements from arr[k] to arr[n-1]
        int n=arr.length;
        for(int i=1;i<n;i++){
            //the element at the front of the window is largest of previous window so i print it
            System.out.print(arr[deque.peek()]+" ");

            //remove the element that are out of the window
            while((!deque.isEmpty()) && deque.peek()<=i-k){
                deque.removeFirst();
            }

            //remove all the elements smaller than the current element to be added

            while((!deque.isEmpty()) && arr[i]>=arr[deque.peekLast()]){
                deque.removeLast();
            }
            //add current element at the last of deque
            deque.addLast(i);
        }
        System.out.print(arr[deque.peek()]);

    }
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,2,6,7,9,10};
        int k=3;
        // slidingWindow(arr, k);
        slidingWindow(arr, k);

    }
}