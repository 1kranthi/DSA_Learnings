class Node{
    int data;
    Node next;

   public Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class linked_list_insert {

    Node head; //head of the list

    public void insetAtStart(int data){
        //inserting  node at the  beginning
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;

    }

    //inserting node at the end
    public void insertAtEnd(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node last=head;
        while (last.next!=null) {
            last=last.next;
        }
        last.next=newnode;
    }

    //to print the list
    public void printList(){
        Node currentNode=head;

        while(currentNode!=null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        linked_list_insert list=new linked_list_insert();
        list.insertAtEnd(5);
        list.insertAtEnd(10);
        list.insertAtEnd(15);
        list.insertAtEnd(0);

        list.printList();
        
        list.insetAtStart(90);

        list.printList();

    }
}
