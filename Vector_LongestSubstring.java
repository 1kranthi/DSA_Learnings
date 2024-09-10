import java.util.*;
public class Vector_LongestSubstring {

    public int longestSubstring(String str){
        int maxLen=0;
        int start=-1;

        Vector<Integer> dict=new Vector<>(Collections.nCopies(256,-1));

        char[]arr=str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(dict.get(arr[i])>start){
                start = dict.get(arr[i]);
            }
            dict.set(arr[i],i);
            maxLen=Math.max(maxLen,i-start);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        Vector_LongestSubstring obj=new Vector_LongestSubstring();
        String str="pwwkew";
       System.out.println( obj.longestSubstring(str));
    }
}
