package commonLibs;

public class LinkedList1_1B {
    public LinkedList1_1B next = null;
    public int data;

    public LinkedList1_1B(int data) {
        this.data = data;
    }

    public void appendToEnd(int data) {
        LinkedList1_1B end = new LinkedList1_1B(data);
        LinkedList1_1B n = this;

        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public static void printLL(LinkedList1_1B n) {
        while(n != null) {
            System.out.print(n.data + "  ");
            n = n.next;
        }
    }


}

