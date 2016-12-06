package Quiz3;

public class Run {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        int[] arr = {70, 30, 15, 5, 27, 55, 42, 69, 110, 95, 87, 100, 135, 124, 146};
//        QuickSort sort = new QuickSort();
//        sort.sort(arr);
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);
        tree.insert(45);
        tree.insert(55);
        tree.insert(65);
        tree.insert(75);
        tree.insert(85);
        tree.printPreorder(tree.getRoot());
        System.out.println();
        tree.delete(70);
        tree.printPreorder(tree.getRoot());
        System.out.println();
        //50 30 20 15 25 40 35 45 75 60 55 65 80 85
        tree.delete(75);
        tree.printPreorder(tree.getRoot());
        System.out.println();
        //50 30 20 15 25 40 35 45 80 60 55 65 85
    }
}
