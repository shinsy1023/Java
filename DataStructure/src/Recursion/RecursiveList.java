package Recursion;

/**
 * Created by shinsy1023 on 2016. 11. 7..
 */
public class RecursiveList {
    private Node header;
    private Node trailer;
    private int size;

    private class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    RecursiveList() {
        header = new Node(99);
        trailer = new Node(99);
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    public void addFirst(int size) {
        Node tmp = new Node(size * 5);
        tmp.next = header;
        header.prev = tmp;
        header = tmp;
        this.size++;
    }

    public void recursiveInsert(int size) {
        if (size >= 0){
            addFirst(size);
            recursiveInsert(size - 1);
        }
    }

    public void recursiveDelete(int size) {
        if (size != 0)
            recursiveDelete(size - 1);
        removeLast();
    }

    public void removeLast(){
        Node tmp = trailer.prev.prev;
        trailer.prev = tmp;
        tmp.next = trailer;
        this.size--;
    }

    public void printList() {
        for (Node temp = header; temp.next != trailer; temp = temp.next){
            System.out.printf("%d -> ", temp.data);
        }
        System.out.printf("\n");
    }
}