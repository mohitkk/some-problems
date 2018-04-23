package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    Node head;

    public static void main(final String args[]) {
        final List<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);
        // input.add(7);
        final LinkedList ll = new LinkedList();
        for (final Integer eachInput : input) {
            final Node node = new Node(eachInput);
            ll.addNodeAtFront(node);
        }
        System.out.println("--");
        ll.printList();
        // System.out.println("--2");
        // ll2.printList();
        ll.head = reverseLinkedList(ll.head);
        System.out.println("--2");
        ll.printList();

        System.out.println("--3");
        ll.head = reverseInKGroups(ll.head, 5);
        ll.printList();
        System.out.println("--4");
        ll.head = swapEveryTwo(ll.head);
        System.out.println(ll.head.data);
        // ll.printList();
    }

    public static Node swapEveryTwo(Node node) {
        int c = 0;
        Node prev = null;
        Node head = null;
        Node prevEnd = null;
        Node start = node;
        Node current = node;
        while (current != null) {
            if (c < 2) {
                Node temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
                c++;
            } else {
                System.out.println(current.data);
                System.out.println(prev.data);
                System.out.println(start.data);
                System.out.println(prevEnd == null ? "null" : prevEnd.data);
                System.out.println("--");
                c = 0;
                if (head == null) {
                    head = prev;
                    // System.out.println("??");
                    // System.out.println(head.data);
                    // System.out.println(head.next.data);
                    // System.out.println("??");
                    prevEnd = start;
                } else {
                    prevEnd.next = prev;
                    prevEnd = prev;
                }
                prevEnd.next = current;
                start = current;
            }
        }
        return head;
    }

    public static Node reverseInKGroups(Node current, int k) {
        if (k <= 1) {
            return current;
        }
        Node head = null;
        Node prevEnd = null;
        Node start = current;

        while (current != null) {
            int count = 0;
            while (count < k && current != null) {
                current = current.next;
                count++;
            }
            if (current == null && count < k) {
                break;
            } else {
                Pair reverse = reverse(start, current);
                if (head == null) {
                    head = reverse.start;
                    reverse.end.next = current;
                    prevEnd = reverse.end;
                    start = current;
                } else {
                    prevEnd.next = reverse.start;
                    reverse.end.next = current;
                    prevEnd = reverse.end;
                    start = current;
                }
            }
        }
        return head;
    }

    private static Pair reverse(Node current, Node breakNode) {
        Node end = current;
        Node start = null;
        Node temp;
        while (current != breakNode) {
            temp = current.next;
            current.next = start;
            start = current;
            current = temp;
        }
        return new Pair(start, end);
    }

    private static class Pair {
        Node start;
        Node end;

        public Pair(Node start, Node end) {
            this.start = start;
            this.end = end;
        }

    }

    public static Node reverseLinkedList(final Node hh) {
        Node prev = null;
        Node current = hh;
        Node temp = current.next;
        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private void printList() {
        Node current = this.head;
        System.out.println();
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

    }

    public void addNodeAtFront(final Node n) {
        if (this.head == null) {
            this.head = n;
            return;
        }
        n.next = this.head;
        this.head = n;
        return;
    }

    public void addNodeAtLast(final Node n) {
        if (this.head == null) {
            this.head = n;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = n;
        return;
    }

    public void addNodeAtLastRecursive(Node he, final Node n) {
        if (he == null) {
            he = n;
            return;
        }
        addNodeAtLastRecursive(head.next, n);
    }

    private static class Node<T> {
        T data;
        Node next;

        Node(final T data) {
            this.data = data;
            this.next = null;
        }
    }

}
