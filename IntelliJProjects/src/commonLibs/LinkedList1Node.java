package commonLibs;

public class LinkedList1Node {

    public LinkedList1Node next = null;
    public int data;

    public LinkedList1Node (int d) {
        this.data = d; //same as 'data = d' btw.
    }

    public void appendToTail(int d) {
        LinkedList1Node end = new LinkedList1Node(d);
        LinkedList1Node n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    public void printLL(LinkedList1Node n) {

        while (n != null) {
            System.out.print(n.data + "  ");
            n = n.next;
        }
    }

/*    public LinkedList1Node next;
    public LinkedList1Node prev;
    public int data;

    public LinkedList1Node(int d, LinkedList1Node n, LinkedList1Node p) {
        data = d;
        setNext(n);
        setPrev(p);
    }

    public LinkedList1Node(int d) {
        data = d;
    }

    public LinkedList1Node() {}

    public void setNext(LinkedList1Node n) {
        next = n;
        if (n != null && n.prev != this) {
            
        }
    }

    public void setPrev(LinkedList1Node p) {
        prev = p;
    }*/
}
