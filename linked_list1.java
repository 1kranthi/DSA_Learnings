public class linked_list1{

    class Node{
        int data;
        Node next;
    
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public  void append(int data){
        Node newnode=new Node(data);

        if(head==null){
            head=newnode;
            return;
        }
        Node last=head;
        while(last.next!=null){
            last=last.next;
        }
        last.next=newnode;
    }

    Node head;

    void printList(){
        Node currentNode = head;
        while (currentNode!=null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        linked_list1 list= new linked_list1();

        list.append(10);
        list.append(20);
        list.append(40);
        list.append(30);
        list.append(25);

        list.printList();
    }
} 