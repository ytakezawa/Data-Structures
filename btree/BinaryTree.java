package btree;
//from slides and working on the exercise booklet????
import java.io.*;

public class BinaryTree<E>  {
	protected static class Node<E>{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}
		public String toString() {
			return data.toString();
		}
	}
	
	protected Node<E> root;
	public BinaryTree() {
		root = null;
	}
	protected BinaryTree(Node<E> root) {
		this.root = root;
	}
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		}else {
			root.right = null;
		}
	}
	
	public BinaryTree<E> getLeftSubtree(){
		if (root != null && root.left != null) {
			return new BinaryTree<E>(root.left);
		}else {
			return null;
		}
	}
	
	public boolean isLeaf() {
		return (root == null || (root.left == null && root.right == null));
	}
	
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		for (int i = 1; i<depth; i++) {
			sb.append("  ");
		}
		if (node == null) {
			sb.append("null\n");
		}else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth+1, sb);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}
}
