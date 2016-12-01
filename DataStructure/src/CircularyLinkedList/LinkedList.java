package CircularyLinkedList;

/**
 * Created by shinsy1023 on 2016. 9. 26..
 */

public class LinkedList {
    private Node head; // 리스트의 헤드를 가리키는 포인터	point to head of the list
    private int count = 0; // 리스트의 노드갯수	the number of nodes in the list

    private class Node {	// 내부클래스 Node	inner class Node
        int data;
        Node next;

        Node(int input) {
            data = input;
            next = null;
        }
    }

    public void insert(int input) {		// 맨앞에 input 데이터를 가지는 노드 추가	insert a node at the first of the list
        Node temp = new Node(input);
        temp.next = this.head;
        this.head = temp;
        this.count++;
    }
    public void insert(int position, int input) {    // position 위치에 input 데이터를 가지는 노드 추가	insert a node at the given position
        if (position > count || position < 0) {
            System.out.println("position value - out of range.");
            return;
        }

        if (position == 0) {
            insert(input);
        } else {

            Node head = this.head;

            for (int i = 1; i < position; i++) {
                head = head.next;
            }
            Node tmp = new Node(input);
            tmp.next = head.next;
            head.next = tmp;
            this.count++;
        }
    }

    public boolean isEmpty() { // 리스트가 비어있는지 검사	check whether the list is empty or not
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void delete() {	// 맨앞의 노드를 삭제
        this.head = this.head.next;
        this.count--;
    }
    public void delete(int position) {    // position 위치의 노드를 삭제		delete a Node at the given position
        if (position > count || position < 0) {
            System.out.println("position value - out of range.");
            return;
        }

        if (position == 0) {
            this.delete();
        } else {

            Node head = this.head;
            Node tmp = head;

            for (int i = 0; i < position; i++) {
                tmp = head;
                head = head.next;
            }

            tmp.next = head.next;
            head = null;
            count--;
        }
    }
    public void print_list() {
        Node temp = head;
        for (int i = 0; i < count; i++) { // 노드 출력
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println("");
    }

}
