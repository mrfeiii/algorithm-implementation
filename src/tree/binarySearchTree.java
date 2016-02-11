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
	
	public void Max(){
		Node temp = root;
		if(temp == null){
			return;
		}
		while(temp.getLeft()!=null){
			temp = temp.getLeft();
		}
		System.out.println(temp.getData());
	}
	
	public void floor(int n){
		
	}
	
	private Node floor(Node root,int n){
		if(root == null){
			return null;
		}
		if(root.getData() == n){
			return root;
		}
		if(root.getData() > n ){
			return floor(root.getLeft(),n);
		}
		
		Node t = floor(root.getRight(),n);
		if(t == null){
			return root;
		}else{
			return t;
		}
		
	}
	
	private Node ceil(Node root,int n){
		if (root == null){
			return null;
		}
		
		if(root.getData() == n){
			return root;
		}
		
		if(root.getData() < n){
			return ceil(root.getRight(),n);
		}
		
		Node t = ceil(root.getLeft(),n);
		if(t == null){
			return root;
		}else{
			return t;
		}
		
	}
	
	//Rank, how many keys < n;
	private int rank(Node node,int n){
		
		if(node == null) {
			return 0;
		}
		
		if(node.getData() == n){
			return node.count;
		}
		
		if(node.getData() > n){
			return rank(node.getLeft(),n);
		}
		
		if(node.getData() < n){
			return node.getLeft().count + node.getRight().count;
		}
		
	}
	
	private Node deleteMin(Node n){
		if(n.getLeft() == null){
			return n.getRight();
		}
		n.getLeft() = deleteMin(n.getLeft());
		n.count = n.getLeft().count + n.getRight().count + 1;
		return n;
	}
	
	private Node deleteNode(Node root,int value){
		if(root == null){
			return null;
		}
		if(root.getData() > value){
			root.getLeft() = deleteNode(root.getLeft(),value);
		}else if(root.getData() < value){
			root.getRight() = deleteNode(root.getRight(),value);
		}else{
			if(root.getRight() == null){
				return root.getLeft();
			}
			
			Node t = root;
			root = min(root.getRight());
			root.getRight() = deleteMin(t.getRight());
			root.getLeft() = t.getLeft();
		}
		
		root.count = 1 + root.getLeft().count + root.getRight().count;
		return root;
	}
	
	
}

public class binarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BST bst = new BST();
		
		String s = "ww";
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
