package tree;

class BSTNode{
	private int data;
	
	private Node left,right;
	
	public BSTNode(){
		data = 0;
		left = right = null;
	}
	public BSTNode(int data){
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
class BST{
     private Node root;
     
     public BST(){
    	 root = null;
     }
     
     public void insert(int data){
    	root = insert(root,data);
     }
     
     private Node insert(Node root,int data){
    	 if(root == null){
    		 root = new Node(data);
    	 }else{
    		 if(root.getData() > data){
    			 root.setLeft( insert(root.getLeft(),data) );
    		 }else if(root.getData() < data ){
    			 root.setRight( insert(root.getRight(),data) );
    		 }else{
    			 System.out.println(data + " exist");
    		 }
    	 }
    	 
    	 return root;
     }
     
     public boolean search(int data){
    	 Node temp = root;
    	 while( temp != null){
    		 
    		 if(temp.getData() < data){
    			 temp = temp.getRight();
    		 }else if(temp.getData() > data ){
    			 temp = temp.getLeft();
    		 }else{
    			 return true;
    		 }
    	 }
    	 return false;
     }
     
     
     
     
	
}
public class binarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
