class Node {
    int data;
    Node next;

   public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class linkked_list_reversenodes {

    Node head;

    // Method to insert elements into the linked list
    public void insertElements(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    // Method to print the linked list
    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

     Node reverseLNode(Node head,int k){
         if(head==null) return null;
        Node prev=null;
        Node current=head;
        Node next=null;

        int count=0;
        while(current !=null && count<k){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }

        if(next!=null){
            head.next=reverseLNode(next,k);
        }
        return prev;
    }

    public static void main(String[] args) {
        linkked_list_reversenodes list = new linkked_list_reversenodes();
        list.insertElements(10);
        list.insertElements(20);
        list.insertElements(30); // Adding more elements for demonstration
        list.insertElements(2);
        list.insertElements(3);

        list.printList(); // Expected output: 10 -> 20 -> 30 -> null

        // Node head=null;
        int k=2;
        list.head=list.reverseLNode(list.head,k);
        list.printList();
    }
}
