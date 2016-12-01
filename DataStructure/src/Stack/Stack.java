package Stack;

/**
 * Created by shinsy1023 on 2016. 10. 17..
 */
class Stack {
    private Node top;
    private class Node {
        private String data;
        private Node next;
        Node(String data){
            this.data = data;
        }
    }

    // Constructor (생성자)
    public Stack() {
        top = null;
    }

    /*
     * Stack 안에 있는 elements 의 개수를 반환한다.
     */
    public int size(){
        int size = 0;
        Node findNull = this.top;
        while (findNull.next != null){
            size++;
            findNull = findNull.next;
        }
        return size+1;
    }

    /*
     * Stack이 비어있는지를 반환한다.
     */
    public boolean isEmpty(){
        if (top == null){
            return true;
        }
        return false;
    }

    /*
     * Stack의 top 자리에 data를 가지는 Node를 삽입한다.
     */
    public void push(String data){
        Node newTop = new Node(data);
        newTop.next = this.top;
        top = newTop;
    }

    /*
     * Stack의 top을 반환한다. (제거 x)
     */
    public String top() {
        return top.data;
    }


    /*
     * Stack의 top을 제거하며, 제거한 Node를 반환한다.
     */
    public Node pop(){
        Node returnNode = this.top;
        top = returnNode.next;
        return returnNode;
    }


    /*
     * Stack 을 top부터 마지막 Node까지 출력한다.
     */
    public void printStack(){
        Node findNull = this.top;
        while (findNull.next != null){
            System.out.printf("%s -> ", findNull.data);
            findNull = findNull.next;
        }
        System.out.printf("%s\n", findNull.data);
    }
}
