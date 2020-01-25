package com.example.java;

// we use the iterative approach here. We use two pointers - p1 and p2.
// p2 points at the beginning of the LL
// p1 is k node deep into the list.
// once p1 and p2 are pointing where they are supposed to, we move p1 and p2 until p1 hits the end of list.
// p2 is automatically now the kth node from the last LL node.

import commonLibs.LinkedList2_2B_ReturnKthToLastLLRecursion;
import sun.awt.image.ImageWatched;

public class Chap2_2B_returnKthToLastLLIterative {

    public static void main(String[] string) {
        LinkedList2_2B_ReturnKthToLastLLRecursion head = new LinkedList2_2B_ReturnKthToLastLLRecursion(27);
        createLL(head);
        System.out.println("k =5, data:" + printKthLastNode(head, 5).data);

        System.out.println("k =1, data:" + printKthLastNode(head, 1).data);

        System.out.println("k =11, data:" + printKthLastNode(head, 11).data);
    }

    public static void createLL(LinkedList2_2B_ReturnKthToLastLLRecursion head ) {
        head.addElemToEndOfLL(30);
        head.addElemToEndOfLL(37);
        head.addElemToEndOfLL(42);
        head.addElemToEndOfLL(45);
        head.addElemToEndOfLL(48);
        head.addElemToEndOfLL(53);
        head.addElemToEndOfLL(59);
        head.addElemToEndOfLL(65);
        head.addElemToEndOfLL(70);
        head.addElemToEndOfLL(78);
        head.printLLComplete(head);
    }

    public static LinkedList2_2B_ReturnKthToLastLLRecursion printKthLastNode(LinkedList2_2B_ReturnKthToLastLLRecursion head, int k) {

        LinkedList2_2B_ReturnKthToLastLLRecursion p1 = head;
        LinkedList2_2B_ReturnKthToLastLLRecursion p2 = head;

        // move p2 kth node deep into the LL
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        //start moving p1 and p2, until p1 hits the end of the list. p1 is ahead of p2, so p1 would hit the end first.
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
