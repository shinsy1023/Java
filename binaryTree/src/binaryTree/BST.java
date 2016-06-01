package binaryTree;

public class BST{
	public Node root;
	private class Node{
		private int key;
		private Node lchild;
		private Node rchild;
		Node (int key){
			this.key = key;
			this.lchild = null;
			this.rchild = null;
			
		}
	}
	
	void insert(int key){
		if(root ==null){
			root = new Node(key);
		}else{
			Node temp = root;
			//key의 위치를 찾아 들어가서 올바른 위치에 새로운 노드를 만들어주고 break;
			while(true){
				if(temp.lchild == null && temp.key>key){
					temp.lchild = new Node(key);
					break;
				}else if(temp.rchild == null && temp.key<key){
					temp.rchild = new Node(key);
					break;
				}else if(temp.key<key){
					temp = temp.rchild;
				}else if(temp.key>key){
					temp = temp.lchild;
				}else{
					System.out.println("위치값이 잘못되었습니다.");
				}
			}
		}
	}
	Node search(int key){
		Node temp = root;
		if(temp.key == key){
			return temp;
		}else{
			//적절한 위치의 Node를 return
			while(true){
				//위치값이 잘못되으면 return null;
				if(temp==null){
					System.out.println(key+"가 없음");
					return null;
				}else if(temp.key == key){
					System.out.println(key+"가 있음");
					return temp;
				}else if(temp.key>key){
					temp = temp.lchild;
				}else if(temp.key<key){
					temp = temp.rchild;
				}
			}
		}
	}
	void delete(int key){
		if(root == null){
			System.out.println("트리가 비어있습니다.");
		}else{
			Node temp = root;
			while(temp!=null){
				// root일 경우 
				if(root.key == key){
					Node max = root;
					// child가 없을 경우 root 제거
					if(root.lchild == null && root.rchild == null){
						root = null;
					}else if(root.lchild == null){
						while(root.rchild.rchild!=null){
							max = max.rchild;
						}
						root.key = max.rchild.key;
						max.rchild = null;
						break;
					}else{
						//child를 찾아가며 root 변경
						if(max.lchild.rchild == null){
							Node sub = root.rchild;
							root = max.lchild;
							root.rchild = sub;
							break;
						}else{
							max = max.lchild;
							while(max.rchild.rchild!=null){
								max = max.rchild;
							}
							root.key = max.rchild.key;
							max.rchild = null;
							break;
						}
					}
				}
				// 올바른 위치를 찾은 뒤 node의 key값을 변경, pointer를 가지고 해야하기 때문에 전 노드까지 찾은뒤 변경
				if(temp.lchild !=null && temp.lchild.key == key){
					Node max = temp.lchild;
					if(max.lchild == null && max.rchild == null){
						temp.lchild = null;
						break;
					}else if(max.lchild == null){						
						while(max.rchild.rchild !=null){
							max = max.rchild;
						}
						temp.lchild.key = max.rchild.key;
						max.rchild = null;
						break;
					}else{
						if(max.lchild.rchild ==null){
							Node sub = max.rchild;
							temp.lchild = max.lchild;
							temp.lchild.rchild = sub;
							break;
						}else{
							max = max.lchild;
							while(max.rchild.rchild != null){
								max = max.rchild;
							}
							temp.lchild.key = max.rchild.key;
							max.rchild = null;
							break;
						}
					}
				}else if(temp.rchild!=null && temp.rchild.key == key){
					Node max = temp.rchild;
					if(max.lchild == null && max.rchild == null){
						temp.rchild = null;
						break;
					}else if(max.lchild == null){						
						while(max.rchild.rchild !=null){
							max = max.rchild;
						}
						temp.rchild.key = max.rchild.key;
						max.rchild = null;
						break;
					}else{
						if(max.lchild.rchild ==null){
							Node sub = max.rchild;
							temp.rchild = max.lchild;
							temp.rchild.rchild = sub;
							break;
						}else{
							max = max.lchild;
							while(max.rchild.rchild != null){
								max = max.rchild;
							}
							temp.rchild.key = max.rchild.key;
							max.rchild = null;
							break;
						}
					}
				}else if(temp.key>key){
					temp = temp.lchild;
				}else if(temp.key<key){
					temp = temp.rchild;
				}
			}
			
		}
	}
	private void print_preorder(Node root){
		if(root!=null){
			System.out.print(root.key+" ");
			print_preorder(root.lchild);
			print_preorder(root.rchild);
		}
	}
	private void print_inorder(Node root){
		if(root!=null){
			print_inorder(root.lchild);
			System.out.print(root.key+" ");
			print_inorder(root.rchild);
		}
	}
	private void print_postorder(Node root){
		if(root!=null){
			print_postorder(root.lchild);
			print_postorder(root.rchild);
			System.out.print(root.key+" ");
		}
	}
	void print_preorder(){
		if(root!=null){
			print_preorder(root);
		}
	}
	void print_inorder(){
		if(root!=null){
			print_inorder(root);
		}
	}
	void print_postorder(){
		if(root!=null){
			print_postorder(root);
		}
	}
}
