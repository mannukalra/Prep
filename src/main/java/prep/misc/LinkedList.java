package prep.misc;

public class LinkedList {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    Node head;
    LinkedList(int data){
        this.head = new Node(data);
    }

    void insertStart(int data){
        if(head == null){
            this.head = new Node(data);
        }else{
            Node temp = head;
            head = new Node(data);
            head.next = temp;
        }
    }

    void insertLast(int data){
        if(head == null){
            this.head = new Node(data);
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next= new Node(data);
        }
    }
    // 7 8 5 9 22
    void insertAt(int data, int pos){
        if(head == null){
            throw new IllegalStateException("Invalid position");
        }
        Node prev = null;
        Node curr = head;
        int index = 1;

        while(index < pos){
            prev = curr;
            curr = curr.next;
            index++;
        }

        if(prev != null){
            prev.next = new Node(data);
            prev.next.next = curr;
        }else{
            head = new Node(data);
            head.next = curr;
        }

    }

    void delete(int val){
        if(head == null)
            throw new IllegalStateException("Empty list");
        Node prev = null;
        Node target = head;
        while(target != null){
            if(target.data == val){
                if(prev == null)
                    head = target.next;
                else
                    prev.next = target.next;
                break;
            }
            prev = target;
            target = target.next;
        }

        if(target == null){
            throw new IllegalStateException("Missing element");
        }
    }

    void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

//    1 2 3 4    7 8 5 9
    void revRec(Node curr, Node prev){
        if(curr == null){
            head = prev;
            return;
        }

        Node next = curr.next;
        curr.next = prev;
        prev = curr;
        revRec(next, prev);
    }

    void printRec(Node node){
        if(node == null){
            System.out.println();
            return;
        }
        System.out.print(node.data+" ");
        printRec(node.next);
    }

    void print(){
        Node curr = head;
        while (true){
            System.out.print(curr.data+" ");
            curr = curr.next;
            if(curr == null)
                break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(8);
        list.insertAt(5, 2);
        list.insertStart(7);
        list.insertLast(9);
        list.insertAt(22, 2);
        list.print();

//        list.delete(7);
//        list.print();
//        list.delete(7);
        list.reverse();
        list.printRec(list.head);

        list.revRec(list.head, null);
        list.print();
        list.insertAt(6, 6);
        list.insertAt(4, 1);
        list.print();
    }
}
