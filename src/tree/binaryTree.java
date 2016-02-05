package tree;

class Node{
	private int data;
	private Node left;
	private Node right;
	
	public Node(){
		data = 0;
		left = null;
		right = null;
	}
	public Node(int data){
		this.data = data;
		left = right = null;
	}
	
	public void setLeft(Node l){
		this.left = l;
	}
	public void setRight(Node r){
		this.right = r;
	}
	public void setData(int data){
		this.data = data; 
	}
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public int getData(){
		return data;
	}
}


class BT{
	private Node root;
	public BT(){
		root = null;
	}
	public void insert(int data){
		insert(root , data);
	}
	private void insert(Node root,int data){
		if(root == null){
			root = new Node(data);
		}else{
			if(root.getLeft() == null){
				root.setLeft(new Node(data));
			}else if(root.getRight() == null){
				root.setRight(new Node(data));
			}else{
				insert(root.getLeft(),data);
			}
		}	
	}
	
	public int countNode(Node root){
		if(root!=null){
			return countNode(root.getLeft()) + countNode(root.getRight()) +1;
		}
		return 0;
	}
	
	public boolean searchNode(Node root,int i){
		
		if(root != null){
			if( root.getData() == i ){
				return true;
			}else{
					searchNode(root.getLeft(),i);
					searchNode(root.getRight(),i);
			}
		}
		return false;
	}
	
	public void preOrder(Node root){
		if(root != null){
			System.out.print(root.getData() + " ");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	
	public void inOrder(Node root){
		if(root != null){
			preOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			preOrder(root.getRight());
		}
	}
	public void postOrder(Node root){
		if(root != null){
			preOrder(root.getLeft());
			preOrder(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
}

public class binaryTree {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
