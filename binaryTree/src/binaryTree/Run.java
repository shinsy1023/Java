package binaryTree;

public class Run{
	public static void main(String[] args){
		// 5 3 2 1 4  8 6 7 10 9 순으로 insert 
		BST bst = new BST();
		bst.insert(5);
		bst.insert(3);
		bst.insert(2);
		bst.insert(1);
		bst.insert(4);
		bst.insert(8);
		bst.insert(6);
		bst.insert(7);
		bst.insert(10);
		bst.insert(9);
		bst.search(7);
		bst.print_preorder();
		System.out.println();
		bst.print_inorder();
		System.out.println();
		bst.print_postorder();
		System.out.println();
		bst.delete(8);
		bst.delete(5);
		bst.delete(2);
		bst.search(8);
		bst.print_preorder();
	}
}
