package Queue;

/**
 * Created by shinsy1023 on 2016. 10. 17..
 */

public class Queue_prob {
    private Node front;
    private Node back;

    private class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
        }
    }
    public Queue_prob() {
        front = null;
        back = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            this.front = newNode;
            this.back = newNode;
        } else {
            this.back.next = newNode;
            this.back = this.back.next;
        }
    }

    public Node dequeue() {
        if (!isEmpty()) {
            Node returnNode = this.front;
            this.front = this.front.next;
            return returnNode;
        } else {
            return null;
        }
    }

    public void printQueue() {
        if (!isEmpty()) {
            Node findBack = this.front;
            while (findBack != this.back) {
                System.out.printf("%d -> ", findBack.data);
                findBack = findBack.next;
            }
            System.out.printf("%d\n", findBack.data);
        }
    }

    public boolean isEmpty(){
        if(front == null){
            return true;
        } else {
            return false;
        }
    }

}
