package com.pavankumarpatruni;

public class LinkedList {

    private static class Node {
        private Node next;
        private int data;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    private void append(int data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = node;
        }
    }

    private void print() {
        if (head == null) {
            System.out.println("Empty");
            return;
        }

        System.out.print("{");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;

            if (current != null)
                System.out.print(", ");
        }
        System.out.println("}");
    }

    private void removeHead() {
        if (head != null) {
            System.out.print(head.data);
            head = head.next;
            if (head != null) {
                System.out.print(", ");
            }
        }
    }

    private void removeLast() {
        if (head != null) {
            Node node = head;
            while (node.next != null) {
                node = node.next;
                if (node.next != null) {
                    if (node.next.next == null) {
                        System.out.print(node.next.data + ", ");
                        node.next = null;
                    }
                } else {
                    System.out.print(node.data + ", ");
                    node = null;
                }
                if (node == null) {
                    head.next = null;
                    break;
                }
            }
        }
    }

    private void rearrange() {
        System.out.print("{");
        while (head != null) {
            removeHead();
            removeLast();
        }
        System.out.println("}");
    }

    public static void main(String args[]) {

        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(7);
        linkedList.append(9);
        linkedList.append(10);
        linkedList.append(8);
        linkedList.append(6);
        linkedList.append(4);
        linkedList.append(2);

        linkedList.print();

        linkedList.rearrange();
    }

}
