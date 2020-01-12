package com.example.java;

import commonLibs.LinkedList1_1B;
import sun.awt.image.ImageWatched;

public class Chap2_1B_RemoveDuplicates {

    public static void main(String[] str) {
        LinkedList1_1B n = new LinkedList1_1B(40);
        LinkedList1_1B head = n;

        n.appendToEnd(20);
        n.appendToEnd(25);
        n.appendToEnd(10);
        n.appendToEnd(35);
        n.appendToEnd(40);
        n.appendToEnd(50);
        n.appendToEnd(20);
        n.appendToEnd(90);
        n.appendToEnd(55);
        n.appendToEnd(30);
        n.appendToEnd(15);
        n.appendToEnd(5);

        System.out.println("ORIGINAL");
        LinkedList1_1B.printLL(head);

        deleteDuplicate(head);

        System.out.println("\nAFTER");
        LinkedList1_1B.printLL(head);
    }

    public static void deleteDuplicate (LinkedList1_1B n) {
        LinkedList1_1B current = n;
        LinkedList1_1B runner;

        while (current != null) {
            runner = current;

            while(runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
