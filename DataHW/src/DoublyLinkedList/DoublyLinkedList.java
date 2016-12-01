package DoublyLinkedList;

/**
 * Created by shinsy1023 on 2016. 10. 3..
 */
class DoublyLinkedList {
    private Node header;
    private Node trailer;
    private int size;

    private class Node {
        String name;
        String phone;
        Node prev;
        Node next;

        Node(String name, String phone) {
            this.name = name;
            this.phone = phone;
            prev = null;
            next = null;
        }
    }

    /*
     * size 0
     */
    public DoublyLinkedList() {
        size = 0;
    }

    /*
     * size가 0, 1, 그 이상일 때를 나눠서 각자 처리
     */
    public void addFirst(String name, String phone) {
        if (this.size == 0) {
            header = new Node(name, phone);
            header.next = trailer;
            trailer = header;
        } else if (this.size == 1) {
            Node tmp = new Node(name, phone);
            header.next = tmp;
            tmp.prev = header;
            trailer = tmp;
        } else {
            Node tmp = new Node(name, phone);
            tmp.next = header;
            header.prev = tmp;
            header = tmp;
        }
        this.size++;
    }


    /*
     * size가 0, 1이면 addFirst 호출 그 외엔 스스로 처리
     */
    public void addLast(String name, String phone) {
        if (this.size == 0 || this.size == 1) {
            addFirst(name, phone);
        } else {
            Node tmp = new Node(name, phone);
            tmp.prev = trailer;
            trailer.next = tmp;
            trailer = tmp;
            this.size++;
        }
    }

    /*
     * position이 0, 1이면 addFirst 호출, size와 같으면 addLast 호출,
     * 그 외엔 size의 절반보다 작으면 header부터 추적,
     * 크면 trailer부터 추적
     */
    public void addAt(int position, String name, String phone) {
        if (position == 1 || position == 0) {
            addFirst(name, phone);
        } else if (position == size + 1){
            addLast(name, phone);
        } else if (position == size) {
            Node adder = new Node(name, phone);
            trailer.prev.next = adder;
            adder.prev = trailer.prev;
            trailer.prev = adder;
            adder.next = trailer;
            this.size++;
        } else if (position < size / 2) {
            Node tmp = header;
            Node adder = new Node(name, phone);
            for (int i = 1; i < position; i++) {
                tmp = tmp.next;
            }
            adder.next = tmp.next;
            adder.prev = tmp;
            adder.next.prev = adder;
            tmp.next = adder;
            this.size++;
        } else {
            Node tmp = trailer;
            Node adder = new Node(name, phone);
            for (int i = 0; i < size - position + 1; i++) {
                tmp = tmp.prev;
            }
            adder.next = tmp.next;
            adder.prev = tmp;
            adder.next.prev = adder;
            tmp.next = adder;
            this.size++;
        }
    }

    /*
     * 0이면 error 출력, 1이면 head 를 초기화
     * 그 외엔 알아서 처리
     */
    public void removeFirst() {
        if (size == 0) {
            System.out.printf("error\n");
        } else if (size == 1) {
            header = null;
            this.size--;
        } else {
            header = header.next;
            header.prev = null;
            this.size--;
        }
    }

    /*
     * 0이나 1이면 removeFirst 호출,
     * 그 외엔 알아서 처리
     */
    public void removeLast() {
        if (size == 0 || size == 1) {
            removeFirst();
        } else {
            trailer = trailer.prev;
            trailer.next = null;
            this.size--;
        }
    }

    /*
     * 0이나 1이면 removeFirst 호출,
     * size와 같으면 removeLast 호출,
     * 그 외엔 add와 같은 방식으로 처리
     */
    public void removeAt(int position) {
        if (position == 0 || position == 1) {
            removeFirst();
        } else if (position == this.size) {
            removeLast();
        } else if (position < size / 2) {
            Node tmp = header;
            for (int i = 1; i < position; i++) {
                tmp = tmp.next;
            }
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            tmp = null;
            this.size--;
        } else {
            Node tmp = trailer;
            for (int i = 0; i < size - position; i++) {
                tmp = tmp.prev;
            }
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            tmp = null;
            this.size--;
        }
    }

    /*
     *
     */
    public void printList() {
        Node tmp = header;
        for (int i = 0; i < this.size; i++){
            System.out.printf("name : %s phone : %s -> ", tmp.name, tmp.phone);
            tmp = tmp.next;
        }
        System.out.printf("\n");
    }

    /*
     *
     */
    public void printListBack() {
        Node tmp = trailer;
        for (int i = 0; i < this.size; i++){
            System.out.printf("name : %s phone : %s -> ", tmp.name, tmp.phone);
            tmp = tmp.prev;
        }
        System.out.printf("\n");
    }
}