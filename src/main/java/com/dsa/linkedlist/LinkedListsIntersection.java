package com.dsa.linkedlist;

/*
Problem Description:
Given 2 LLs, determine if they intersect. Return the intersecting node.
LLs can be of different length.
 */

/*
Input:
3->1->5->9->
            7->2->1
      4->6->

Output:
Intersecting Vertex is 7


Input 1 LinkedList : 3->1->5->9->7->2->1
Input 2 LinkedList : 4->6->7->2->1
Intersecting Vertex is : 7

 */

/*
Solution:
a) Since LLs are of different length, we need to find the length of them and find difference between them, say k.
b) Skip k elements in longer LL.
c) Then iterate both LL by 1 step each and compare the node's reference.
d) If references are same, then return the element
e) It takes o(n) time.
 */


public class LinkedListsIntersection {

    public static void main(String a[]) {
        LinkedListsIntersection obj = new LinkedListsIntersection();

        LinkedList input_1 = new LinkedList();
        input_1.appendData(3);
        input_1.appendData(1);
        input_1.appendData(5);
        input_1.appendData(9);

        LinkedList input_2 = new LinkedList();
        input_2.appendData(4);
        input_2.appendData(6);

        // common nodes
        Node node_1 = new Node(7);
        Node node_2 = new Node(2);
        Node node_3 = new Node(1);

        node_2.setNext(node_3);
        node_1.setNext(node_2);

        input_1.appendData(node_1);
        input_2.appendData(node_1);

        System.out.println("Input 1 LinkedList : " + input_1.toString());
        System.out.println("Input 2 LinkedList : " + input_2.toString());
        System.out.println("Intersecting Vertex is : " + obj.intersectingNode(input_1, input_2).getData());

    }

    private Node intersectingNode(LinkedList input_1, LinkedList input_2) {
        int size_1 = input_1.size();
        int size_2 = input_2.size();
        Node shorter = (size_1 < size_2) ? input_1.getHead() : input_2.getHead();
        Node longer = (size_1 > size_2) ? input_1.getHead() : input_2.getHead();
        int delta = (size_1 > size_2) ? size_1 - size_2 : size_2 - size_1;
        longer = getKthNode(longer, delta);

        while (shorter != longer) {
            shorter = shorter.getNext();
            longer = longer.getNext();
        }
        // return either shorter or longer
        return longer;
    }

    private Node getKthNode(Node node, int k) {
        while (node != null && k > 0) {
            node = node.getNext();
            k--;
        }
        return node;
    }
}
