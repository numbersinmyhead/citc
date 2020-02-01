package com.example.java;


import commonLibs.LinkedList2_4A_partitionLL;

// I am unable to understand the problem here, so i give up. Going wth the leetcode problem instead.
/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

        You should preserve the original relative order of the nodes in each of the two partitions.

        Example:

        Input: head = 1->4->3->2->5->2, x = 3
        Output: 1->2->2->4->3->5
*/
public class Chap2_4_PartitionLL {

    public static void main(String[] string) {

        LinkedList2_4A_partitionLL head = new LinkedList2_4A_partitionLL(1);
        LinkedList2_4A_partitionLL head_temp = head;
        head.insertElem(4);
        head.insertElem(3);
        head.insertElem(2);
        head.insertElem(5);
        head.insertElem(2);

        head.printElem();
        int x = 3;
        partitionLL(head, x);

        head_temp.printElem();

    }

    // we will have a before list and an after list. Before list will contain elements that are less than x. After
    // list will contain elements are greator than or equal to x.

    public static void partitionLL(LinkedList2_4A_partitionLL node, int x) {
        //initialization of before list is important so we have a starting point of the list
        LinkedList2_4A_partitionLL before = new LinkedList2_4A_partitionLL(0);
        LinkedList2_4A_partitionLL before_head = before; //temporary variable to hold reference to the head of 'before'
        // we aren't using before_head in this example, but if we wanted to return the LL from this function, we could
        //have used before_head.next to return from this function in the end.

        LinkedList2_4A_partitionLL after = new LinkedList2_4A_partitionLL(0);
        LinkedList2_4A_partitionLL after_head = after; //temporary variable to store the reference of the head of 'after'

        while(node != null) {
            if(node.data < x) {
                before.next = node; // point the 'node of interest' to the next node of our before list. This is how
                // we are creating our LL. We first point the next of before to the Node of Interest and then we move
                //forward the before pointer to the next. We are creating our chain of reference aka the list by doing
                //this. It might be confusing but think of how to create a simple LL if it doesn't make sense.
                before = before.next; //move the pointer forward, just like how you move forward in a regular LL
            }
            else
            {
                after.next = node;
                after = after.next;
            }

            node = node.next;
        }
        after.next = null;

        before.next = after_head.next;
    }

}


