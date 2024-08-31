class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class linked_list_cycle {
    Node head;

    public void insertElements(int data){
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

    public void makeCycle( Node head,int pos){
        Node temp=head;
        Node startNode=null;
        
        int count=1;
        while(temp.next!=null){
            if(count==pos){
                startNode=temp;
            }
            temp=temp.next;
            count++;
        }
        temp.next=startNode;
    }

    public void printList(){
        Node currentNode=head;
        while(currentNode!=null){
            System.out.print(currentNode.data+"=>");
            currentNode=currentNode.next;
        }
        System.out.println();
    }

    public boolean detectCycle(){

        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(Node head){
        Node slow=head;
        Node fast=head;

        do{
            slow=slow.next;
            fast=fast.next.next;
        }while(slow!=fast);

        fast=head;
        while (slow.next!=fast.next) {
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=null;
    }
    public static void main(String[] args) {
        linked_list_cycle list=new linked_list_cycle();
        list.insertElements(10);
        list.insertElements(14);
        list.insertElements(20);
        list.insertElements(12);
        list.insertElements(18);

        list.makeCycle(list.head,3);

        // list.printList();
        System.out.println(list.detectCycle());

        list.removeCycle(list.head);
        System.out.println(list.detectCycle());

        list.printList();


    }
}
