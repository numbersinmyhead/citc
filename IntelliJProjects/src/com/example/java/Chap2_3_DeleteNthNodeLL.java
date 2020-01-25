package com.example.java;

import commonLibs.LinkedList2_2B_ReturnKthToLastLLRecursion;
import sun.awt.image.ImageWatched;

// Since you are not given access to the head of the LL and you are required to delete an nth node, what you
// can do is go to the nth node and copy the next node of the nth node (i.e. n.next) into the Nth node.
// Once you copy n.next into n, then you would overwrite the old value and its reference will be gone. That
// is how you can get rid of the Nth node.
public class Chap2_3_DeleteNthNodeLL {

    public static void main (String[] str) {
        LinkedList2_2B_ReturnKthToLastLLRecursion head = new LinkedList2_2B_ReturnKthToLastLLRecursion(20);


        // we are using a mix of two functons to add them the LL. They both do the same thing. No difference.
        head.addElemToEndOfLL(30);
        head.addElemToEndOfLL(37);
        head.addElemToEndOfLL(42);
        head.addElemToEndOfLL(45);

        LinkedList2_2B_ReturnKthToLastLLRecursion t1 = head.addElemToEndOfLLAndReturnThePtrToIt(48);
        // we will use these later to delete them from LL

        head.addElemToEndOfLL(53);
        LinkedList2_2B_ReturnKthToLastLLRecursion t2 = head.addElemToEndOfLLAndReturnThePtrToIt(59);

        LinkedList2_2B_ReturnKthToLastLLRecursion t3 = head.addElemToEndOfLLAndReturnThePtrToIt(65);

        LinkedList2_2B_ReturnKthToLastLLRecursion t4 = head.addElemToEndOfLLAndReturnThePtrToIt(70);

        head.addElemToEndOfLL(78);
        head.printLLComplete(head);

        System.out.println("deleting " + t1.data);
        deleteNthElement(t1);
        head.printLLComplete(head);

        System.out.println("deleting " + t2.data);
        deleteNthElement(t2);
        head.printLLComplete(head);

        System.out.println("deleting " + t3.data);
        deleteNthElement(t3);
        head.printLLComplete(head);

        System.out.println("deleting " + t4.data);
        deleteNthElement(t4);
        head.printLLComplete(head);
    }



    public static void deleteNthElement(LinkedList2_2B_ReturnKthToLastLLRecursion temp) {

        if (temp == null || temp.next == null) {
            System.out.println("Unable to delete the node.");
            return;
        }

        LinkedList2_2B_ReturnKthToLastLLRecursion nextNode = temp.next;
        temp.data = nextNode.data;
        temp.next = nextNode.next;
    }
}
