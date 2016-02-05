package tree;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;

class BSTNode {
	private int data;

	private Node left, right;

	public BSTNode() {
		data = 0;
		left = right = null;
	}

	public BSTNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}

class BST {
	private Node root;

	public BST() {
		root = null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node root, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			if (root.getData() > data) {
				root.setLeft(insert(root.getLeft(), data));
			} else if (root.getData() < data) {
				root.setRight(insert(root.getRight(), data));
			} else {
				System.out.println(data + " exist");
			}
		}

		return root;
	}

	public boolean search(int data) {
		Node temp = root;
		while (temp != null) {

			if (temp.getData() < data) {
				temp = temp.getRight();
			} else if (temp.getData() > data) {
				temp = temp.getLeft();
			} else {
				return true;
			}
		}
		return false;
	}

	public void preOrderNoRecurse() {
		Stack<Node> stack = new Stack<Node>();

		while (!stack.isEmpty() || root != null) {

			if (root != null) {
				System.out.println(root.getData());
				stack.push(root);
				root = root.getLeft();
			} else {
				root = stack.pop();
				root = root.getRight();
			}

		}
	}

	public void inOrderNoRecurse() {
		Stack<Node> stack = new Stack<Node>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				root = stack.pop();
				System.out.println(root.getData());
				root = root.getRight();
			}
		}
	}
	
	public void levelOrder(){
		ArrayList<Node> queue = new ArrayList<Node>();
		Node node = root;
		while(!queue.isEmpty() || node!=null){
			if(node!=null){
				queue.add(node.getLeft());
				queue.add(node.getRight());
				System.out.println(node.getData());
			}
			node = queue.remove(0);
		}
	}

	
	public void postOrder(){
		postOrder(root);
	}
	private void postOrder(Node root){
		if(root == null){
			return;
		}else{
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData()+"--");
		}
	}
	
	public void postOrderNoRecuese(){
		Stack<Node> stack = new Stack<Node>();
		Node pre = null;
		Node current = root;
		while(current != null || !stack.isEmpty() ){
			if(current!=null){
				
				stack.push(current);
				current = current.getLeft();
				
			}else{
				current = stack.peek();
				
				if(current.getLeft() == null && current.getRight() == null){
					System.out.println(current.getData());
					pre = current;
					current = null;
					stack.pop();
				}else{
					if(current.getLeft() == pre){
						//System.out.println(pre);
						current = current.getRight();
						pre = current;
					}else if(current.getRight() == pre){
						System.out.println(current.getData());
						pre = current;
						stack.pop();
						current = null;
	
					}
				}
				
			}
		
		}
	}

}

public class binarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST bst = new BST();
		bst.insert(5);
		bst.insert(4);
		bst.insert(1);
		bst.insert(7);
		bst.insert(6);
		bst.insert(2);
		
		bst.postOrder();
		System.out.println("");
		bst.postOrderNoRecuese();
		System.out.println("----");
		bst.levelOrder();
		
	}

}
