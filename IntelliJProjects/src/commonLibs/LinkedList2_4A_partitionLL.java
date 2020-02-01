package commonLibs;


public class LinkedList2_4A_partitionLL {
    public int data;
    public LinkedList2_4A_partitionLL next;

    public LinkedList2_4A_partitionLL(int data) {
        this.data = data;
        this.next = null;
    }

    public void insertElem(int d) {
        LinkedList2_4A_partitionLL newNode = new LinkedList2_4A_partitionLL(d);
        LinkedList2_4A_partitionLL temp = this;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void printElem() {
        LinkedList2_4A_partitionLL node = this;

        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
}