package commonLibs;

public class LinkedList2_2B_ReturnKthToLastLLRecursion {

    public int data;
    public LinkedList2_2B_ReturnKthToLastLLRecursion next = null;

    public LinkedList2_2B_ReturnKthToLastLLRecursion(int data) {
        this.data = data;
    }

    public void addElemToEndOfLL(int data) {
        LinkedList2_2B_ReturnKthToLastLLRecursion node = new LinkedList2_2B_ReturnKthToLastLLRecursion(data);
        LinkedList2_2B_ReturnKthToLastLLRecursion temp = this;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
    }

    public void printLLComplete(LinkedList2_2B_ReturnKthToLastLLRecursion head) {
        System.out.println("START");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("\nEND\n");
    }

}
