package com.dsa.linkedlist;

public class LinkedList {

    private Node head;

    public LinkedList() {

    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public static void main(String a[]) {
        LinkedList linkedList = new LinkedList();
        linkedList.appendData(5);
        linkedList.appendData(6);
        linkedList.appendData(7);
        linkedList.appendData(8);
        linkedList.appendData(9);
        System.out.println(linkedList.toString());
    }

    public LinkedList appendData(int data) {
        if (head == null) {
            head = new Node(data);
            return this;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        Node newNode = new Node(data);
        current.setNext(newNode);
        return this;
    }

    public Node getHead() {
        return head;
    }

    public LinkedList setHead(Node head){
        this.head = head;
        return this;
    }

    int size() {
        Node node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = head;
        while (current.getNext() != null) {
            builder.append(current.getData());
            builder.append("->");
            current = current.getNext();
        }
        builder.append(current.getData());
        return builder.toString();
    }
}
