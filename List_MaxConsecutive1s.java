public class List_MaxConsecutive1s {

    public int maxConsecutive(int []arr){
        int count=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                count++;
            }else{
                count=0;
            }
            max=Math.max(count,max);
        }

        return max;
    } 
    public static void main(String[] args) {
        List_MaxConsecutive1s obj=new List_MaxConsecutive1s();
        int arr[]={1,0,1,1,1,0,0,1,1,1,1};
        System.out.println(obj.maxConsecutive(arr));
    }
}
