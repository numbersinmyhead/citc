package com.example.java;

import commonLibs.LinkedList2_2B_ReturnKthToLastLLRecursion;
import sun.awt.image.ImageWatched;

public class Chap2_2B_returnKthToLastLLRecursion {
    public static void main(String[] string) {
        LinkedList2_2B_ReturnKthToLastLLRecursion head = new LinkedList2_2B_ReturnKthToLastLLRecursion(27);

        createLL(head); // pass the first element in the linked list
        int k = 5;

        Chap2_2B_returnKthToLastLLRecursion val = new Chap2_2B_returnKthToLastLLRecursion();
        int value = val.returnKthElemFromLL(head, k).data;

        System.out.println("3rd last element of the LL is " + value);
    }

    // This is the wrapper class. This class is going to help us in keeping track of the index. Since we need to
    // return the kth "node" (very important to keep in mind) we HAVE to use a wrapper class. In C++ we could have used
    // a simple pass by reference.
    public class IndexLL {
        int value;
    }

    public LinkedList2_2B_ReturnKthToLastLLRecursion returnKthElemFromLL(LinkedList2_2B_ReturnKthToLastLLRecursion head, int k) {
        IndexLL idx = new IndexLL();
        return this.returnKthElemFromLL(head, k, idx);
    }

    public LinkedList2_2B_ReturnKthToLastLLRecursion
        returnKthElemFromLL(LinkedList2_2B_ReturnKthToLastLLRecursion node, int k, IndexLL idx) {
        if (node == null) {
            idx.value = 0; // if you wanna start k from 0, then replace 0 with +1.
            return null;
        }

        LinkedList2_2B_ReturnKthToLastLLRecursion ret = returnKthElemFromLL(node.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k) {
            System.out.println("Found the element. Returning the node now. " + node.data);
            return node;
        }

        return ret; // this value is used to return to the parent whenever there is no match found. Keep in mind that
                    // the address ret stores is the same as the address of the node where we found our match (kth node).
                    // this is very important otherwise you may want to return 'node' here instead of 'ret' which is
                    // completely wrong.
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
}
