package test2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by shinsy1023 on 2016. 5. 9..
 */
class DataStructure {
    int i;
    stack s=new stack();
    linked_list link=new linked_list();
    queue q=new queue();
    binary_tree b=new binary_tree();
    RandomNum rand=new RandomNum();
    DataStructure() {
        for (i = 0; i < 100000; i++){
            s.insert(rand.randList.get(i));
            link.insert(rand.randList.get(i));
            q.insert(rand.randList.get(i));
            b.insert(rand.randList.get(i));
//            s.insert(hello[i]);
//            link.insert(hello[i]);
//            q.insert(hello[i]);
//            b.insert(hello[i]);
        }
    }
}

class stack {
    Node top = null;
    long i;
    private class Node {
        long num;
        Node next = null;

        Node(long num) {
            this.num = num;
        }
    }

    public void insert(long num) {
        if (top==null){
            top=new Node(num);
        }else {
            Node tmp = top;
            top = new Node(num);
            top.next = tmp;
        }
    }

    public long pop() {
        i = top.num;
        top = top.next;
        return i;
    }

    public boolean search(long num) {
        Node tmp=top;
        while (true) {
            if (tmp.num != num) {
                tmp=tmp.next;
            } else {
                System.out.printf("%d Hello\n", num);
                return true;
            }
        }
    }
}

class linked_list {
    Node head = null;

    private class Node {
        long num;
        Node next = null;

        Node(long num) {
            this.num = num;
        }
    }

    public void insert(long num) {
        if (head==null){
            head=new Node(num);
        }else {
            Node tmp=head;
            while (true) {
                if (tmp.next == null) {
                    tmp.next = new Node(num);
                    break;
                } else {
                    tmp = tmp.next;
                }
            }
        }
    }

    public boolean search(long number) {
        Node tmp = head;
        while (true) {
            if (tmp.num != number) {
                tmp = tmp.next;
            } else {
                System.out.printf("%d Hello\n", tmp.num);
                return true;
            }
        }
    }
}

class queue {
    Node head=null;
    Node tail=null;
    private class Node {
        long num;
        Node next = null;
        Node prev=null;

        Node(long num){
            this.num=num;
        }
    }
    long i;

    public void insert(long num) {
        if(head==null){
            head=new Node(num);
        }else {
            Node tmp=head;
            while (true) {
                if (tmp.next == null) {
                    tmp.next = new Node(num);
                    tail = tmp.next;
                    break;
                } else {
                    tmp.prev = tmp;
                    tmp = tmp.next;
                }
            }
        }
    }

    public long get() {
        i=tail.num;
        tail.prev=tail.prev.prev;
        tail=tail.prev;
        return i;
    }

    public boolean search(long num){
        Node tmp=head;
        while(true){
            if (tmp.num!=num){tmp=tmp.next;}else{
                System.out.printf("%d Hello\n", tmp.num);
                return true;
            }
        }
    }
}

class binary_tree {
    Node root = null;

    private class Node {
        long num;
        Node lChild = null;
        Node rChild = null;

        Node(long num) {
            this.num = num;
        }
    }

    public void insert(long num) {
        if (root == null) {
            root = new Node(num);
        } else {
            Node tmp = root;
            while (true) {
                if (tmp.lChild == null && tmp.num > num) {
                    tmp.lChild = new Node(num);
                    break;
                } else if (tmp.rChild == null && tmp.num < num) {
                    tmp.rChild = new Node(num);
                    break;
                } else if (tmp.num > num) {
                    tmp = tmp.lChild;
                } else if (tmp.num < num) {
                    tmp = tmp.rChild;
                }
            }
        }
    }

    public boolean search(long num) {
        Node tmp = root;
        while (true) {
            if (tmp.num == num) {
                System.out.println(num+" Hello");
                return true;
            } else if (tmp.num > num) {
                tmp = tmp.lChild;
            } else if (tmp.num < num) {
                tmp = tmp.rChild;
            }
        }
    }
}

class RandomNum {
    long rand;
    Random rng=new Random();
    long i;
    ArrayList<Long> randList=new ArrayList<Long>();
    RandomNum(){
        for(i=0; i<100000; i++){
            rand=rng.nextInt(200000);
            while(randList.contains(rand)){
                rand=rng.nextInt(200000);
            }
            randList.add(rand);
        }
    }
}