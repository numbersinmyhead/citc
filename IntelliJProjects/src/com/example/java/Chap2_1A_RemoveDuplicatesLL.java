package com.example.java;

import commonLibs.LinkedList1Node;
import sun.awt.image.ImageWatched;

import java.util.HashSet;

public class Chap2_1A_RemoveDuplicatesLL {

    public static void main(String[] string) {
        LinkedList1Node node = new LinkedList1Node(70); //head
        LinkedList1Node head = node;
        node.appendToTail(60);
        node.appendToTail(63);
        node.appendToTail(64);
        node.appendToTail(29);
        node.appendToTail(65);
        node.appendToTail(61);
        node.appendToTail(20);
        node.appendToTail(63);
        node.appendToTail(34);
        node.appendToTail(29);

        System.out.println("BEFORE:");
        node.printLL(head);
        deleteDuplicates(head);
        System.out.println("\nAFTER:");
        node.printLL(head);

    }


    public static void deleteDuplicates(LinkedList1Node n) {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedList1Node previous =null;

        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next; //here when we find a duplicate entry in the hash table, then we use
                                        // previous.next to skip the current object (i.e. duplicated entry) by pointing
                                        // previous.next to n.next. We know that n.next is the next entry after the
                                        //duplicated entry. This is how we get rid of the duplicated entry in the LL
            }
            else {
                set.add(n.data);
                previous = n; //previous would store a reference to the current n object. We later use previous' next object
                                // i.e. previous.next to skip the duplicate element which we find in our hashtable.
            }
            n = n.next;
        }
    }
}

