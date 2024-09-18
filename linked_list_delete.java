public class linked_list_delete{

    Node head;

    public void  inserElements(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }

        Node last=head;
        while(last.next!=null){
            last=last.next;
        }
        last.next=newNode;
    }

    //Delete a node by value
    public void deleteNode(int key){
        Node temp=head;
        Node prev=null;

        //if head node itself holds the key
        if(temp != null && temp.data==key){
            head=temp.next; //change head
            return;
        }

        //search for the key to be deleted
        while(temp != null && temp.data != key){
            prev=temp;
            temp=temp.next;
        }

        //if key was not present in the list 
        if (temp==null){
            return;
        }

        //unlink the node from the linked list

        prev.next = temp.next;
    }

    public void printList(){
        Node currentNode=head;

        while(currentNode != null){
            System.out.print(currentNode.data+"->");
            currentNode=currentNode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        linked_list_delete list=new linked_list_delete();

        list.inserElements(10);
        list.inserElements(3);
        list.inserElements(1);
        list.inserElements(-4);

        list.printList();

        list.deleteNode(3);
        list.printList();

    }
}